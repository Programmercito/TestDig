/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.colege.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author hered
 */
@Entity
@IdClass(SearchPK.class)
public class ClassStudentSearch implements Serializable {

    @Id
    @Column(name = "CODE", nullable = false, updatable = true, unique = true)
    private Long code;

    @Column(name = "TITLE", nullable = false, updatable = true)
    private String title;

    @Column(name = "DESCRIPTION", nullable = false, updatable = true)
    private String description;

    @Id
    @Column(name = "STUDENTID", nullable = false, updatable = true, unique = true)
    private Long studentid;

    @Column(name = "LASTNAME", nullable = false, updatable = true)
    private String lastname;

    @Column(name = "FIRSTNAME", nullable = false, updatable = true)
    private String firstname;

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
