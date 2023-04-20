

package ptithcm.entity;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
    name = "Staffs"
)
public class Staff {
    @Id
    @Column(
        name = "Id"
    )
    private String id;
    @Column(
        name = "Name"
    )
    private String name;
    @Column(
        name = "Gender"
    )
    private Boolean gender;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(
        pattern = "dd/MM/yyyy"
    )
    @Column(
        name = "Birthday"
    )
    private Date birthday;
    @Column(
        name = "Photo"
    )
    private String photo;
    @Column(
        name = "Email"
    )
    private String email;
    @Column(
        name = "Phone"
    )
    private String phone;
    @Column(
        name = "Salary"
    )
    private Float salary;
    @Column(
        name = "Notes"
    )
    private String note;
    @ManyToOne
    @JoinColumn(
        name = "DepartId"
    )
    private Depart depart;
    @OneToMany(
        mappedBy = "staff",
        fetch = FetchType.EAGER
    )
    private Collection<Record> records;

    public Staff(String id, String name, Boolean gender, Date birthday, String photo, String email, String phone, Float salary, String note, Depart depart, Collection<Record> records) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.photo = photo;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.note = note;
        this.depart = depart;
        this.records = records;
    }

    public Staff() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return this.gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getSalary() {
        return this.salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Depart getDepart() {
        return this.depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }

    public Collection<Record> getRecords() {
        return this.records;
    }

    public void setRecord(Collection<Record> records) {
        this.records = records;
    }
}
