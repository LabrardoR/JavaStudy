import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("/show_request")
public class ShowRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        StringBuilder respBody = new StringBuilder();
        respBody.append(req.getProtocol());// 获取协议的名称和版本
        respBody.append("<br>");
        respBody.append(req.getMethod());// 返回请求的 HTTP 方法的名称
        respBody.append("<br>");
        respBody.append(req.getRequestURI());// 返回该请求的 URL 的一部分
        respBody.append("<br>");
        respBody.append(req.getContextPath());
        respBody.append("<br>");
        respBody.append(req.getQueryString());
        respBody.append("<br>");

        respBody.append("<h3>headers:</h3>");
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            respBody.append(headerName + " ");
            respBody.append(req.getHeader((headerName)));
            respBody.append("<br>");
        }

        resp.getWriter().write(respBody.toString());
    }
}
