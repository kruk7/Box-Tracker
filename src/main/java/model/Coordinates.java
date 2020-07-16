package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "coordinates")
public class Coordinates implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coord_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "box_id")
    private Box box;
    @Column(name = "latitude", nullable = false)
    private Double latitude;
    @Column(name = "longitude", nullable = false)
    private Double longitude;
    @Column(name = "time_stamp", nullable = false)
    private java.sql.Timestamp timestamp;

    public Long getId()                             { return id; }
    public Box getBox()                             { return box; }
    public Double getLatitude()                     { return latitude; }
    public Double getLongitude()                    { return longitude; }
    public Timestamp getTimestamp()                 { return timestamp; }
    public void setBox(Box box)                     { this.box = box; }
    public void setLatitude(double latitude)        { this.latitude = latitude; }
    public void setLongitude(double longitude)      { this.longitude = longitude; }
    public void setTimestamp(Timestamp timestamp)   { this.timestamp = timestamp; }

    @Override
    public String toString()
    {
        return "Coordinates{" + "id=" + id + ", box=" + box + ", latitude=" + latitude + ", longitude=" + longitude + ", timestamp=" + timestamp + '}';
    }
}
