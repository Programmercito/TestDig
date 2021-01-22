package bo.digital.serv.estudiantes;

import bo.digital.colege.dao.ClassDAO;
import bo.digital.colege.dao.ClassStudentDAO;
import bo.digital.colege.entities.Estudent;
import bo.digital.colege.entities.Class;
import bo.digital.colege.dao.StudentsDAO;
import bo.digital.colege.entities.ClassEstudent;
import bo.digital.common.error.ProcessError;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
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
    @EJB
    ClassDAO ejbclass;
    @EJB
    ClassStudentDAO stuclass;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside Servlet");
        String type = request.getParameter("accion");
        if (type == null) {
            List<Estudent> resultado = bean.loadAll();
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

            try {
                bean.remove(estudito);
            } catch (Exception ex) {
                ProcessError.process(ex, request);
            }

            List<Estudent> resultado = bean.loadAll();
            request.setAttribute("estudiantes", resultado);
            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);

        } else if ("viewclass".equals(type)) {
            Estudent estudito = bean.find(Long.parseLong(request.getParameter("id")));
            request.setAttribute("student", estudito);
            List<Class> resultado = bean.loadClass(estudito.getStudentid());
            request.setAttribute("clases", resultado);
            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);
        } else if ("nuevoclass".equals(type)) {
            Estudent estudito = bean.find(Long.parseLong(request.getParameter("id")));
            request.setAttribute("student", estudito);
            List<Class> resultado = ejbclass.loadAll();
            request.setAttribute("clases", resultado);
            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);
        } else if ("deleterel".equals(type)) {
            ClassEstudent relacion = new ClassEstudent();
            relacion.setCodeclass(Long.parseLong(request.getParameter("class")));
            relacion.setStudentid(Long.parseLong(request.getParameter("student")));
            try {
                stuclass.remove(relacion);
            } catch (Exception ex) {
                ProcessError.process(ex, request);
            }
            Estudent stu = bean.find(Long.parseLong(request.getParameter("student")));
            request.setAttribute("student", stu);
            List<Class> resultado = bean.loadClass(stu.getStudentid());
            request.setAttribute("clases", resultado);
            request.getRequestDispatcher("page/estudiantes.jsp?accion=viewclass").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("accion");
        if ("grabarnuevo".equals(type)) {
            Estudent resultado = new Estudent();
            resultado.setStudentid(Long.parseLong(request.getParameter("id")));
            resultado.setLastname(request.getParameter("lastname"));
            resultado.setFirstname(request.getParameter("firstname"));
            try {
                bean.persist(resultado);
            } catch (Exception ex) {
                ProcessError.process(ex, request);
            }
            List<Estudent> lista = bean.loadAll();
            request.setAttribute("estudiantes", lista);
            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);
        } else if ("grabarmod".equals(type)) {
            Estudent estudito = bean.find(Long.parseLong(request.getParameter("id")));
            estudito.setLastname(request.getParameter("lastname"));
            estudito.setFirstname(request.getParameter("firstname"));
            try {
                bean.update(estudito);
            } catch (Exception ex) {
                ProcessError.process(ex, request);
            }
            List<Estudent> lista = bean.loadAll();
            request.setAttribute("estudiantes", lista);
            request.getRequestDispatcher("page/estudiantes.jsp").forward(request, response);
        } else if ("grabarclass".equals(type)) {
            ClassEstudent estudito = new ClassEstudent();
            estudito.setStudentid(Long.parseLong(request.getParameter("id")));
            estudito.setCodeclass(Long.parseLong(request.getParameter("clase")));

            try {
                stuclass.persist(estudito);
            } catch (Exception ex) {
                ProcessError.process(ex, request);
            }

            Estudent stu = bean.find(Long.parseLong(request.getParameter("id")));
            request.setAttribute("student", stu);
            List<Class> resultado = bean.loadClass(stu.getStudentid());
            request.setAttribute("clases", resultado);
            request.getRequestDispatcher("page/estudiantes.jsp?accion=viewclass").forward(request, response);
        }

    }
}
