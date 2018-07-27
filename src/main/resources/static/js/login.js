
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch([
                    "/static/img/backgrounds/2.jpg"
	              // , "/static/img/backgrounds/3.jpg"
	              // , "/static/img/backgrounds/1.jpg"
	             ], {duration: 3000, fade: 750});
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"]').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    /*$('.login-form').on('submit', function(data) {
    	$(this).find('input[type="text"], input[type="password"]').each(function(){
    		if( $(this).val() === "" ) {
    			data.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    });*/
	$('#loginBtn').on('click',function () {
		var validate = true;
        $('.login-form').find('input[type="text"], input[type="password"]').each(function(){
            if( $(this).val() === "" ) {
                validate = false;
                $(this).addClass('input-error');
            }
            else {
                $(this).removeClass('input-error');
            }
        });
        if(!validate){
            bootbox.alert({
                message: '用户名或密码不能为空！',
                size:'small'
            });
        	return;
		}
        $.ajax({
            type: 'POST',
            url: '/user/submitLogin',
            data: $('.login-form').serialize(),
            dataType: 'json',
            success: function(data){
                if (data.status == 200){
                    window.location.href='/homepage/init';
                }else {
                    bootbox.alert({
                        message: data.msg,
                        size:'small'
                    })
                }
            },
            error:function (data) {
                console.error(data);
                bootbox.alert({
                    message: '登录出错啦！',
                    size:'small'
                });
            }

        });
    });
    
});
