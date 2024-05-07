package login;

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
        // 1.读取请求传来的参数(用户名和密码)
        // 先设置字符集,防止中文乱码
        req.setCharacterEncoding("utf8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2.验证用户名密码是否正确->通过数据库验证->此处为了简单先写死
        // getParameter可能会拿到null,equals能对null进行较好的处理
        if(!username.equals("zhangsan")||!password.equals("123")){
            // 登陆失败
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前用户名或密码错误!");
            return;
        }
        // 3. 登陆成功,给该用户创建会话
        // 可以给会话中保存一些自定义的数据,通过 Attribute 的方式来保存
        HttpSession session = req.getSession(true);
        // 会创建出一个 sessionId 和 一个 session 对象,把这个键值对保存到 hash表里.并且会把 sessionId 设置到响应中,让浏览器使用 Cookie 保存

        // 此处的 Attribute 也是键值对,这里的内容存储什么都可以->自定义
        // 这样的数据存储好了之后,后续跳转到其他页面,也可以随时吧这个数据从会话中取出来->让一个数据在多个 Servlet 之间共享->Attribute是会话级别的->每个用户/客户端都会有自己的数据,互相之间不会干扰
        session.setAttribute("username",username);
        session.setAttribute("loginTime",System.currentTimeMillis());
        // 登陆成功,跳转到网站首页
        resp.sendRedirect("index");



    }
}
