package vlad.Mp3File;

import java.util.ArrayList;
import java.util.List;

public class Album {

    public Album(String name) {
        this.name = name;
    }

    private String name;

    private List<SongName> listSongName = new ArrayList<SongName>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SongName> getListSongName() {
        return listSongName;
    }

    public void setListSongName(List<SongName> listSongName) {
        this.listSongName = listSongName;
    }

}
