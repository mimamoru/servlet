const switc1=function(select,element){switch(element){
case "1": return select.css("background-color","red")
case "2": return select.css("background-color","yellow")
case "3": return select.css("background-color","green")
case "4": return select.css("background-color","#3fb2bf")
case "5": return select.css("background-color","blue")
default:  return select.css("background-color","gray")
}}
const switc2=function(kind_num){switch(kind_num){
case "1": return $("#bookList").addClass("table-r")
case "2": return $("#bookList").addClass("table-y")
case "3": return $("#bookList").addClass("table-g")
case "4": return $("#bookList").addClass("table-s")
case "5": return $("#bookList").addClass("table-b")
default:  return $("#bookList").addClass("table-d")
}}

const delfunc=function(c){
	if ($(c).length>0){
		$("#del").addClass("d-flex");
		$("#del").children().eq(0).addClass("col-2");
		$("#del").children().eq(1).addClass("col-2");
		$("#del").children().eq(2).addClass("col-3");
		$("#del").children().eq(3).addClass("col-3");
		$("#del").children().eq(4).addClass("col-2");
		$('#delete-button').fadeIn("slow")
     }else{
		$('#delete-button').hide()
}
return
}

$(function() {

const kind_num=$('#kind_num').val();
switc2(kind_num);
$('.favorite-btn').each(function() {
	 if($(this).attr("value")=="true"){
		 $(this).toggleClass('active');
     }

});


//const switc1=function(select,element){switch(element){
//case "1": return select.css("background-color","red")
//case "2": return select.css("background-color","yellow")
//case "3": return select.css("background-color","green")
//case "4": return select.css("background-color","#3fb2bf")
//case "5": return select.css("background-color","blue")
//default:  return select.css("background-color","gray")
//}}

$('.type-drop').each(function() {
	const select=$(this).parents(".s1")
	const option=$(this).attr("value")
	 let element=select.prev().val();
	 select.val(element);
	 switc1(select,element);
});



 $('.favorite-btn').on('click', function(event){
	 	const url='TextFavoriteServlet';
	 	let favorite;
	 	const id=$(this).next().attr("value");
        event.preventDefault();
        $(this).toggleClass('active');

        if($(this).hasClass('active')){
        	favorite ="true";
        } else {
        	favorite = "false";
        }
        $.ajax({
	        url: url,
	        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
	        data: {
	        	id : id,
	        	favorite : favorite,
	        },
	        dataType:"text"
	        })
	        .done(function(data) {
	        console.log(data)
	        })
	        .fail((data) => {
	        console.log(data+"!!!!")
	        })
   });

$(".option-input06").on('click',function() {

	const checks=$('input:checkbox[name="myBook_id"]:checked')

	console.log($(checks).length)
	delfunc(checks)

});


$('#delete-button').on('click',function() {
	const checks=$('input:checkbox[name="myBook_id"]:checked')

//	if ($(checks).length==0){
//		alert("削除するカードを選択してください")
//        return false
//     }
	if (!confirm('本当に削除しますか')) {
        return false
     }
	const url='TextDeleteServlet';
const book_ids=[]
	const myBook_ids=[]
	const elm=[]
		$(checks).each(function() {

			myBook_ids.push($(this).val()),
			book_ids.push($(this).next().val())
			elm.push($(this).parents("tr"))

		})

			$.ajax({
		        url: url,
		        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
		        data: {
		        	book_ids : book_ids,
		        	myBook_ids : myBook_ids
		        },
		        dataType:"text"
		        }) .done(function(data) {

			        console.log(data)
			        elm.forEach( function( e ) {
						e.remove();
						 });

			        })
			        .fail((data) => {
			        console.log(data+"!!!!")

			        })
        });

$("#order").on('change', function() {

    const selectedOrder = $(this).val()
    const bookTable = $("#tbody")
    const bookList = bookTable.find("tr")

const sorted =
bookList.sort((prev, next) => {

	switch(Number(selectedOrder)) {
		case 0:
			return $(next).find(".mbid").attr("value") - $(prev).find(".mbid").attr("value")
		case 1:
			// タイトル順
			return $(prev).find("a").text() > $(next).find("a").text()?1:-1
		case 2:
			return Date.parse($(next).find(".modified").attr("value"))- Date.parse($(prev).find(".modified").attr("value"))
	}
})

// テーブル再描写
bookTable.children().remove()
sorted.map((index, elm) => {
	bookTable.append(elm)
	console.log($(elm).find("a").text())
 })


})
//const select=$(this).parents(".s1")
//	const option=$(this).attr("value")
//	 let element=select.prev().val();
//	 select.val(element);
//	 switc1(self,num);
$('.s1').on('change', function(event){
	const self = $(this);
 	const url='TextTypeServlet';
 	const id=$(this).prev().prev().val();
 	const num=$(this).val();

// 	const kind_num=$("input[name='kind_num']").val();
 	//const kind_num=$('#kind_num').val();
//	const like=$("input[name='like']").val();
//	const order=$("input[name='order']").val();
 	console.log(id+"id")
 	console.log(num)
    $.ajax({
        url: url,
        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
        data: {
        	id : id,
        	num : num,
        },
        dataType:"text"
        })
        .done(function(data) {
        	console.log(kind_num+"!!oo!!")
        	if(kind_num != 0) {
        		self.parents("tr").remove();
        	}else{
        		switc1(self,num);
        	}

        console.log(data)
        })
        .fail((data) => {
        console.log(data+"!!!!")
        })
});

$('#sbtn1').on('click', function(){
	 let word=$("#sbox1").val();
 	 console.log(word)
 	if(word==""){
	alert("検索ワードを入力してください")
 		return
 	}
 	//event.preventDefault();
 	word=word.toLowerCase();
 	$('#tbody>tr').each(function(e) {
 		const title=$(this).find("a").text().toLowerCase();
		const check=$(this).find(".option-input06");
 		 console.log( $(this).find(".option-input06").prop('checked'))
 		 console.log(title.indexOf(word))
 		 if(title.indexOf(word)<0){
		$(check).prop("checked", false);
		$(this).removeClass("d-flex");
		$(this).children().eq(0).removeClass("col-2");
		$(this).children().eq(1).removeClass("col-2");
		$(this).children().eq(2).removeClass("col-3");
		$(this).children().eq(3).removeClass("col-3");
		$(this).children().eq(4).removeClass("col-2");
		$(this).addClass("nohit");
 		}else{
 			$(this).removeClass("nohit");
 			$(this).addClass("d-flex");
 			$(this).children().eq(0).addClass("col-2");
 			$(this).children().eq(1).addClass("col-2");
 			$(this).children().eq(2).addClass("col-3");
 			$(this).children().eq(3).addClass("col-3");
 			$(this).children().eq(4).addClass("col-2");
 			//$(this).removeClass("nohit");
 		}
	})
	const checks=$('input:checkbox[name="myBook_id"]:checked')
	delfunc(checks)
});

$('#sbtn2').on('click', function(){
	$('#tbody tr').removeClass("nohit");
		$('#tbody tr').each(function() {


		$(this).addClass("d-flex");
		$(this).children('td').eq(0).addClass("col-2");
		$(this).children('td').eq(1).addClass("col-2");
		$(this).children('td').eq(2).addClass("col-3");
		$(this).children('td').eq(3).addClass("col-3");
		$(this).children('td').eq(4).addClass("col-2");
		})
});

$("#backbtn").on('click', function(){
	window.location.href = 'BookMainServlet';
})



})