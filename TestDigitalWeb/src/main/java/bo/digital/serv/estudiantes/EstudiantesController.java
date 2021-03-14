package bo.digital.serv.estudiantes;

import bo.digital.colege.dao.ClassDAO;
import bo.digital.colege.dao.ClassStudentDAO;
import bo.digital.colege.dao.StudentsDAO;
import bo.digital.colege.entities.ClassEstudent;
import bo.digital.colege.entities.Estudent;
import bo.digital.common.error.ProcessError;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Programmercito <devtecpro.org>
 */
@Controller
@RequestMapping("/student")
@Transactional
public class EstudiantesController {

    private static final long serialVersionUID = 1L;
    @EJB
    StudentsDAO bean;
    @EJB
    ClassDAO ejbclass;
    @EJB
    ClassStudentDAO stuclass;

    @RequestMapping(method = RequestMethod.GET)
    public String get(@RequestParam(required = false) String accion,
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String student,
            @RequestParam(required = false, name = "class") String classe,
            ModelMap model) {

        String type = accion;
        if (type == null) {
            List<Estudent> resultado = bean.loadAll();
            model.addAttribute("estudiantes", resultado);
        } else if ("nuevo".equals(type)) {
        } else if ("modificar".equals(type)) {
            Estudent estudito = bean.find(Long.parseLong(id));
            model.addAttribute("modificame", estudito);
        } else if ("eliminar".equals(type)) {
            Estudent estudito = bean.find(Long.parseLong(id));

            try {
                bean.remove(estudito);
            } catch (Exception ex) {
                ProcessError.process(ex, model);
            }

            List<Estudent> resultado = bean.loadAll();
            model.addAttribute("estudiantes", resultado);

        } else if ("viewclass".equals(type)) {
            Estudent estudito = bean.find(Long.parseLong(id));
            model.addAttribute("student", estudito);
            List<bo.digital.colege.entities.Class> resultado = bean.loadClass(estudito.getStudentid());
            model.addAttribute("clases", resultado);
        } else if ("nuevoclass".equals(type)) {
            Estudent estudito = bean.find(Long.parseLong(id));
            model.addAttribute("student", estudito);
            List<bo.digital.colege.entities.Class> resultado = ejbclass.loadAll();
            model.addAttribute("clases", resultado);
        } else if ("deleterel".equals(type)) {
            ClassEstudent relacion = new ClassEstudent();
            relacion.setCodeclass(Long.parseLong(classe));
            relacion.setStudentid(Long.parseLong(student));
            try {
                stuclass.remove(relacion);
            } catch (Exception ex) {
                ProcessError.process(ex, model);
            }
            Estudent stu = bean.find(Long.parseLong(student));
            model.addAttribute("student", stu);
            List<bo.digital.colege.entities.Class> resultado = bean.loadClass(stu.getStudentid());
            model.addAttribute("clases", resultado);
        }
        return "estudiantes";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String post(@RequestParam(required = false) String accion,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String id,
            @RequestParam(required = false, name = "firstname") String firstname,
            @RequestParam(required = false, name = "clase") String clase,
            ModelMap model) {
        String type = accion;
        if ("grabarnuevo".equals(type)) {
            Estudent resultado = new Estudent();
            resultado.setStudentid(Long.parseLong(id));
            resultado.setLastname(lastname);
            resultado.setFirstname(firstname);
            try {
                bean.persist(resultado);
            } catch (Exception ex) {
                ProcessError.process(ex, model);
            }
            List<Estudent> lista = bean.loadAll();
            model.addAttribute("estudiantes", lista);
        } else if ("grabarmod".equals(type)) {
            Estudent estudito = bean.find(Long.parseLong(id));
            estudito.setLastname(lastname);
            estudito.setFirstname(firstname);
            try {
                bean.update(estudito);
            } catch (Exception ex) {
                ProcessError.process(ex, model);
            }
            List<Estudent> lista = bean.loadAll();
            model.addAttribute("estudiantes", lista);
        } else if ("grabarclass".equals(type)) {
            ClassEstudent estudito = new ClassEstudent();
            estudito.setStudentid(Long.parseLong(id));
            estudito.setCodeclass(Long.parseLong(clase));

            try {
                stuclass.persist(estudito);
            } catch (Exception ex) {
                ProcessError.process(ex, model);
            }

            Estudent stu = bean.find(Long.parseLong(id));
            model.addAttribute("student", stu);
            List<bo.digital.colege.entities.Class> resultado = bean.loadClass(stu.getStudentid());
            model.addAttribute("clases", resultado);
        }
        return "estudiantes";
    }
}
