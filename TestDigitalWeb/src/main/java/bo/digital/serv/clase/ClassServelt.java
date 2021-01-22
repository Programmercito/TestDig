package bo.digital.serv.clase;

import bo.digital.colege.dao.ClassDAO;
import bo.digital.colege.entities.Class;
import bo.digital.colege.entities.Estudent;
import bo.digital.common.error.ProcessError;
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
@WebServlet("/class")
public class ClassServelt extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @EJB
    ClassDAO bean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("accion");
        if (type == null) {
            List<Class> resultado = bean.loadAll();
            request.setAttribute("estudiantes", resultado);
            request.getRequestDispatcher("page/clases.jsp").forward(request, response);
        } else if ("nuevo".equals(type)) {
            request.getRequestDispatcher("page/clases.jsp").forward(request, response);
        } else if ("modificar".equals(type)) {
            Class estudito = bean.find(Long.parseLong(request.getParameter("id")));
            request.setAttribute("modificame", estudito);
            request.getRequestDispatcher("page/clases.jsp").forward(request, response);
        } else if ("eliminar".equals(type)) {
            Class estudito = bean.find(Long.parseLong(request.getParameter("id")));
            try {
                bean.remove(estudito);
            } catch (Exception ex) {
                ProcessError.process(ex, request);
            }
            List<Class> resultado = bean.loadAll();
            request.setAttribute("estudiantes", resultado);
            request.getRequestDispatcher("page/clases.jsp").forward(request, response);
        } else if ("viewstudent".equals(type)) {
            Class estudito = bean.find(Long.parseLong(request.getParameter("id")));
            request.setAttribute("clase", estudito);
            List<Estudent> resultado = bean.loadStudents(estudito.getCode());
            request.setAttribute("estudiantes", resultado);
            request.getRequestDispatcher("page/clases.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("accion");
        if ("grabarnuevo".equals(type)) {
            Class resultado = new Class();
            resultado.setCode(Long.parseLong(request.getParameter("code")));
            resultado.setTitle(request.getParameter("title"));
            resultado.setDescription(request.getParameter("description"));
            try {
                bean.persist(resultado);
            } catch (Exception ex) {
                ProcessError.process(ex, request);
            }

            List<Class> lista = bean.loadAll();
            request.setAttribute("estudiantes", lista);

            request.getRequestDispatcher("page/clases.jsp").forward(request, response);
        } else if ("grabarmod".equals(type)) {
            Class estudito = bean.find(Long.parseLong(request.getParameter("code")));
            estudito.setTitle(request.getParameter("title"));
            estudito.setDescription(request.getParameter("description"));
            try {
                bean.update(estudito);
            } catch (Exception ex) {
                ProcessError.process(ex, request);
            }

            List<Class> lista = bean.loadAll();
            request.setAttribute("estudiantes", lista);

            request.getRequestDispatcher("page/clases.jsp").forward(request, response);
        }

    }
}
