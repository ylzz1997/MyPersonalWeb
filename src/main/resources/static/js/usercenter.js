// JavaScript Document
$(function(){
    var reg_email=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9])+/;
    var reg_name=/^[\w\u4e00-\u9fa5_]{3,10}$/;

    $("input[name='password']").focus(function(){
        $("#password_gai").css("display","block");
    });

    $("input[name='password']").blur(function(){
        if($(this).val()==""){
            $("#password_gai").css("display","none");
        }
    });

    $("#btn_password").click(function(){
        if($("input[name='password']").val()==""){
            alert("密码不能为空!");
            return;
        }
        if($("input[name='password']").val()!=$("input[name='repass']").val()){
            alert("确认密码与密码不一致!");
            return;
        }
        $.post("/UcenterUpdate/password",{password:$("input[name='password']").val()},function(result){
            if(result.result==1){
                alert("修改成功!");
            }else{
                alert("修改失败!");
            }
        });
    });

    $("#btn_email").click(function(){
        $("#email_gai").css("display","block");
        $(this).css("display","none");
    });

    $("#btn_email_close").click(function(){
        $("#email_gai").css("display","none");
        $("#btn_email").css("display","inline-block");
    });

    $("#btn_email_submit").click(function(){
        if($("input[name='email']").val()==null){
            alert("电子邮件不能为空!");
            return;
        }else {
            if(!reg_email.test($("input[name='email']").val())){
                alert("电子邮件不符合格式!");
                return;
            }
        }
    });

    $("#btn_indexname").click(function(){
        $("#indexname_gai").css("display","block");
        $(this).css("display","none");
    });

    $("#btn_indexname_close").click(function(){
        $("#indexname_gai").css("display","none");
        $("#btn_indexname").css("display","inline-block");
    });

    $("#btn_index_submit").click(function(){
        if($("input[name='indexname']").val()==""){
            alert("昵称不能为空!");
            return;
        }else {
            if(!reg_name.test($("input[name='indexname']").val())){
                alert("昵称不能含有特殊字符,只能含有数字字母汉字和下划线，长度为3-10字符!");
                return;
            }
        }
    });
});