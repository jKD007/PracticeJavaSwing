
package ptithcm.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
    name = "Departs"
)
public class Depart {
    @Id
    @Column(
        name = "Id"
    )
    private String id;
    @Column(
        name = "Name"
    )
    private String name;
    @OneToMany(
        mappedBy = "depart",
        fetch = FetchType.EAGER
    )
    private Collection<Staff> staffs;

    public Depart(String id, String name, Collection<Staff> staffs) {
        this.id = id;
        this.name = name;
        this.staffs = staffs;
    }

    public Depart() {
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

    public Collection<Staff> getStaffs() {
        return this.staffs;
    }

    public void setStaffs(Collection<Staff> staffs) {
        this.staffs = staffs;
    }
}
