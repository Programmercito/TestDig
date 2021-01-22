package bo.digital.colege.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author hered
 */
@Entity
@Table(name = "CLASS_STUDENTS")
@IdClass(ClasStudentPK.class)
public class ClassEstudent {

    @Id
    @Column(name = "CODE_CLASS", nullable = false, updatable = true, unique = true)
    private Long codeclass;
    
    @Id
    @Column(name = "STUDENT_ID", nullable = false, updatable = true)
    private Long studentid;

    /**
     * @return the codeclass
     */
    public Long getCodeclass() {
        return codeclass;
    }

    /**
     * @param codeclass the codeclass to set
     */
    public void setCodeclass(Long codeclass) {
        this.codeclass = codeclass;
    }

    /**
     * @return the studentid
     */
    public Long getStudentid() {
        return studentid;
    }

    /**
     * @param studentid the studentid to set
     */
    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

}
