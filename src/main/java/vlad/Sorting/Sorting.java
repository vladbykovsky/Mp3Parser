package vlad.Sorting;

import vlad.Mp3File.Album;
import vlad.Mp3File.Artist;
import vlad.Mp3File.Song;
import vlad.Mp3File.SongName;
import vlad.Track.Track;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Sorting {

    public Song sortSong(List<Track> listTracks){

        Song song = new Song();

        for (Track track : listTracks) {
            if(!containsNameInArtists(song.getListArtist(), track.getArtist())){
                song.getListArtist().add(new Artist(track.getArtist()));
            }

            for(int i = 0; i < song.getListArtist().size(); i++){
                if ((song.getListArtist().get(i).getName().equals(track.getArtist()))&&
                        (!containsNameInAlboms(song.getListArtist().get(i).getListAlbum(), track.getAlbum())))
                    song.getListArtist().get(i).getListAlbum().add(new Album(track.getAlbum()));

                for(int j = 0; j < song.getListArtist().get(i).getListAlbum().size(); j++){
                    if ((song.getListArtist().get(i).getListAlbum().get(j).getName().equals(track.getAlbum()))&&
                            (!containsNameInSongs(song.getListArtist().get(i).getListAlbum().get(j).getListSongName()
                                    , track.getSongName())))
                            song.getListArtist().get(i).getListAlbum().get(j).getListSongName()
                                .add(new SongName(track.getSongName(), track.getDuration(), track.getPath(), track.getContrSumm()));

                }
            }
        }

        return song;

    }

    public void toHtml(Song song){

        String text = "";

        for (Artist a : song.getListArtist()){
            text += "<p><b>Артист: "+a.getName()+"</h3></b><br>";
            for (Album album : a.getListAlbum()){
                text += "&emsp; <b>Альбом:</b> "+album.getName()+"<br>";
                for (SongName songName : album.getListSongName()){
                    text += "&emsp; &emsp; <b>Название:</b> "+songName.getSongName()+" <b>Длительность:</b>"
                            +songName.getDuration()/60+"мин "
                            +songName.getDuration()%60+"сек"+" <b>Путь:</b> "+songName.getPath()+"<br>";
                }
            }
        }
        String htmlCode = "<html><body>" + text + "</body></html>";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("D:\\Develop\\Java\\Кутовенко\\Проекты\\Mp3Parser\\file1.html", "UTF-8");
            writer.println(htmlCode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public boolean containsNameInArtists(final List<Artist> list, final String name){
        return list.stream().anyMatch(o -> o.getName().equals(name));
    }
    public boolean containsNameInAlboms(final List<Album> list, final String name){
        return list.stream().anyMatch(o -> o.getName().equals(name));
    }
    public boolean containsNameInSongs(final List<SongName> list, final String name){
        return list.stream().anyMatch(o -> o.getSongName().equals(name));
    }

}
