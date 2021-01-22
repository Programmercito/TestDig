package bo.digital.colege.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hered
 */
@Entity
@Table(name = "STUDENT")
public class Estudent {

    @Id
    @Column(name = "STUDENTID", nullable = false, updatable = true, unique = true)
    private Long studentid;
    
    @Column(name = "LASTNAME", nullable = false, updatable = true)
    private String lastname;
    
    @Column(name = "FIRSTNAME", nullable = false, updatable = true)
    private String firstname;

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

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
