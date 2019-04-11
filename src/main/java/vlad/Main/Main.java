package vlad.Main;


import vlad.Mp3File.Song;
import vlad.Searchs.SearchFile;
import vlad.Searchs.SearchDuplicate;
import vlad.Sorting.Sorting;

public class Main {

    public static void main(String[] args) {

        SearchFile search = new SearchFile();
        search.searchMuz("D:\\MuzFolder");
        search.openMuzFile();
        search.createTrack();

        Sorting sorting = new Sorting();
        Song song = sorting.sortSong(SearchFile.getListTracks());
        sorting.toHtml(song);

        SearchDuplicate searchDuplicate = new SearchDuplicate();

        searchDuplicate.groupDuplicateSumm();
        searchDuplicate.duplicateSummToLog(song.getListArtist());

        searchDuplicate.groupDuplicateSongs();
        searchDuplicate.duplicateSongsToLog();

    }
}