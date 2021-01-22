package bo.digital.common.error;

import javax.ejb.EJBException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hered
 */
public class ProcessError {

    public static void process(Exception ex, HttpServletRequest request) {
        if (ex instanceof EJBException) {
            String mensaje = "";
            try {
                mensaje = ex.getCause().getCause().getCause().getMessage();
                ex.printStackTrace();
            } catch (Exception e) {
                mensaje = "Error inesperado intente de nuevo";
            }
            request.setAttribute("error", mensaje);
        } else {
            throw new RuntimeException(ex);
        }
    }
}
