package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table (name = "Charts", schema = "", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Charts.findByCriteria",
                query = "select c from Charts c where criteria = :criteria order by c.rank asc")
})
public class Charts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID", nullable = false)
    private Albums album_id;

    @Column(name = "CRITERIA")
    private String criteria;

    @Column(name = "RANK")
    private int rank;

    public Charts() {}

    public Charts(Albums id, String criteria, int rank) {
        this.setAlbum_id(id);
        this.setCriteria(criteria);
        this.setRank(rank);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Albums getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(Albums album_id) {
        this.album_id = album_id;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + ". " +
                "Album: " + album_id.getName() + " (" +
                album_id.getGenre() + ", " +
                album_id.getRelease_year() + "), " +
                "artist: " + album_id.getArtist_id().getName() + " from " +
                album_id.getArtist_id().getCountry();
    }
}
