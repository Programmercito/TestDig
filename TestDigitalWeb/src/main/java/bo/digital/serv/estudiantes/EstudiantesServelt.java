package bo.digital.serv.estudiantes;

import bo.digital.colege.entities.Estudent;
import com.mycompany.testdigitalejb.NewSessionBean;
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
@WebServlet("/student")
public class EstudiantesServelt extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @EJB
    NewSessionBean bean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside Servlet");
        String type = request.getParameter("type");
        if (type == null) {
            //EmployeeDetails empDetails = new EmployeeDetails(0, 0, type, type);
            //empDetails.getEmployeeDetails();
            //request.setAttribute("EmpList", empDetails.getEmployeeDetails());
            List<Estudent> resultado = bean.LoadAll();
            request.setAttribute("estudiantes", resultado);

            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);
        }
    }
}
