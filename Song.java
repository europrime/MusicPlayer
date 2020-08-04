public class Song{

    String name;
    String artist;
    double songLength;
    int timesPlayed = 0;

    public Song(String name, String artist, double songLength){
        this.name = name;
        this.artist = artist;
        this.songLength = songLength;
    }

    public String getName(){
        return name;
    }

    public String getArtist(){
        return artist;
    }
    
    public int getTimePlayed(){
        return timesPlayed;
    }

    public void TimePlayedIncrease() {
    	timesPlayed++;
    }
    
    public String getSong(Song song1){
        return "Song: " + song1.getName() + "\n" + "Aritist: " + song1.getArtist() + "\n";
    }
    
}