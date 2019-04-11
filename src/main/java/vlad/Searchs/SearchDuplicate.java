package vlad.Searchs;

import org.apache.log4j.Logger;
import vlad.Mp3File.Artist;
import vlad.Track.Track;

import java.util.*;

public class SearchDuplicate {

    private List<String> listDuplicateSumm = new ArrayList<String>();
    private List<Track> listTracks = new ArrayList<>();
    private List<Track> listDuplicateSongs = new ArrayList<>();


    public void groupDuplicateSumm(){

        listTracks.addAll(SearchFile.getListTracks());

        for (int i = 0; i < listTracks.size() - 1; i++) {
            for (int j = i + 1; j < listTracks.size(); j++) {
                if (listTracks.get(i).getContrSumm().equals(listTracks.get(j).getContrSumm())) {
                    listDuplicateSumm.add(listTracks.get(i).getContrSumm());
                    listTracks.remove(j);
                }
            }
        }
    }

    public void duplicateSummToLog(List<Artist> songs){
        final Logger logfile2 = Logger.getLogger("log1");
        int i=1;
        for(String md: listDuplicateSumm) {
            logfile2.info("<b>Дубликаты</b> - "+ i + "<br>");
            for(Track track : SearchFile.getListTracks()){
                if(md.equals(track.getContrSumm())) {
                            logfile2.info(track.getPath() + "<br>");
                }
            }
            i++;
        }
        logfile2.info("<br>");
    }

    public void groupDuplicateSongs(){

        for(int i = 0; i < SearchFile.getListTracks().size()-1; i++) {
            for(int j = i + 1; j < SearchFile.getListTracks().size(); j++) {
                if((SearchFile.getListTracks().get(i).getArtist().equals(SearchFile.getListTracks().get(j).getArtist()))&&
                        (SearchFile.getListTracks().get(i).getAlbum().equals(SearchFile.getListTracks().get(j).getAlbum()))&&
                        (SearchFile.getListTracks().get(i).getSongName().equals(SearchFile.getListTracks().get(j).getSongName()))){
                    listDuplicateSongs.add(SearchFile.getListTracks().get(j));
                    listDuplicateSongs.add(SearchFile.getListTracks().get(i));
                }
            }
        }

    }

    public void duplicateSongsToLog(){

        final Logger logfile3 = Logger.getLogger("log2");

        for(int i = 0; i < listDuplicateSongs.size()-1; i++) {
            for (int j = i + 1; j < listDuplicateSongs.size(); j++) {
                if((listDuplicateSongs.get(i).getArtist().equals(listDuplicateSongs.get(j).getArtist()))
                        &&(listDuplicateSongs.get(i).getAlbum().equals(listDuplicateSongs.get(j).getAlbum()))
                        &&(listDuplicateSongs.get(i).getSongName().equals(listDuplicateSongs.get(j).getSongName()))){

                    logfile3.info("Артист: <b>"+ listDuplicateSongs.get(i).getArtist() +"</b> Альбом: <b>"
                            + listDuplicateSongs.get(i).getAlbum() +"</b> Название: <b>"
                            + listDuplicateSongs.get(i).getSongName() +"</b><br>");
                    logfile3.info(listDuplicateSongs.get(i).getPath()+"<br>");
                    logfile3.info(listDuplicateSongs.get(j).getPath()+"<br><br>");

                }
            }
        }
    }

    public List<String> getListDuplicateSumm() {
        return listDuplicateSumm;
    }

    public void setListDuplicateSumm(List<String> listDuplicateSumm) {
        this.listDuplicateSumm = listDuplicateSumm;
    }

    public List<Track> getListTracks() {
        return listTracks;
    }

    public void setListTracks(List<Track> listTracks) {
        this.listTracks = listTracks;
    }

    public List<Track> getListDuplicateSongs() {
        return listDuplicateSongs;
    }

    public void setListDuplicateSongs(List<Track> listDuplicateSongs) {
        this.listDuplicateSongs = listDuplicateSongs;
    }

}