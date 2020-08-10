$(function() {


$('.form-control').on('blur',function(e) {
	if($(this).val()==""){
		$(this).attr('placeholder','入力してください');
		}
});

$('.card-body').on('click',function(e) {
	const kind_num=$(this).children('input').val();
	 window.location.href = 'TextMServlet?kind_num='+kind_num;
});

$('.kind-edit ').on('click',function(e) {
	const url='BookKindServlet';
	const kind_num=$(this).parents('.input-group').find("input[name='kind_num']").val();
	const kind_name=$(this).parents('.input-group').find(".form-control").val();
	console.log(kind_num)
	console.log(kind_name)
	if(kind_name==""){
		return false;
	}
	$.ajax({
        url: url,
        type: "POST", // HTTPメソッドを指定（デフォルトはGET）
        data: {
        	kind_num : kind_num,
        	kind_name :kind_name
        },
        dataType:"json"
        })
        .done(function(data) {
        const num =data.kind_num;
        const name =data.kind_name;
        $("h4").eq(num).text(name);

        })
        .fail((data) => {
        console.log(data+"!!!!")
        alert("エラーが発生しました")
        })
	 window.location.href = 'BookMainServlet';
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
        if(id>0){
            window.location.href = 'TextOServlet?id='+id;
        }else{
        	 alert('該当するカードがありません')
             window.location.href = 'BookMainServlet';
        }
        })
        .fail((data) => {
        console.log(data+"!!!!")
        alert('該当するカードがありません')
            window.location.href = 'BookMainServlet';
        })
        });
 });