function redirect(url){
	window.location.href=url;
}
/**
 * 处理ajax请求标准方法
 * @param data
 * @param success
 * @param failure
 * @returns
 */
function ajaxHandle(data, success, failure){
	if(!data){
		console.log("返回数据格式错误")
	}else{
		if(data.success){
			success(data);
		}else{
			failure(data);
		}
	}
}
/**
 * 重新加载验证码
 * @returns
 */
function reloadCaptcha(base){
	$(".captcha").attr('src',base+'/captcha.jpg?id=' + Math.random());
}

function showText(dom, text, style){
	var $dom = $(dom);
	if(!!css){
		$dom.css(style);
	}
	$dom.html(text).show();
}
function hideText(dom){
	var $dom = $(dom);
	$dom.hide();
}