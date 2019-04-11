package vlad.Mp3File;

public class SongName {

    private String songName;
    private long duration;
    private String path;
    private String contrSumm;

    public SongName(String songName, long duration, String path, String contrSumm){
        this.songName = songName;
        this.duration = duration;
        this.path = path;
        this.contrSumm = contrSumm;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContrSumm() {
        return contrSumm;
    }

    public void setContrSumm(String contrSumm) {
        this.contrSumm = contrSumm;
    }
}
