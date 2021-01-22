package bo.digital.serv.studentclass;

import bo.digital.colege.dao.ClassDAO;
import bo.digital.colege.entities.ClassStudentSearch;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hered
 */
@WebServlet("/studentclass")
public class EstudentClassSer extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @EJB
    ClassDAO clas;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside Servlet");
        String type = request.getParameter("type");
        if (type == null) {
            //EmployeeDetails empDetails = new EmployeeDetails(0, 0, type, type);
            //empDetails.getEmployeeDetails();
            //request.setAttribute("EmpList", empDetails.getEmployeeDetails());
            String code = request.getParameter("code");
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String studentid = request.getParameter("id");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");

            List<ClassStudentSearch> loadSearch = clas.loadSearch(code, title, description, studentid, firstname, lastname);
            request.setAttribute("busqueda", loadSearch);
            
            request.getRequestDispatcher("page/estudianteclase.jsp").forward(request, response);
        }
    }
}
