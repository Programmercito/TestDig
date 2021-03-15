
package bo.digital.colege.interfaces.repositorys;

import bo.digital.colege.entities.ClassStudentSearch;
import bo.digital.colege.entities.Classes;
import bo.digital.colege.entities.Estudent;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
/**
 *
 * @author Programmercito <devtecpro.org>
 */
@Repository
public interface IClassesRepository extends CrudRepository<Classes, Integer>, PagingAndSortingRepository<Classes, Integer> {


    public List<bo.digital.colege.entities.Classes> loadAll();

    public List<Estudent> loadStudents(Long clas);

    public List<ClassStudentSearch> loadSearch(String code, String title, String description, String id, String firstname, String lastname);

}
