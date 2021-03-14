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
          }
}
