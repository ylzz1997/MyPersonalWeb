// JavaScript Document
$(function(){
    $("input[name='password']").focus(function(){
        $("#password_gai").css("display","block");
    });

    $("input[name='password']").blur(function(){
        if($(this).val()==""){
            $("#password_gai").css("display","none");
        }
    });

});