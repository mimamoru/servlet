$(function() {
//$(".pulldown").val("0")
$('.favorite-btn').each(function() {
	 if($(this).attr("value")=="true"){
		 $(this).toggleClass('active');
     }

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

$('#delete-button').on('click',function() {
	const url='TextDeleteServlet';
//	const kind_num=$("input[name='kind_num']").val();
//	const like=$("input[name='like']").val();
//	const order=$("input[name='order']").val();
	const book_ids=[]
	const myBook_ids=[]
	const elm=[]
		$('input:checkbox[name="myBook_id"]:checked').each(function() {

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

$("select[name='order']").on('change', function() {
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
			//console.log(Date.parse($(prev).find(".modified").attr("value")))
			//console.log($(prev).find(".modified").attr("value")+" 00:00")
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
        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
        data: {
        	id : id,
        	num : num,
        },
        dataType:"text"
        })
        .done(function(data) {

        	if(kind_num != 0) {
        		self.parents("tr").remove();
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
 		return
 	}
 	//event.preventDefault();
 	word=word.toLowerCase();
 	$('#tbody>tr').each(function(e) {
 		const title=$(this).find("a").text().toLowerCase();
 		 console.log(title)
 		if(title.indexOf(word)<0){
 			$(this).addClass("nohit");
 		}else{
 			$(this).removeClass("nohit");
 		}
	})
});

$('#sbtn2').on('click', function(){

		$('#tbody>tr').removeClass("nohit");

});

})