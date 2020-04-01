package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "boxes")
public class Box
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial", nullable = false, unique = true)
    private int serial;

    @Column(name = "name")
    private String name;

    @Column(name = "user")
    private User user;

    @Column(name = "coordinates")
    private List<Coordinates> coordinates;

    //----- Getters and Stetters -----
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
}