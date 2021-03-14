package bo.digital.common.error;

import javax.ejb.EJBException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;

/**
 *
 * @author hered
 */
public class ProcessError {

    public static void process(Exception ex, ModelMap request) {
        if (ex instanceof EJBException) {
            String mensaje = "";
            try {
                mensaje = ex.getCause().getCause().getCause().getMessage();
                ex.printStackTrace();
            } catch (Exception e) {
                mensaje = "Error inesperado intente de nuevo";
            }
            request.addAttribute("error", mensaje);
        } else {
            throw new RuntimeException(ex);
        }
    }
}
