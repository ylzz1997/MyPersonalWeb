// JavaScript Document
function Trbut(elem) {
var eachPush = {state : 1};

init();

function init() {
	elem.children(".containt").html(elem.attr("data_name"));
	setInterval(_trunT(elem,eachPush),5000);
	elem.click(function () {
        var name = $("body").attr("nowurl");
        if(name!="")
            location.href="/"+name+"/"+elem.attr("data_name");
        else
            location.href="/"+ elem.attr("data_name");
    });
}

}

function _trunT(elem,push) {
	return function () {
        trunT(elem,push);
    }
}

function trunT(elem,push){
    var containt = elem.children(".containt");
    switch(push.state){
        case 0:
            containt.fadeOut("slow",function(){
                containt.html(elem.attr("data_name"));
                containt.fadeIn("slow");
            });
            push.state = 1;
            break;
        case 1:
            containt.fadeOut("slow",function(){
                containt.html("<img src='"+elem.attr("data_img")+"' />");
                containt.fadeIn("slow");
            });
            push.state = 0;
            break;
    }
}



