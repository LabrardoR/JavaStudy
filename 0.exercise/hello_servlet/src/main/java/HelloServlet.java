import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//来自于servlet的jar包

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    //doGet的意思是处理 HTTP GET 请求，当tomcat收到一个GET请求的时候，就有可能执行到这个子类的方法中
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这个打印是显示在tomcat的控制台上（服务器端）
        System.out.println("hello world");
        // 把内容显示到页面上=》把“hello world”字符串作为http响应的body部分
        // 这个部分就会被浏览器显示到页面上
        resp.getWriter().write("hello world");
    }

}
