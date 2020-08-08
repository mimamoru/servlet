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




})