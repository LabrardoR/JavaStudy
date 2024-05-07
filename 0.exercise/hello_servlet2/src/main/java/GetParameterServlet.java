import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //此处约定，请求中给定的query string是形如 username=zhangsan&password=1223
        //上述query string，就会被 tomcat自动解析成一个map这样的结构
        //getParameter就是在查询Map<String,String>内的内存
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        resp.getWriter().write("ok");
    }
}
