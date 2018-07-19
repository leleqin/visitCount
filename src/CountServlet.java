import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 统计访问量
 */
public class CountServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        /**
         * 1.获取ServletContext对象
         * 2.查看是否存在名为count的属性，如果存在，说明不是第一次访问；如果不存在，就说明是第一次访问。
         * 3.第一次访问：调用ServletContext的setAttribute()方法传递一个属性，名为count，值为1
         * 4.第2~n次访问：调用ServletContext的getAttribute()方法获取原来的访问量，给访问量+1，再调用ServletContext的setAttribute()方法存值。
         */

        ServletContext servletContext = this.getServletContext();
        Integer count = (Integer)servletContext.getAttribute("count");
        if (count == null){
            servletContext.setAttribute("count",1);
        }else {
            servletContext.setAttribute("count",count+1);
        }

        PrintWriter printWriter = response.getWriter();
        printWriter.print("<h1>" + count + "</h1>");
    }
}
