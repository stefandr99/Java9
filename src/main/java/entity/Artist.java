package entity;

import javax.persistence.*;

/**
 * Clasa Artist este o entitate.
 * Am referentiat catre tabelul artists din baza de date
 * Am realizat de asemenea un namedQuery pentru findByName.
 */
@Entity
@Table(name = "ARTISTS", schema = "DBB", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Artist.findByName",
                query = "SELECT a FROM Artist a WHERE a.name = :name")
})
public class Artist {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;



    public Artist() {}

    public Artist(String name, String country) {
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
}
