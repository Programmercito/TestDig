package bo.digital.colege.dao;

import bo.digital.colege.entities.Class;
import bo.digital.colege.entities.ClassStudentSearch;
import bo.digital.colege.entities.Estudent;
import bo.digital.hibernate.conf.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author programercito
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

    public List<Class> loadAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createNativeQuery("select * from class", Class.class).getResultList();
        }
    }

    public List<Estudent> loadStudents(Long clas) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery<Estudent> createNativeQuery = session.createNativeQuery("select * from student where studentid in (select student_id from class_students where code_class=?1 )", Estudent.class);
            createNativeQuery.setParameter(1, clas);
            return createNativeQuery.getResultList();

        }
    }

    public List<ClassStudentSearch> loadSearch(String code,String title, String description, String id, String firstname, String lastname) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String query="select row_number() over() as id, class.code,class.title, class.description,stu.studentid,stu.firstname,stu.lastname from "
                    + " CLASS_STUDENTS rel full outer join class on class.code=rel.code_class "
                    + " full outer join student stu on stu.studentid = rel.STUDENT_ID "
                    + " where "
                    + " COALESCE (cast(class.code as text),'') like concat('%',?1,'%')"
                    + " and COALESCE (class.title,'') like concat('%',?2,'%')"
                    + " and COALESCE (class.description,'') like concat('%',?3,'%')"
                    + " and COALESCE (cast(stu.studentid as text),'') like concat('%',?4,'%')"
                    + " and COALESCE (stu.lastname,'') like concat('%',?5,'%')"
                    + " and COALESCE (stu.firstname,'') like concat('%',?6,'%') order by class.code";
            NativeQuery<ClassStudentSearch> createNativeQuery = session.createNativeQuery(query, ClassStudentSearch.class);
            createNativeQuery.setParameter(1, code);
            createNativeQuery.setParameter(2, title);
            createNativeQuery.setParameter(3, description);
            createNativeQuery.setParameter(4, id);
            createNativeQuery.setParameter(5, lastname);
            createNativeQuery.setParameter(6, firstname);
            return createNativeQuery.getResultList();

        }
    }
}
