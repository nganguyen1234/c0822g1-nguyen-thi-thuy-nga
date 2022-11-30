import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("Nga", "12/12/1212", "HT", "https://sachhaynendoc.net/wp-content/uploads/2019/09/Harry-Potter-%C3%BD-ngh%C4%A9a-t%C3%AAn.jpg"));
        customerList.add(new Customer("Nương", "12/12/1212", "QN", "https://i.pinimg.com/originals/1f/38/70/1f3870c297c63ac33ac19c36e381e6b3.jpg"));
        customerList.add(new Customer("Linh", "12/12/1212", "ĐN","https://cuongphim.com/wp-content/uploads/2018/01/dien-vien-harry-potter-1-1-720x1024.jpg"));
        customerList.add(new Customer("Như", "12/12/1212", "ĐN","https://cdn.voh.com.vn/voh/Image/2022/06/26/hp10-1.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
