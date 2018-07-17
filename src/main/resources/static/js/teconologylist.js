// JavaScript Document

$(function(){
	var p=0,t=0;
	
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