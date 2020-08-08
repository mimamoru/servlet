$(function() {


$('.form-control').on('blur',function(e) {
	if($(this).val()==""){
		$(this).attr('placeholder','入力してください');
		}
});

$('#search-ok').on('click',function(e) {
	const url='BookSeachServlet';
	const name=$("input[name='name']").val();
	const pass= $("input[name='pass']").val();
	if (name== ''||pass == '') {
		alert('入力してください');
		return false;
		}
	$.ajax({
        url: url,
        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
        data: {
        name : name,
        pass :pass
        },
        dataType:"json"
        })
        .done(function(data) {

        const id =data.id;

        if(id>0&&confirm("テキストを表示します")){
//        	$.ajax({
//                url: 'TextOServlet',
//                type: "get", // HTTPメソッドを指定（デフォルトはGET）
//                data: {
//                id : id
//                }
//               // dataType:"json"
//                })
            window.location.href = 'TextOServlet?id='+id;
        }else{
        if (confirm('該当するブックがありません')) {
            window.location.href = 'BookMainServlet';
        }
        }
        })
        .fail((data) => {
        console.log(data+"!!!!")
        if (confirm('該当するブックがありません')) {
            window.location.href = 'BookMainServlet';
        }
        })
        });





        });