package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BlogDao blogDao = new BlogDao();
        String respJson = "";
        String blogId = req.getParameter("blogId");
        if (blogId == null){
            // 请求中没有 query string，请求来自博客列表页
            // 查询数据库，得到博客列表
            List<Blog> blogs = blogDao.getBlogs();
            // 把博客列表数据按照 json 格式返回
            respJson = objectMapper.writeValueAsString(blogs);
        } else {
            // 请求中存在 query string 请求来自博客详情页
            Blog blog = blogDao.getBlog(Integer.parseInt(blogId));
            respJson = objectMapper.writeValueAsString(blog);
        }

        System.out.println("respJson: " + respJson);
        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(respJson);
    }
}
