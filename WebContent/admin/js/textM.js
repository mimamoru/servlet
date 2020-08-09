$(function() {
//$(".pulldown").val("0")
$('.favorite-btn').each(function() {
	 if($(this).attr("value")=="true"){
		 $(this).toggleClass('active');
     }
	//	 else {
//    	 $(this).toggleClass('inactive');
//     }

})

$('.type-drop').each(function() {
	 let element =$(this).parent().prev().val();
	 $(this).parent().val(element);
})


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
	        type: "GET", // HTTPメソッドを指定（デフォルトはGET）
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

$('#delete-button').on('click',function() {
	const url='TextDeleteServlet';
	const kind_num=$("input[name='kind_num']").val();
	const like=$("input[name='like']").val();
	const order=$("input[name='order']").val();
	$.when(
		$('input:checkbox[name="myBook_id"]:checked').each(function() {

			const myBook_id=$(this).val();
			const book_id =$(this).next().val();
			console.log(book_id+"!!!!")
			console.log(myBook_id+"!!!!")
			$.ajax({
		        url: url,
		        type: "GET", // HTTPメソッドを指定（デフォルトはGET）
		        data: {
		        	book_id : book_id,
		        	myBook_id : myBook_id
		        },
		        dataType:"text"
		        }) .done(function(data) {

			        console.log(data)


			        })
			        .fail((data) => {
			        console.log(data+"!!!!")

			        })
		})
		).done(
				function() {

		 if (confirm("削除しました")) {
			 $.ajax({
			        url: "TextMServlet",
			        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
			        data: {
			        	kind_num : kind_num,
			        	like : like,
			        	order : order
			        },
			       // dataType:"text"
			        })
	        }
				})
        });

$("select[name='order']").on('change', function() {
    const selectedOrder = $(this).val()
    const bookTable = $("#bookList")
    const bookList = bookTable.find("tr")

const sorted =
bookList.sort((prev, next) => {

	switch(Number(selectedOrder)) {
		case 0:
			break;
		case 1:
			// タイトル順
			return $(prev).find("a").text() > $(next).find("a").text() ? 1 : -1
		case 2:
			break;
	}
})

// テーブル再描写
bookTable.children().remove()
sorted.map((index, elm) => {
	bookTable.append(elm)
	console.log($(elm).find("a").text())
 })


})

$('.s1').on('change', function(event){
	const self = $(this);
 	const url='TextTypeServlet';
 	const id=$(this).prev().prev().val();
 	const num=$(this).val();

 	const kind_num=$("input[name='kind_num']").val();
	const like=$("input[name='like']").val();
	const order=$("input[name='order']").val();
 	console.log(id)
 	console.log(num)
    $.ajax({
        url: url,
        type: "GET", // HTTPメソッドを指定（デフォルトはGET）
        data: {
        	id : id,
        	num : num,
        },
        dataType:"text"
        })
        .done(function(data) {
//        	 $.ajax({
//			        url: "TextMServlet",
//			        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
//			        data: {
//			        	kind_num : kind_num,
//			        	like : like,
//			        	order : order
//			        },
//			       // dataType:"text"
//			        })

        	if(kind_num != 0) {
        		self.parents("tr").remove();
        	}

        console.log(data)
        })
        .fail((data) => {
        console.log(data+"!!!!")
        })


});



})