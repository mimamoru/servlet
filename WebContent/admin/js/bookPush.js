$(function() {




$("select[name='order']").on('change', function() {
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

	switch(Number(selectedOrder)) {
		case 0:
			return $(next).find(".form-check-input").attr("value") - $(prev).find(".form-check-input").attr("value")
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
 		return
 	}
 	//event.preventDefault();
 	word=word.toLowerCase();
 	$('#table1>tr').each(function(e) {
 		const title=$(this).find(".form-check-label").text().toLowerCase();
 		 console.log(title)
 		if(title.indexOf(word)<0){
 			$(this).addClass("nohit");
 		}else{
 			$(this).removeClass("nohit");
 		}
	})
});

$('#sbtn2').on('click', function(){

		$('#table1>tr').removeClass("nohit");

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
			        $("#table2").append("<tr><td><input name=\"ourBook_id\" class=\"form-check-input\" type=\"checkbox\"  value=\""+e.id+"\"></td><td><label class=\"form-check-label\" for=\"check1a\">"+e.name+"</label></td></tr>")
						//names.push("<tr><td>"+e.name()+"</tr></td>");
						 });

			        })
			        .fail((data) => {
			        console.log(data+"!!!!")

			        })
        });


})