public class Song{

	//Characteristics of a song
    String name;
    String artist;
    String genre;
    double songLength;
    int timesPlayed = 0;

    //Constructor
    public Song(String name, String artist,String genre, double songLength){
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.songLength = songLength;
    }

    //Getters and setters
    public String getName(){
        return name;
    }

    public String getArtist(){
        return artist;
    }
    
    public String getGenre(){
        return genre;
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