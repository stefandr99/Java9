package app;

import com.github.javafaker.Faker;
import entity.Albums;
import entity.Artists;
import entity.Charts;
import repo.*;

import java.sql.SQLException;
import java.util.*;

public class AlbumManager {
    public static void main(String[] args) throws SQLException {
        ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();
        ChartRepository chartRepository = new ChartRepository();
        AbstractRepository abstractRepository = new AbstractRepository<>();



        AlbumManager albumManager = new AlbumManager();
        albumManager.generateData();

        /*Artists artist = new Artists("Smiley", "Romania");
        Artists artist2 = new Artists("Michael Jackson", "SUA");
        Artists artist3 = new Artists("Dragoi Stefan", "Romania");

        abstractRepository.create(artist);
        artistRepository.create(artist2);
        abstractRepository.create(artist3);


        abstractRepository.create(new Albums("Acasa", artist, 2015));
        albumRepository.create(new Albums("Dangerous", artist2, 1991));
        abstractRepository.create(new Albums("Stefan's album", artist3, 2020));

        Albums album = albumRepository.findById(1);
        Albums album2 = albumRepository.findById(2);
        Albums album3 = albumRepository.findById(3);



        abstractRepository.create(new Charts(album, "artist", 1));
        chartRepository.create(new Charts(album2, "artist", 2));
        abstractRepository.create(new Charts(album3, "artist", 3));*/




        List<Charts> charts = new ArrayList<>(chartRepository.findByCriteria("artist"));
        for (Charts c : charts) {
            System.out.println(c);
        }

        List<Charts> charts2 = new ArrayList<>(chartRepository.findByCriteria("album"));
        for (Charts c : charts2) {
            System.out.println(c);
        }

        List<Charts> charts3 = new ArrayList<>(chartRepository.findByCriteria("genre"));
        for (Charts c : charts3) {
            System.out.println(c);
        }

    }

    public void generateData() throws SQLException {
        ArtistDaoJDBC artistDaoJDBC = new ArtistDaoJDBC();
        ArtistDaoJPA artistDaoJPA = new ArtistDaoJPA();
        AlbumDaoJDBC albumDaoJDBC = new AlbumDaoJDBC();
        AlbumDaoJPA albumDaoJPA = new AlbumDaoJPA();
        ChartDaoJDBC chartDaoJDBC = new ChartDaoJDBC();
        ChartDaoJPA chartDaoJPA = new ChartDaoJPA();

        Faker faker = new Faker();
        Random random = new Random();

        int place;
        int[] frArtist = new int[31], frAlbum = new int[31], frRock = new int[31], frElectronic = new int[31], frClassical = new int[31];
        Arrays.fill(frArtist, 0);
        Arrays.fill(frAlbum, 0);
        Arrays.fill(frRock, 0);
        Arrays.fill(frElectronic, 0);
        Arrays.fill(frClassical, 0);

        for(int i = 1; i <= 30; i++) {
            Artists artist = new Artists(faker.funnyName().name(), "Romania");
            if(i % 2 == 0)
                artistDaoJDBC.create(artist);
            else
                artistDaoJPA.create(artist);

            Albums album = new Albums(faker.food().ingredient() + faker.gameOfThrones().city(), artist, 2020);
            if(i % 3 == 0)
                album.setGenre("Rock");
            else if(i % 3 == 1)
                album.setGenre("electronic");
            else album.setGenre("classical");

            if(i % 2 == 0)
                albumDaoJDBC.create(album);
            else
                albumDaoJPA.create(album);

            while((frArtist[place = random.nextInt(30) + 1]) != 0) ;
            frArtist[place] = 1;
            Charts chart = new Charts(album, "artist", place);
            if(i % 2 == 0)
                chartDaoJDBC.create(chart);
            else chartDaoJPA.create(chart);

            while((frAlbum[place = random.nextInt(30) + 1]) != 0) ;
            frAlbum[place] = 1;
            Charts chart2 = new Charts(album, "album", place);
            if(i % 2 == 0)
                chartDaoJDBC.create(chart2);
            else chartDaoJPA.create(chart2);

            if(i % 3 == 0) {
                while((frRock[place = random.nextInt(10) + 1]) != 0) ;
                frRock[place] = 1;
                Charts chart3 = new Charts(album, "genre", place);
                if(i % 2 == 0)
                    chartDaoJDBC.create(chart3);
                else chartDaoJPA.create(chart3);
            }
            else if(i % 3 == 1) {
                while((frElectronic[place = random.nextInt(10) + 1]) != 0) ;
                frElectronic[place] = 1;
                Charts chart3 = new Charts(album, "genre", place);
                if(i % 2 == 0)
                    chartDaoJDBC.create(chart3);
                else chartDaoJPA.create(chart3);
            }
            else {
                while((frClassical[place = random.nextInt(10) + 1]) != 0) ;
                frClassical[place] = 1;
                Charts chart3 = new Charts(album, "genre", place);
                if(i % 2 == 0)
                    chartDaoJDBC.create(chart3);
                else chartDaoJPA.create(chart3);
            }
        }
    }
}
