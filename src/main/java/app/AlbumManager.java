package app;

import entity.Artist;
import repo.ArtistRepository;

public class AlbumManager {
    public static void main(String[] args) {
        ArtistRepository artistRepository = new ArtistRepository();
        artistRepository.create(new Artist("Dragoi Stefan", "Romania"));
        artistRepository.create(new Artist("Freddie Mercury", "UK"));
    }
}
