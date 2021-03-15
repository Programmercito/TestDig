/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.colege.interfaces;

import bo.digital.colege.entities.ClassStudentSearch;
import bo.digital.colege.entities.Estudent;
import bo.digital.hibernate.conf.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author Programmercito <devtecpro.org>
 */
public interface IClasses {

    public void remove(bo.digital.colege.entities.Classes student);

    public void persist(bo.digital.colege.entities.Classes student);

    public void update(bo.digital.colege.entities.Classes student);

    public bo.digital.colege.entities.Classes find(Long id);

    public List<bo.digital.colege.entities.Classes> loadAll();

    public List<Estudent> loadStudents(Long clas);

    public List<ClassStudentSearch> loadSearch(String code, String title, String description, String id, String firstname, String lastname);

}
