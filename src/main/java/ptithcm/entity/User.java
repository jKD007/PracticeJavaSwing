

package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "Users"
)
public class User {
    @Id
    @Column(
        name = "Username"
    )
    private String username;
    @Column(
        name = "Password"
    )
    private String password;
    @Column(
        name = "Fullname"
    )
    private String fullname;

    public User() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
