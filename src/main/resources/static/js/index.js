// JavaScript Document

var login = ""


$(function(){
	$(".main .container").animate({
		top:'0px',
		opacity: 1
	},"slow");
	
	$("#Teconology").hover(function(){
		showIntroduce("此栏目主要内容为各种技术文章分享，内有程序编写，电子电路，硬件等内容.也会有各种HIFI设备，相机的各种使用评测。");
	},function(){
		showIntroduce("将鼠标移动到超链接上会提示该栏目的介绍");
	});
	
	$("#Art").hover(function(){
		showIntroduce("此栏目主要内容为电子艺术，包含音乐，电影，动画，游戏，摄影。也包括电影特效制作，3dmax,maya模型制作，声音处理，图像处理，游戏引擎(unity3d)等技术讨论。");
	},function(){
		showIntroduce("将鼠标移动到超链接上会提示该栏目的介绍");
	});
	
	$("#Creation").hover(function(){
		showIntroduce("此栏目主要内容为各种创造物，比如模型，雕刻，手工艺品，实用小发明等。也会发布站长自己做的东西。");
	},function(){
		showIntroduce("将鼠标移动到超链接上会提示该栏目的介绍");
	});
});


function showIntroduce(contain){
	$(".itemIntroduce span").fadeOut("fast",function(){
		$(this).text(contain);
		$(this).fadeIn("fast");
	});
}