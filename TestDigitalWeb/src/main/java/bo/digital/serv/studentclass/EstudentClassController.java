package bo.digital.serv.studentclass;

import bo.digital.colege.dao.ClassDAO;
import bo.digital.colege.entities.ClassStudentSearch;
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
@RequestMapping("/studentclass")
@Transactional
public class EstudentClassController {

    private static final long serialVersionUID = 1L;
    @EJB
    ClassDAO clas;

    @RequestMapping(method = RequestMethod.GET)
    public String get(@RequestParam(required = false) String type,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            ModelMap model) {

        String tipo = type;
        if (tipo == null) {
            List<ClassStudentSearch> loadSearch = clas.loadSearch(code, title, description, id, firstname, lastname);
            model.addAttribute("busqueda", loadSearch);
        }
        return "estudianteclase";
    }
}
