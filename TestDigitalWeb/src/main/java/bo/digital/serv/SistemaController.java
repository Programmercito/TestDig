package bo.digital.serv;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Programmercito <devtecpro.org>
 */
@Controller
@RequestMapping("/")
public class SistemaController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {
       return "redirect:/index";
    }
}
