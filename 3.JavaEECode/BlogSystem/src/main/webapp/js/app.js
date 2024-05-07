 // 定义新的函数，获取登录状态

 function getLoginStatus(){
    $.ajax({
        type: 'get',
        url: 'login',
        success: function(body){
            // 已经登录
            console.log("已经登录了！")
        },
        error: function(){

            location.assign('login.html');
        }
    })



 }