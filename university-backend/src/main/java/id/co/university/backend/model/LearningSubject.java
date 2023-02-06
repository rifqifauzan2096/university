package id.co.university.backend.model;

import id.co.university.common.model.EntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "learning_subject")
public class LearningSubject extends EntityBase {


    @Column(name = "subject_code", length = 10)
    private String subjectCode;

    @Column(name = "subject_name", length = 100)
    private String subjectName;

    @Column(name = "scs", length = 3)
    private Integer scs;

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getScs() {
        return scs;
    }

    public void setScs(Integer scs) {
        this.scs = scs;
    }

    @Override
    public String toString() {
        return "LearningSubject{" +
                "subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", scs=" + scs +
                '}';
    }
}
