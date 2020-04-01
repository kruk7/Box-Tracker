package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "coordinates")
public class Coordinates
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "box", nullable = false)
    private Box box;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "time_stamp", nullable = false)
    private Timestamp timestamp;

    //----- Getters and Stetters -----
    public Long getId()
    { return id; }

    public Box getBox()
    { return box; }

    public void setBox(Box box)
    { this.box = box; }

    public double getLatitude()
    { return latitude; }

    public void setLatitude(double latitude)
    { this.latitude = latitude; }

    public double getLongitude()
    { return longitude; }

    public void setLongitude(double longitude)
    { this.longitude = longitude; }

    public Timestamp getTimestamp()
    { return timestamp; }

    public void setTimestamp(Timestamp timestamp)
    { this.timestamp = timestamp; }
}
