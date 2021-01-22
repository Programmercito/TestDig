/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.colege.dao;

import bo.digital.colege.entities.Estudent;
import bo.digital.hibernate.conf.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.hibernate.Session;

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

    public List<Estudent> LoadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createNativeQuery("select * from student", Estudent.class).getResultList();
        }
    }
}
