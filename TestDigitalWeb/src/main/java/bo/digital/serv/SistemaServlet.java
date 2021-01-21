package bo.digital.serv;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hered
 */
@WebServlet("/")
public class SistemaServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside Servlet");
        String type = request.getParameter("type");
        if (type.equals("getDetails")) {
            //EmployeeDetails empDetails = new EmployeeDetails(0, 0, type, type);
            //empDetails.getEmployeeDetails();
            //request.setAttribute("EmpList", empDetails.getEmployeeDetails());
            request.getRequestDispatcher("page/index.jsp").forward(request, response);
        }
    }
}