$(function() {




$("select[name='order']").on('change', function() {
    const selectedOrder = $(this).val()
    if($(this).hasClass("select1")){
    	const table = $("#table1")
    }else{
    	const table = $("#table2")
        }
    const list = table.find("tr")

const sorted =
bookList.sort((prev, next) => {

	switch(Number(selectedOrder)) {
		case 0:
			return $(next).find(".form-check-input").attr("value") - $(prev).find(".form-check-input").attr("value")
		case 1:
			// タイトル順
			return $(prev).find(".form-check-label").text() > $(next).find(".form-check-label").text()?1:-1
		case 2:
			return Date.parse($(next).find(".form-modified").attr("value"))- Date.parse($(prev).find(".form-modified").attr("value"))
	}
})

// テーブル再描写
bookTable.children().remove()
sorted.map((index, elm) => {
	bookTable.append(elm)
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


$('#share').on('click',function() {

	const url='BookPushConfServlet';
	const name=$("#share-name").val()
	const pass=$("#share-pass").val()
	if(name==""||pass==""){
		return false
	}
	$.ajax({
        url: url,
        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
        data: {
        	name : name,
        	pass : pass
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
//	const url='BookPushServlet';
//const book_ids=[]
//	const ourBook_ids=[]

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

$('#cancel').on('click',function() {
	if (!confirm('本当に削除しますか')) {
        return
     }
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


})