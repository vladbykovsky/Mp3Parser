package vlad.Track;

public class Track {

    private String artist;
    private String album;
    private String songName;
    private long duration;
    private String path;
    private String contrSumm;


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getPath() { return path; }

    public void setPath(String path) { this.path = path; }

    public String getContrSumm() { return contrSumm; }

    public void setContrSumm(String contrSumm) { this.contrSumm = contrSumm; }

}
