package bo.digital.serv.clase;

import bo.digital.colege.dao.ClassDAO;
import bo.digital.colege.entities.Estudent;
import bo.digital.common.error.ProcessError;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/class")
@Transactional
public class ClassController {

    private static final long serialVersionUID = 1L;

    @EJB
    ClassDAO bean;

    @RequestMapping(method = RequestMethod.POST)
    public String get(@RequestParam(required = false) String accion,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            ModelMap model) {
        String type = accion;
        switch (accion) {

            case ("grabarnuevo"):
                bo.digital.colege.entities.Class resultado = new bo.digital.colege.entities.Class();
                resultado.setCode(Long.parseLong(code));
                resultado.setTitle(title);
                resultado.setDescription(description);
                try {
                    bean.persist(resultado);
                } catch (Exception ex) {
                    ProcessError.process(ex, model);
                }

                List<bo.digital.colege.entities.Class> lista = bean.loadAll();
                model.addAttribute("estudiantes", lista);
                break;
            case ("grabarmod"):
                bo.digital.colege.entities.Class estudito = bean.find(Long.parseLong(code));
                estudito.setTitle(title);
                estudito.setDescription(description);
                try {
                    bean.update(estudito);
                } catch (Exception ex) {
                    ProcessError.process(ex, model);
                }

                List<bo.digital.colege.entities.Class> list = bean.loadAll();
                model.addAttribute("estudiantes", list);
                break;
        }
        return "clases";

    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(@RequestParam(required = false) String id, @RequestParam(required = false) String accion, ModelMap model) {
        String type = accion;
        if (type == null) {
            type = "";
        }
        switch (type) {
            case (""):
                List<bo.digital.colege.entities.Class> resultado = bean.loadAll();
                model.addAttribute("estudiantes", resultado);
                break;
            case ("modificar"):
                bo.digital.colege.entities.Class estudito = bean.find(Long.parseLong(id));
                model.addAttribute("modificame", estudito);
                break;
            case ("eliminar"):
                bo.digital.colege.entities.Class estudit = bean.find(Long.parseLong(id));
                try {
                    bean.remove(estudit);
                } catch (Exception ex) {
                    ProcessError.process(ex, model);
                }
                List<bo.digital.colege.entities.Class> resul = bean.loadAll();
                model.addAttribute("estudiantes", resul);
                break;
            case ("viewstudent"):
                bo.digital.colege.entities.Class estu = bean.find(Long.parseLong(id));
                model.addAttribute("clase", estu);
                List<Estudent> result = bean.loadStudents(estu.getCode());
                model.addAttribute("estudiantes", result);
                break;
        }
        return "clases";
    }
}
