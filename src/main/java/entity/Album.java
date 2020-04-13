package entity;

import javax.persistence.*;

/**
 * Am implementat clasa Album care este o entitate. De asemenea referentiaza catre tabelul albums din baza de date
 */
@Entity
@Table(name = "ALBUMS", schema = "DBB", catalog = "")
public class Album {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID", nullable = false)
    private Artist artist_id;

    @Column(name = "RELEASE_YEAR")
    private int release_year;

    public Album() {}

    public Album(String name, Artist artist_id, int release_year) {
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

    public Artist getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Artist artist_id) {
        this.artist_id = artist_id;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
}
