package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "boxes")
public class Box
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "box_id")
    private Long id;

    @Column(name = "serial", nullable = false, unique = true)
    private int serial;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy="box")
    private List<Coordinates> coordinates;

    public Long getId()
    { return id; }

    public int getSerial()
    { return serial; }

    public void setSerial(int serial)
    { this.serial = serial; }

    public String getName()
    { return name; }

    public void setName(String name)
    { this.name = name; }

    public User getUser()
    { return user; }

    public void setUser(User user)
    { this.user = user; }

    public List<Coordinates> getCoordinates()
    { return coordinates; }

    public void setCoordinates(List<Coordinates> coordinates)
    { this.coordinates = coordinates; }

    @Override
    public String toString()
    {
        return "Box{" + "id=" + id + ", serial=" + serial + ", name='" + name + '\'' + ", user=" + user + ", coordinates=" + coordinates + '}';
    }
}
