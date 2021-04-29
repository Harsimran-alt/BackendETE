package com.upgrad.backend.ETE.Model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etetable")
public class Employee {

    private long id;
    private String Name;
    private Integer Age;
    private String emailId;
    private String Address;
    private String Phone;

    public Employee() {

    }

    public Employee(String Name,Integer Age, String Address , String emailId, String Phone) {
        this.Name = Name;
        this.Age = Age;
        this.emailId = emailId;
        this.Address=Address;
        this.Phone=Phone;
    }

    @Column(name = "Name", nullable = false)
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }

    @Column(name = "Age", nullable = false)
    public Integer getAge() {
        return Age;
    }
    public void setAge(Integer Age) {
        this.Age = Age;
    }

    @Column(name = "Address", nullable = false)
    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }
    @Id
    @Column(name = "email_address", nullable = false, unique = true)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    @Column(name = "ph_no", nullable = false)
    public String getphone() {
        return Phone;
    }
    public void setphone(String phone) {
        this.Phone= phone;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "name='" + Name + '\'' +
                ", age=" + Age +
                ", emailId='" + emailId + '\'' +
                ", address='" + Address + '\'' +
                ", phone=" + Phone +
                '}';
    }

}
