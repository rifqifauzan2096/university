package id.co.university.service.wrapper;

import id.co.university.common.wrapper.EntityBaseWrapper;

public class LearningSubjectWrapper extends EntityBaseWrapper {

    private String subjectCode;
    private String subjectName;
    private Integer scs;

    public LearningSubjectWrapper() {
    }

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
}
