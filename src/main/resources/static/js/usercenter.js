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

    $("#btn_email").click(function(){
        $("#email_gai").css("display","block");
        $(this).css("display","none");
    });

    $("#btn_email_close").click(function(){
        $("#email_gai").css("display","none");
        $("#btn_email").css("display","inline-block");
    });

    $("#btn_indexname").click(function(){
        $("#indexname_gai").css("display","block");
        $(this).css("display","none");
    });

    $("#btn_indexname_close").click(function(){
        $("#indexname_gai").css("display","none");
        $("#btn_indexname").css("display","inline-block");
    });

});