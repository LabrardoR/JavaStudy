package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 通过这个servlet生成一个主页
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 先获取到当前用户对应的会话对象,生成的页面要根据当前用户信息来构造
        HttpSession session = req.getSession(false);
        if (session == null){
            // sessionId 不存在，或者 sessionId 在 hash 表中未查到
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("您当前尚未登陆！");
            return;
        }
        // 2. 从会话中拿到之前 session 存储的用户信息
        // 此处的墙砖，需要自行保证类型是正确的
        String username = (String) session.getAttribute("username");
        Long loginTime = (Long) session.getAttribute("loginTime");

        // 3. 生成一个页面，把上述数据显示到页面上
        resp.setContentType("text/html;charset=utf8");
        String respBody = "欢迎你 "+ username + "! 上次登陆时间为："+ loginTime;
        resp.getWriter().write(respBody);

    }
}
