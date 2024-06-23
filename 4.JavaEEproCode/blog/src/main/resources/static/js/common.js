$(document).ajaxSend(function(e, xqr, op){
    var token = localStorage.getItem("user_token");
    xqr.setRequestHeader("user_token", token);
});


function getUserInfo(url){
    console.log(url),
    $.ajax({
        type:"get",
        url: url,
        success:function(result){
            if(result.code==200 && result.data!=null){
                //页面填充
                var user = result.data;
                $(".left .card h3").text(user.userName);
                $(".left .card a").attr("href", user.githubUrl);
            }else{
                location.herf = "blog_login.html"
            }
        }
    });
}