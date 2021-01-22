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
class ClasStudentPK implements Serializable{

    @Column(name = "CODE_CLASS", nullable = false, updatable = true, unique = true)
    private Long codeclass;

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
