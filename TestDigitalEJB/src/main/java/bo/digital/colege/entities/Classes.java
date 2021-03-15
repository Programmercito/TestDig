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
@Table(name = "CLASS")
public class Classes {

    @Id
    @Column(name = "CODE", nullable = false, updatable = true, unique = true)
    private Long code;
    
    @Column(name = "TITLE", nullable = false, updatable = true)
    private String title;
    
    @Column(name = "DESCRIPTION", nullable = false, updatable = true)
    private String description;

    /**
     * @return the code
     */
    public Long getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(Long code) {
        this.code = code;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
