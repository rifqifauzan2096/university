package id.co.university.backend.model;

import id.co.university.common.model.EntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = {"nim", "phone_number"}))
public class Student extends EntityBase {

    private final static long serialVersionUID = -1319045683503877528L;


    @Column(name = "nim", length = 10, unique = true)
    private String nim;

    @Column(name = "fullname", length = 50)
    private String fullname;

    @Column(name = "gender", length = 50)
    private String gender;

    @Column(name = "age", length = 2)
    private Integer age;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone_number", length = 12, unique = true)
    private String phoneNumber;


    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nim='" + nim + '\'' +
                ", fullname='" + fullname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
