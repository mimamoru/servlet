const delfunc1=function(c){

	if ($(c).length>0){
		$("#del1").addClass("d-flex");
		$("#del1").children().eq(0).addClass("col-6");
		$("#del1").children().eq(1).addClass("col-3");
		$("#del1").children().eq(2).addClass("col-3");
		$('#share-btn').fadeIn("slow")
     }else{
		$('#share-btn').hide()
}
return
}
const delfunc2=function(c){
	if ($(c).length>0){
		$("#del2").addClass("d-flex");
		$("#del2").children().eq(0).addClass("col-8");
		$("#del2").children().eq(1).addClass("col-4");
		$('#cancel').fadeIn("slow")
     }else{
		$('#cancel').hide()
}
return
}

$(function() {

	$(".form-check-input1").on('click',function() {
		const checks=$('input:checkbox[name="book_id"]:checked')
		console.log($(checks).length+"kkkkk")
		delfunc1(checks)
	});

	$(".form-check-input2").on('click',function() {
		const checks=$('input:checkbox[name="ourBook_id"]:checked')
		console.log($(checks).length)
		delfunc2(checks)
	});


$(".order").on('change', function() {
    const selectedOrder = $(this).val()
    let table
    if($(this).hasClass("select1")){
    	table = $("#table1")
    	console.log(table)
    }else{
    	table = $("#table2")
        }
    const list = table.find("tr")

const sorted =
	list.sort((prev, next) => {
		console.log(Number(selectedOrder))
	switch(Number(selectedOrder)) {

		case 0:
			return $(next).find('input:checkbox[type="checkbox"]').attr("value") - $(prev).find('input:checkbox[type="checkbox"]').attr("value")
		case 1:
			// タイトル順
			return $(prev).find(".form-check-label").text() > $(next).find(".form-check-label").text()?1:-1
		case 2:

			return Date.parse($(next).find(".form-modified").val())- Date.parse($(prev).find(".form-modified").val())
	}
})

// テーブル再描写
table.children().remove()
sorted.map((index, elm) => {
	table.append(elm)
	console.log($(elm).find(".form-check-label").text())
 })
})



$('#sbtn1').on('click', function(){
	 let word=$("#sbox1").val();
 	 console.log(word)
 	if(word==""){
 		alert("検索ワードを入力してください")
 		return
 	}
 	//event.preventDefault();
 	word=word.toLowerCase();
 	$('#table1>tr').each(function(e) {
 		const title=$(this).find(".form-check-label").text().toLowerCase();
 		const check=$(this).find(".form-check-input1");
 		if(title.indexOf(word)<0){
 			$(check).prop("checked", false);
			$(this).removeClass("d-flex");
			$(this).children().eq(0).removeClass("col-6");
			$(this).children().eq(1).removeClass("col-3");
			$(this).children().eq(2).removeClass("col-3");
			$(this).addClass("nohit");
 		}else{
 			console.log(title)
 			$(this).removeClass("nohit");
 			$(this).addClass("d-flex");
			 $(this).children().eq(0).addClass("col-6");
			 $(this).children().eq(1).addClass("col-3");
			 $(this).children().eq(2).addClass("col-3");
 		}
	})
});

$('#sbtn2').on('click', function(){
	$('#table1 tr').removeClass("nohit");
	$('#table1 tr').each(function() {
	$(this).addClass("d-flex");
	$(this).children('td').eq(0).addClass("col-6");
	$(this).children('td').eq(1).addClass("col-3");
	$(this).children('td').eq(2).addClass("col-3");
	})
//		$('#table1>tr').removeClass("nohit");

});

$('#share-btn').on('click',function() {
	console.log("sharebtn")
	const check_count = $('input:checkbox[name="book_id"]:checked').length;
	if(check_count==0){
					alert('共有カードを選択してください')
	    				return false;
	    			}
});

$('#share').on('click',function() {

	const url='BookPushConfServlet';
	const name=$("#share-name").val()
	const pass=$("#share-pass").val()

	if(name==""||pass==""){
		alert('name,passwordを入力してください')
		return false
	}
	$.ajax({
        url: url,
        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
        data: {
        	name : name,
        	pass : pass
        },
        dataType:"json"
        }) .done(function(data) {
	        console.log(data.ob_id)
	        const ob_id=data.ob_id;
	       if(ob_id>0){
	    		const url2='BookPushServlet';
	    		const b_ids=[]
	    		const checks='input:checkbox[name="book_id"]:checked'

	    		$(checks).each(function() {
	    			b_ids.push($(this).attr("value"))
	    		})
	    	   $.ajax({
			        url: url2,
			        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
			        data: {
			        	b_ids : b_ids,
			        	ob_id : ob_id
			        },
			        dataType:"text"
			        })
	       }else{
	    	   alert('name,passwordが重複しています')
	    	    return false;
		        //window.location.href = 'BookPushListServlet';
	       }
	       alert('共有しました')
	        window.location.href = 'BookPushListServlet';

	        })
	        .fail((data) => {
	        console.log(data+"!!!!")
	        alert('共有に失敗しました')
	        return false;
	        //window.location.href = 'BookPushListServlet';
	        })
        });

$('#cancel').on('click',function() {
	const checks='input:checkbox[name="ourBook_id"]:checked'

	if($(checks).length==0){
		alert('削除するファイルを選択してください')
		return false
	}
	if (!confirm('本当に削除しますか')) {
        return
     }
	const url='BookODelServlet';

	const ob_ids=[]
	const elm=[]

		$(checks).each(function() {
			elm.push($(this).parents("tr"))
			ob_ids.push($(this).val())


		})
		console.log(ob_ids[0])

			$.ajax({
		        url: url,
		        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
		        data: {
		        	ob_ids : ob_ids

		        }

		        }) .done(function() {

			       // console.log(data)
			        elm.forEach( function( e ) {
						e.remove();
						 });

			        })
			        .fail((data) => {
			        console.log(data+"!!!!")

			        })
        });

$('#panel2').on('click',function() {

	const url='BookOServlet';
	//const names=[];
			$.ajax({
		        url: url,
		        type: "GET", // HTTPメソッドを指定（デフォルトはGET）
		        dataType:"json"
		        }) .done(function(data) {

			        console.log(data)
			         $("#table2").children().remove()
			        data.forEach( function(e) {
			        $("#table2").append("<tr class=\"d-flex\"><td class=\"col-8\"><label class=\"form-check-label\" for=\"check1a\">"+e.name+"</label></td><td class=\"form-check col-4\"><input name=\"ourBook_id\" class=\"form-check-input2\" type=\"checkbox\"  value=\""+e.id+"\"></td></tr>")
						//names.push("<tr><td>"+e.name()+"</tr></td>");
						 });

			        })
			        .fail((data) => {
			        console.log(data+"!!!!")

			        }).always(() => {

			         $("#bookList2").addClass("table-o")
			        }
			        		)
        });
$(".backbtn").on('click', function(){
	window.location.href = 'BookMainServlet';
})

})