import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postParameter")
public class PostParameterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 约定，前端构造一个这样的请求
        // POST /postParameter
        // Content-type: x-www-form-urlencoded
        //
        // username=zhangsan&password=123

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        resp.getWriter().write("ok");
    }

}
