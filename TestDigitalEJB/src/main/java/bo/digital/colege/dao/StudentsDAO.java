package bo.digital.colege.dao;

import bo.digital.colege.entities.Class;
import bo.digital.colege.entities.Estudent;
import bo.digital.hibernate.conf.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class StudentsDAO {

    public void remove(Estudent student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(student);
            session.flush();
        }
    }

    public void persist(Estudent student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.flush();
        }
    }

    public void update(Estudent student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(student);
            session.flush();
        }
    }

    public Estudent find(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Estudent estu = session.find(Estudent.class, id);
            return estu;
        }
    }

    public List<Estudent> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createNativeQuery("select * from student", Estudent.class).getResultList();
        }
    }

    public List<Class> loadClass(Long student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery<Class> createNativeQuery = session.createNativeQuery("select * from class where code in (select code_class from class_students where student_id=?1 )", Class.class);
            createNativeQuery.setParameter(1, student);
            return createNativeQuery.getResultList();

        }
    }

}
