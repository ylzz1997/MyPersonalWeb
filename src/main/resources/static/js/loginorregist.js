// JavaScript Document
var modle = "login";

$(function(){
    var reg_name=/^[\w]{3,10}$/;
    var reg_email=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9])+/;

    $("#sub").click(function(){
        $("#username").removeClass("has-error");
        $("#password").removeClass("has-error");
        $("#repass").removeClass("has-error");
        $("#email").removeClass("has-error");
        if($("input[name='username']").val()==""){
            $("#imformation").text("用户名不能为空!");
            $("#username").addClass("has-error");
            return;
        }else {
            if(!reg_name.test($("input[name='username']").val())){
                $("#imformation").text("账号不能含有特殊字符,只能含有数字字母下划线，长度为0-10字符!");
                $("#username").addClass("has-error");
                return;
            }
        }

        if($("input[name='password']").val()==""){
            $("#imformation").text("密码不能为空!");
            $("#password").addClass("has-error");
            return;
        }

        if(modle=="regist"){
            if($("input[name='password']").val()!=$("input[name='repass']").val()){
                $("#imformation").text("确认密码与密码不一致!");
                $("#repass").addClass("has-error");
                return;
            }
            if($("input[name='email']").val()==null){
                $("#imformation").text("电子邮件不能为空!");
                $("#email").addClass("has-error");
                return;
            }else {
                if(!reg_email.test($("input[name='email']").val())){
                    $("#imformation").text("电子邮件不符合格式!");
                    $("#email").addClass("has-error");
                    return;
                }
            }
        }

        $("form").submit();
    });


    $("input[name='username']").blur(function(){
        $.get("/checknamerepeat",{username:$("input[name='username']").val()},function(result){
            if(result.check==1){
                loginModle();
            }else{
                registModle();
            }
        });
    });

});

function loginModle() {
    modle = "login";
    $(".model").text("登录");
    $("#repass").css("display","none");
    $("#email").css("display","none");
    $("form").attr("action","/userlogin");
    $("#sub").text("登录");
    $("#imformation").text("已转换为登录模式");
}

function registModle() {
    modle = "regist";
    $(".model").text("注册");
    $("#repass").css("display","block");
    $("#email").css("display","block");
    $("form").attr("action","/userregist");
    $("#sub").text("注册");
    $("#imformation").text("已转换为注册模式");
}