const switc1=function(select,element){
switch(element){
case "1": return select.css("background-color","red")
case "2": return select.css("background-color","yellow")
case "3": return select.css("background-color","green")
case "4": return select.css("background-color","#3fb2bf")
case "5": return select.css("background-color","blue")
default:  return select.css("background-color","gray")
}}

$(function() {
	const kind_num=$("input[name='kind_num']").val();

	 if($('.favorite-btn').attr("value")=="true"){
		 $('.favorite-btn').toggleClass('active');
     }
	 $('#contents').summernote('disable');
 $('.s1').val($('.my').val());

 $('#contents').summernote({
	 height: 580,
	 fontNames: ["YuGothic","Yu Gothic","Hiragino Kaku Gothic Pro","Meiryo","sans-serif", "Arial","Arial Black","Comic Sans MS","Courier New","Helvetica Neue","Helvetica","Impact","Lucida Grande","Tahoma","Times New Roman","Verdana"],
	 lang: "ja-JP",
	 toolbar: [
	 	['style', ['bold', 'italic', 'underline', 'clear']],
	 	['font', ['strikethrough']],
	 	['fontsize', ['fontsize']],
	 	['color', ['color']],
	 	['table', ['table']],
	 	['insert', ['link', 'picture']],
	 	['view', ['fullscreen']],
	 	['para', ['ul', 'ol', 'paragraph']],
	 ]
	 });


 $('.favorite-btn').on('click', function(event){
	 	const url='TextFavoriteServlet';
	 	let favorite;
	 	const id=$(".mbid").val();
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


		const select=$(".s1")
		const option=$('.type-drop').attr("value")
		 let element=select.prev().val();
		 select.val(element);
		 switc1(select,element);


 $('.s1').on('change', function(event){
		const url='TextTypeServlet';
		const id=$(".mbid").val();
	 	const num=$(this).val();

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
	        switc1(select,num);
	        console.log(data)
	        })
	        .fail((data) => {
	        console.log(data+"!!!!")
	        })
	});

 $('#edit-btn').on('click',function() {
	 if (!$("#text-form").hasClass('edit-second')) {
		 const url='TextEditServlet';
		 const book_id=$(".delete-btn").val();
		 const id=$(".mbid").val();
		 const title = $("#text-form").val();
		 const text = $("#contents").summernote('code');
		 if (title== '') {
				alert('タイトルを入力してください');
				return false;
				}
			$.ajax({
	        url: url,
	        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
	        data: {
	        	book_id:book_id,
	        	id : id,
	        	title : title,
	        	text : text
	        },
	        dataType:"text"
	        }) .done(function(data) {

		        console.log(data)
		       alert('更新しました')
		       window.location.href = 'TextMServlet?kind_num='+kind_num;

		        })
		        .fail((data) => {
		        console.log(data+"!!!!")

		        })
     }else{
    	 $("#text-form").removeClass('edit-second');
    	 $("#tgl-btn").text('Finish');
    	 const ht=$("#finish-btn").html();
    	 $("#edit-btn").html(ht);
    	 $('#contents').summernote('enable');
    	 $('#text-form').attr('readonly',false);
     }

	        });

 $('.delete-btn').on('click',function() {
	 if (!confirm('本当に削除しますか')) {
        return
     }
		const url='TextDeleteServlet';
		const book_ids=[]
		const myBook_ids=[]
		myBook_ids.push($(".mbid").val()),
		book_ids.push($(this).val())

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
				        alert('削除しました')
				        window.location.href = 'TextMServlet?kind_num='+kind_num;



				        })
				        .fail((data) => {
				        console.log(data+"!!!!")

				        })
	        });





 $('#back-btn').on('click',function() {
	 if(!$('#text-form').hasClass('edit-second')){
		 if (!confirm('変更が保存されません。よろしいですか。')) {
		        return
		 }
//		 $('#edit-btn').removeClass('edit-second');
//		 $('#text-form').attr('readonly',true);
//		 $('#contents').summernote('disable');

	 }

		 window.location.href = 'TextMServlet?kind_num='+kind_num;

});


});