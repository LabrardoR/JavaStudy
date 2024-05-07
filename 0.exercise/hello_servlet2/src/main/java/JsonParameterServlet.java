import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class Request{
    public String username;
    public String password;
}
class Response{
    public boolean ok;
}

@WebServlet("/Json")
public class JsonParameterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 此处约定请求格式如下
        // POST /json
        // Content-Type: application/json
        //
        // {
        // username:"zhangsan"
        // password:"1234"
        //}
        // 此处也约定响应的格式(也按照 json 来组织)
        // {
        //   ok:true
        // }

        // 把请求的 body 按照 json 格式解析成 java 对象
        ObjectMapper objectMapper = new ObjectMapper();
        //该方法的工作是把 json 字符串（getInputStream）映射成 java 对象（class Request）
        //此处把这个流对象直接传给 readValue ，readValue 内部就会读取InputStream中所有数据（http请求中的body=》json的字符串
        //按照 json 的格式进行解析=》把 json 字符串解析成 Map =》把 Map 转换成 java 对象
        //在方法的第二个参数，传入类对象=》告诉readValue方法内部要把当前Map转化成什么样的Java对象
        Request request = objectMapper.readValue(req.getInputStream(),Request.class);
        System.out.println("username=" + request.username);
        System.out.println("password=" + request.password);
        Response response = new Response();
        response.ok = true;
        //把响应转成 json 字符串
        String respJson= objectMapper.writeValueAsString(response);
        resp.getWriter().write(respJson);
    }
}
