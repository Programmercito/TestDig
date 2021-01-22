/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.digital.colege.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author hered
 */
public class SearchPK implements Serializable {

    @Id
    @Column(name = "CODE", nullable = false, updatable = true)
    private Long code;
    @Id
    @Column(name = "STUDENTID", nullable = false, updatable = true)
    private Long studentid;

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
