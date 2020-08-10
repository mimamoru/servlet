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
        dataType:"json"
        })
        .done(function(data) {
        	const id =data.id;
        if(id>0){
        const title =data.title;
        const text =data.text;
        $('#label1').text(title);
        $('#text').text(text);
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
	const titles = [];
	const texts = [];
	const dates = [];

	$('input:checkbox[name="book_ids"]:checked').each(function() {
		book_ids.push($(this).val());
		titles.push($(this).next().val());
		texts.push($(this).next().next().val());
		dates.push($(this).next().next().next().val());
		console.log(book_ids);
	})

			$.ajax({
	        url: url,
	        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
	        data: {
	        	book_ids : book_ids,
	        	titles : titles,
	        	texts : texts,
	        	dates : dates
	        },
	        dataType:"json"
	        })
	        .done(function(data) {
	        const id =data.id;
	        console.log(data.title)
	        console.log(id)

	        if(id>0){
	        	myBooks.push(data.title);
	        }
	        })
	        .fail((data) => {
	        console.log(data+"!!!!")

	        })
	        alert('保存しました')

	        //window.location.href = 'TextOServlet?id='+ourBook_id;

    });



});