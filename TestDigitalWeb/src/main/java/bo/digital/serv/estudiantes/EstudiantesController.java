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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            ModelMap model, RedirectAttributes redirectAttributes) {

        String type = accion;
        if (null == type) {
            List<Estudent> resultado = bean.loadAll();
            model.addAttribute("estudiantes", resultado);
        } else {
            switch (type) {
                case "nuevo":
                    break;
                case "modificar": {
                    Estudent estudito = bean.find(Long.parseLong(id));
                    model.addAttribute("modificame", estudito);
                    break;
                }
                case "eliminar": {
                    Estudent estudito = bean.find(Long.parseLong(id));
                    try {
                        bean.remove(estudito);
                    } catch (Exception ex) {
                        ProcessError.process(ex, model);
                    }
                    List<Estudent> resultado = bean.loadAll();
                    model.addAttribute("estudiantes", resultado);
                    break;
                }
                case "viewclass": {
                    Estudent estudito = bean.find(Long.parseLong(id));
                    model.addAttribute("student", estudito);
                    List<bo.digital.colege.entities.Class> resultado = bean.loadClass(estudito.getStudentid());
                    model.addAttribute("clases", resultado);
                    break;
                }
                case "nuevoclass": {
                    Estudent estudito = bean.find(Long.parseLong(id));
                    model.addAttribute("student", estudito);
                    List<bo.digital.colege.entities.Class> resultado = ejbclass.loadAll();
                    model.addAttribute("clases", resultado);
                    break;
                }
                case "deleterel": {
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
                    accion = "viewclass";
                    break;
                }
                default:
                    break;
            }
        }
        model.addAttribute("accion", accion);
        return "estudiantes";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(@RequestParam(required = false) String accion,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String clase,
            ModelMap model, RedirectAttributes redirectAttributes) {
        String type = accion;

        if (null != type) {
            switch (type) {
                case "grabarnuevo": {
                    Estudent resultado = new Estudent();
                    try {
                        resultado.setStudentid(Long.parseLong(id));
                        resultado.setLastname(lastname);
                        resultado.setFirstname(firstname);
                        bean.persist(resultado);
                    } catch (Exception ex) {
                        ProcessError.process(ex, model);
                    }
                    List<Estudent> lista = bean.loadAll();
                    model.addAttribute("estudiantes", lista);
                    break;
                }
                case "grabarmod": {
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
                    break;
                }
                case "grabarclass": {
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
                    accion = "viewclass";
                    break;
                }
                default:
                    break;
            }
        }
        model.addAttribute("accion", accion);
        return "estudiantes";
    }
}
