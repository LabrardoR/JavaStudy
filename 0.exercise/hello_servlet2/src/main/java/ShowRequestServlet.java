import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/show")
public class ShowRequestServlet extends HelloServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用上述api，把得到的结果构成一个字符串，统一返回给客户端
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(req.getProtocol());
        stringBuilder.append("<br>");
        //在html中，\n不能执行换行操作
        stringBuilder.append(req.getMethod());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getRequestURI());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getContextPath());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getQueryString());
        stringBuilder.append("<br>");

        // 获取所有的header
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String val = req.getHeader(key);
            stringBuilder.append(key + ":" + val + "<br>");
        }
        resp.setContentType("text/html;charset=utf8");
        //把上述内容整体返回到客户端
        resp.getWriter().write(stringBuilder.toString());
    }
}
