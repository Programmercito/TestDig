/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.colege.dao;

import bo.digital.colege.entities.Class;
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
public class ClassDAO {

    public void remove(Class student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(student);
            session.flush();
        }
    }

    public void persist(Class student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.flush();
        }
    }

    public void update(Class student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(student);
            session.flush();
        }
    }

    public Class find(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Class estu = session.find(Class.class, id);
            return estu;
        }
    }

    public List<Class> LoadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createNativeQuery("select * from class", Class.class).getResultList();
        }
    }
}
