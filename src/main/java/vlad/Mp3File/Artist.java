package vlad.Mp3File;

import java.util.ArrayList;
import java.util.List;

public class Artist {

    private String name;

    public Artist(String name){
        this.name = name;
    }

    private List<Album> listAlbum = new ArrayList<Album>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getListAlbum() {
        return listAlbum;
    }

    public void setListAlbum(List<Album> listAlbum) {
        this.listAlbum = listAlbum;
    }

}
