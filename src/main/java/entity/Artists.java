package entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Clasa Artist este o entitate.
 * Am referentiat catre tabelul artists din baza de date
 * Am realizat de asemenea un namedQuery pentru findByName.
 */
@Entity
@Table(name = "ARTISTS", schema = "", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Artist.findByName",
                query = "SELECT a FROM Artists a WHERE a.name = :name")
})
public class Artists {

    @Id
    @SequenceGenerator(name = "SequenceLocIdGenerator", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceLocIdGenerator")
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNTRY")
    private String country;



    public Artists() {}

    public Artists(String name, String country) {
        this.setName(name);
        this.setCountry(country);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Artist: " + name + " from " + country;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artists artists = (Artists) o;
        return id == artists.id &&
                name.equals(artists.name) &&
                country.equals(artists.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }
}
