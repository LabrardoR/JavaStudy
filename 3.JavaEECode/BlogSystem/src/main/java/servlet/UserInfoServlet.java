package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("未登录!");
            return;
        }
        User user = (User)session.getAttribute("user");
        if (user == null){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("未登录!");
            return;
        }
        // 将 user 转化成 json 返回给浏览器
        resp.setContentType("text/html; charset=utf8");
        // user 中还有 password 的属性->直接返回不安全
        user.setPassWord("");
        String respJson = objectMapper.writeValueAsString(user);
        resp.getWriter().write(respJson);
    }
}
