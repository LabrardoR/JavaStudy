package com.library.librarymanagementsystem.interceptor;

import com.library.librarymanagementsystem.constant.Constants;
import com.library.librarymanagementsystem.model.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("登录拦截器校验...");
        // 返回true表示放行,返回false表示拦截
        // 校验用户是否登录
//      HttpSession session = request.getSession(false);// true表示没有session就创建,false表示没有的话直接返回
//        if (session != null && session.getAttribute(Constants.SESSION_USER_KEY)!=null){
//            UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
//            if(userInfo != null && userInfo.getId() >= 0){
//                return true;
//            }
//        }

        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
        if(userInfo != null && userInfo.getId() >= 0){
            return true;
        }
        response.setStatus(401); // 401表示未认证登录
        return false; // true:放行, false:拦截
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("目标方法执行后");
    }
}
