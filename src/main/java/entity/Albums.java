package entity;

import javax.persistence.*;

/**
 * Am implementat clasa Album care este o entitate. De asemenea referentiaza catre tabelul albums din baza de date
 */
@Entity
@Table(name = "ALBUMS", schema = "", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Album.findByName",
                query = "SELECT a FROM Albums a WHERE a.name = :name"),
        @NamedQuery(name = "Album.findByArtist",
                query = "SELECT a FROM Albums a WHERE a.artist_id.id = :artist")
})
public class Albums {
    @Id
    @SequenceGenerator(name = "SequenceLocIdGenerator2", sequenceName = "id_seq2", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceLocIdGenerator2")
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID", nullable = false)
    private Artists artist_id;

    @Column(name = "RELEASE_YEAR")
    private int release_year;

    @Column(name = "GENRE")
    private String genre;

    public Albums() {}

    public Albums(String name, Artists artist_id, int release_year) {
        this.setName(name);
        this.setArtist_id(artist_id);
        this.setRelease_year(release_year);
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

    public Artists getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Artists artist_id) {
        this.artist_id = artist_id;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Album: " + name  +
                " al artistului " + artist_id.getName() +
                " lansat in anul " + release_year;
    }
}
