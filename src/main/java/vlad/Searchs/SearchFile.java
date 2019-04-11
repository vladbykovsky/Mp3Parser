package vlad.Searchs;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import vlad.Track.Track;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchFile {

    public List<File> listFiles = new ArrayList<File>();
    public List<Mp3File> listMp3 = new ArrayList<Mp3File>();

    private static List<Track> listTracks = new ArrayList<Track>();

    public static List<Track> getListTracks() {
        return listTracks;
    }

    public void searchMuz(String sDir) {

        File myFile = new File(sDir);
        for (File file : myFile.listFiles()) {
            if (file.isDirectory()) {
                searchMuz(file.getAbsolutePath());
            }
            else {
                listFiles.add(file);
            }
        }
    }

    public void openMuzFile(){
        try {
            for (File f : listFiles){
                listMp3.add(new Mp3File(f.getPath()));
            }
        } catch (InvalidDataException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        }
    }

    public void createTrack(){
        for (Mp3File mp3File : listMp3){

            Track track = new Track();
            track.setArtist(mp3File.getId3v2Tag().getArtist());
            track.setAlbum(mp3File.getId3v2Tag().getAlbum());
            track.setSongName(mp3File.getId3v2Tag().getTitle());
            track.setDuration(mp3File.getLengthInSeconds());
            track.setPath(mp3File.getFilename());

            try {
                InputStream is = Files.newInputStream(Paths.get(mp3File.getFilename()));
                String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(is);
                track.setContrSumm(md5);
            } catch (IOException e){
                e.printStackTrace();
            }
            listTracks.add(track);
        }
    }

}
