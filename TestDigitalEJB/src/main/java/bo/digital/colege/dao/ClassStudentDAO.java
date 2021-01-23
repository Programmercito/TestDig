package bo.digital.colege.dao;

import bo.digital.colege.entities.Class;
import bo.digital.colege.entities.ClassEstudent;
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
public class ClassStudentDAO {

    public void remove(ClassEstudent student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(student);
            session.flush();
        }
    }

    public void persist(ClassEstudent student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.flush();
        }
    }

    public void update(ClassEstudent student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(student);
            session.flush();
        }
    }

    public ClassEstudent find(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ClassEstudent estu = session.find(ClassEstudent.class, id);
            return estu;
        }
    }

}
