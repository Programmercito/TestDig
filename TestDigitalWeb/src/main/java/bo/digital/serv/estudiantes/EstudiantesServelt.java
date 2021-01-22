package bo.digital.serv.estudiantes;

import bo.digital.colege.entities.Estudent;
import bo.digital.colege.dao.StudentsDAO;
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
    StudentsDAO bean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside Servlet");
        String type = request.getParameter("accion");
        if (type == null) {
            List<Estudent> resultado = bean.LoadAll();
            request.setAttribute("estudiantes", resultado);
            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);
        } else if ("nuevo".equals(type)) {
            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);
        } else if ("modificar".equals(type)) {
            Estudent estudito = bean.find(Long.parseLong(request.getParameter("id")));
            request.setAttribute("modificame", estudito);
            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);
        } else if ("eliminar".equals(type)) {
            Estudent estudito = bean.find(Long.parseLong(request.getParameter("id")));
            bean.remove(estudito);
            List<Estudent> resultado = bean.LoadAll();
            request.setAttribute("estudiantes", resultado);
            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("accion");
        if ("grabarnuevo".equals(type)) {
            Estudent resultado = new Estudent();
            resultado.setStudentid(Long.parseLong(request.getParameter("id")));
            resultado.setLastname(request.getParameter("lastname"));
            resultado.setFirstname(request.getParameter("firstname"));
            bean.persist(resultado);

            List<Estudent> lista = bean.LoadAll();
            request.setAttribute("estudiantes", lista);

            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);
        } else if ("grabarmod".equals(type)) {
            Estudent estudito = bean.find(Long.parseLong(request.getParameter("id")));
            estudito.setLastname(request.getParameter("lastname"));
            estudito.setFirstname(request.getParameter("firstname"));
            bean.update(estudito);

            List<Estudent> lista = bean.LoadAll();
            request.setAttribute("estudiantes", lista);

            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);
        }

    }
}
