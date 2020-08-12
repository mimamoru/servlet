//textO.js
$(function() {


$('.open-btn').on('click',function(e) {
	const url='TextOLookServlet';
	const book_id=$(this).attr("name");
	const ourBook_id=$("input[name='ourBook_id']").val();
	$.ajax({
        url: url,

        type: "GET", // HTTPメソッドを指定（デフォルトはGET）
        data: {
        id : book_id
        },
        dataType:"json",


		})
        .done(function(data) {
	console.log(data.title+"!!p!")
	console.log(data.text+"!!!")
        	const id =data.id;
        if(id>0){
        const title =data.title;
        const text =data.text;
        $('#modallabel1').text(title);

      // $('#text').html("<div><textarea id=\"contents\" name=\"text\">"+text+"</textarea></div>");
 $('#text').html("<div>"+text+"</div>");
        }else{
        	alert('読み込みできませんでした')
                window.location.href = 'TextOServlet?id='+ourBook_id;

        }
        })
        .fail((data) => {
        console.log(data+"!!!!")
        alert('読み込みできませんでした')
        window.location.href = 'TextOServlet?id='+ourBook_id;
        })
        });
$('#keep-btn').on('click',function(e) {
	const url='TextKeepServlet';
	const ourBook_id=$("input[name='ourBook_id']").val();
	const myBooks = [];
	const book_ids = [];


	$('input:checkbox[name="book_ids"]:checked').each(function() {
		book_ids.push($(this).val());

	})

			$.ajax({
	        url: url,
	        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
	        data: {
	        	book_ids : book_ids
	        },
	        dataType:"json"
	        })
	        .done(function(data) {
	         alert('保存しました')
				return
	        })
	        .fail((data) => {
	        alert('保存に失敗しました。カードが削除されている可能性があります。')
				return

	        })
	       //alert('保存しました')

	        //window.location.href = 'TextOServlet?id='+ourBook_id;

    });



});