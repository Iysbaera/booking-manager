package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Entity representing a hotel.
 *
 * @see Room
 * @author Ivo Hradek
 */
@Entity
public class Hotel {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long Id;

    @OneToMany(mappedBy = "hotel")
    private Collection<Room> rooms = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }
}
