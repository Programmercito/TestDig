package bo.digital.colege.interfaces;

import bo.digital.colege.entities.ClassEstudent;
import bo.digital.hibernate.conf.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Programmercito <devtecpro.org>
 */
public interface IStudentsClasses {

    public void remove(ClassEstudent student);

    public void persist(ClassEstudent student);

    public void update(ClassEstudent student);

    public ClassEstudent find(Long id);

}
