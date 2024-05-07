package servlet;

import model.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 读取参数中的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 验证参数是否合法
        if (username == null || username.isEmpty() || password == null || password.isEmpty()){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码为空!");
            return;
        }
        // 2. 查询数据库
        UserDao userDao = new UserDao();
        User user = userDao.GetUserByName(username);
        if (user == null){
            //  用户名不存在!
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码错误!");
        }
        if(!password.equals(user.getPassWord())){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或密码错误!");
            return;
        }
        // 3. 创建会话
        HttpSession session = req.getSession(true);
        session.setAttribute("user",user);
        // 4. 跳转到主页
        resp.sendRedirect("blog_list.html");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过这个方法来反馈当前用户的登录状态->查看会话是否存在
        // 不仅要求会话存在,还要求会话中能保存 user 对象
        HttpSession session = req.getSession(false);
        if (session == null){
            // 未登录
            resp.setStatus(403);
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null){
            // user 对象也不存在,属于未登录
            resp.setStatus(403);
            return;
        }
        // 登录
        resp.setStatus(200);


    }
}
