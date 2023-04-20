
package ptithcm.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
    name = "Records"
)
public class Record {
    @Id
    @GeneratedValue
    @Column(
        name = "Id"
    )
    private Integer id;
    @Column(
        name = "Type"
    )
    private Boolean type;
    @Column(
        name = "Reason"
    )
    private String reason;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(
        pattern = "dd/MM/yyyy"
    )
    @Column(
        name = "Date"
    )
    private Date date;
    @ManyToOne
    @JoinColumn(
        name = "StaffId"
    )
    private Staff staff;

    public Record(Integer id, Boolean type, String reason, Date date, Staff staff) {
        this.id = id;
        this.type = type;
        this.reason = reason;
        this.date = date;
        this.staff = staff;
    }

    public Record() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getType() {
        return this.type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
