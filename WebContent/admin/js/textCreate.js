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
	switc1($('.s1'),"0")
	 $('.s1').on('change', function(event){
		 const num=$(this).val();
		 switc1($('.s1'),num)
	 });
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
		 	const title=$("#text-form").val();
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

	 $('#back-btn').on('click',function() {

			 if (!confirm('下書きが保存されません。よろしいですか。')) {
			        return
			 }


			 window.location.href = 'BookMainServlet';

	});
})