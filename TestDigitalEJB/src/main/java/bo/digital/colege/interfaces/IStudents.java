package bo.digital.colege.interfaces;

import bo.digital.colege.entities.Estudent;
import bo.digital.hibernate.conf.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author Programmercito <devtecpro.org>
 */
public interface IStudents {

    public void remove(Estudent student);

    public void persist(Estudent student);

    public void update(Estudent student);

    public Estudent find(Long id);

    public List<Estudent> loadAll();

    public List<bo.digital.colege.entities.Classes> loadClass(Long student);

}
