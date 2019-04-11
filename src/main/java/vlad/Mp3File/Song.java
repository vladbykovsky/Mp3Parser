package vlad.Mp3File;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private List<Artist> listArtist = new ArrayList<>();

    public List<Artist> getListArtist() {
        return listArtist;
    }

    public void setListArtist(List<Artist> listArtist) {
        this.listArtist = listArtist;
    }

}

