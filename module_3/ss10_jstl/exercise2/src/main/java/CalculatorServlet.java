import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double num1 = Double.parseDouble(request.getParameter("f-operand"));
        double num2 = Double.parseDouble(request.getParameter("s-operand"));
        String operator = request.getParameter("operator");
        double result = 0;
        String finalResult;
        switch (operator) {
            case "+":
                result = num1 + num2;
                finalResult = num1 + "" + operator + num2 + "=" + result;
                break;
            case "-":
                result = num1 - num2;
                finalResult = num1 + "" + operator + num2 + "=" + result;
                break;
            case "*":
                result = num1 * num2;
                finalResult = num1 + "" + operator + num2 + "=" + result;
                break;
            case "/":
                try {
                    if (num2 == 0) {
                        throw new ArithmeticException("Lỗi chia cho 0");
                    }
                    result = num1 / num2;
                    finalResult = num1 + "" + operator + num2 + "=" + result;
                } catch (ArithmeticException e) {
                    request.setAttribute("result", e.getMessage());
                    request.getRequestDispatcher("result.jsp").forward(request, response);
                }
                break;
        }
        finalResult = num1 + "" + operator + num2 + "=" + result;
        request.setAttribute("result", finalResult);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
