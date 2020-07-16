package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "login", unique = true)
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "boxes")
    @OneToMany(mappedBy = "user")
    private List<Box> boxes;

    public Long getId()                         { return id; }
    public String getLogin()                    { return login; }
    public String getPassword()                 { return password; }
    public List<Box> getBoxes()                 { return boxes; }
    public void setLogin(String login)          { this.login = login; }
    public void setPassword(String password)    { this.password = password; }
    public void setBoxes(List<Box> boxes)       { this.boxes = boxes; }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", login='" + login + '\'' + ", password='" + password + '\'' + ", boxes=" + boxes + '}';
    }
}
