// JavaScript Document
var eachPush = 1;

$(function(){
	var p=0,t=0;
	
	$("trbut").each(function(){
		$(this).css("height",$(this).css("width"));
		new JumpObj(this,10);
		new Trbut($(this));
	});
	
	$(window).resize(function() {
		$("trbut").each(function(){
			$(this).css("height",$(this).css("width"));
		});
	});
	
	$(window).scroll(function(){  
            p = $(this).scrollTop();
            if(t<=p){
                $(".indexhead").slideUp(1100);
            }else {
            	if(p==0){
                    $(".indexhead").slideDown(1100);
				}
			}

        setTimeout(function(){t = p;},0);
    });
});