package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String login;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Box> boxes;

    //----- Getters and Stetters -----
    public Long getId()
    { return id; }

    public String getLogin()
    { return login; }

    public void setLogin(String login)
    { this.login = login; }

    public String getPassword()
    { return password; }

    public void setPassword(String password)
    { this.password = password; }

    public List<Box> getBoxes()
    { return boxes; }

    public void setBoxes(List<Box> boxes)
    { this.boxes = boxes; }
}
