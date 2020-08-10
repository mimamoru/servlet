$(function() {
	 $('.favorite-btn').on('click', function(event){

	        $(this).toggleClass('active');

	   });


	 // リッチテキストの設定
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

	 $('#create-btn').on('click', function(event){
		 	const url='TextCreateServlet';
		 	const title=$("#title").val();
		 	if(title==""){
		 		alert("タイトルを入力してください");
		 		return false;
		 	}
		 	const text=$("#contents").summernote('code');
		 	let favorite;
		 	 if($(".favorite-btn").hasClass('active')){
		        	favorite ="true";
		        } else {
		        	favorite = "false";
		        }
		 	const kind_num=$("#kind-select").val();


	        $.ajax({
		        url: url,
		        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
		        data: {
		        	title : title,
		        	text : text,
		        	favorite : favorite,
		        	kind_num : kind_num
		        },
		        dataType:"json"
		        })
		        .done(function(data) {
		        	console.log(data)
		        	 alert('テキストを作成しました')
		                 window.location.href = 'BookMainServlet';
		        })
		        .fail((data) => {
		       alert('エラーが発生しました')
		             window.location.href = 'BookMainServlet';

		        })
	   });
})