package models;

import javax.persistence.*;
@Entity(name = "AgentPasswords010")
@Table(name = "AgentPasswords010")
public class AgentPasswords010 {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "username010")
    private String username010;

    @Column(name = "password010")
    private String password010;

    public AgentPasswords010() {}

    public String getUsername010() {
        return username010;
    }

    public void setUsername010(String clientCompId010) {
        this.username010 = username010;
    }

    public String getPassword010() {

        return password010;
    }

    public void setPassword010(String password010) {
        this.password010 = password010;
    }
}
