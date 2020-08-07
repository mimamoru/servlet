$(function() {

$('#login-modal0').fadeIn('slow');
const clear =function() {
$("input").val("");
}

$(document).on('click',function(e) {
if($(e.target).is('#start-btn')) {
$('#login-modal0').hide();
$('#login-modal1').fadeIn();
}else if($(e.target).is('#login-btn')) {
$('#login-modal2').show();
}else if($(e.target).is('#account-btn')) {
$('#login-modal3').show();
}else if($(e.target).closest('.modal').length===0) {
$("input[name='name']").attr('placeholder','ユーザー名');
$("input[name='pass']").attr('placeholder','パスワード');
clear();
$('#login-modal2').hide();
$('#login-modal3').hide();
}
});

$('.form-control').on('blur',function(){
if($(this).val()==""){
$(this).attr('placeholder','入力してください');
// $(this).after('<p>※必須</p>');
// $(this).next('p').css('color','red');
}
});

$(".submit-btn").on('click', function(){
const url=$(this).parent("form").attr('action');
const name=$("input[name='name']").val();
const pass= $("input[name='pass']").val();
const btn_id=$(this).attr('id');

if ($("input[name='name']").val() == ''||$("input[name='pass']").val() == '') {
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
	if(btn_id=="login"){
        console.log(data.id)
        const id=data.id
        if(id>0&&confirm(`ようこそ${data.name}さん`)){
            window.location.href = 'admin/BookMainServlet';
        }else{
        if (confirm('ログインに失敗しました')) {
            window.location.href = '/TextRegister';
        }
        }
    }else{
        if(confirm(data.msg)){
            window.location.href = '/TextRegister';
        }

    }


        })
        .fail((data) => {
        console.log(data)
        })
        });


        });