import java.io.Serializable;

public class Song  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Characteristics of a song
    String name = "";
    String artist= "";
    String genre = "";
    double songLength = 0;
    int timesPlayed = 0;
    String lyric = "";

    //Constructor
    public Song(String name, String artist,String genre, double songLength, String lyric){
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.songLength = songLength;
        this.lyric = lyric;
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
    
    public void getSong(){
        System.out.println("Song: " + name + "\n" + "Aritist: " + artist + "\n" + "Genre: " + genre + "\n" + "Song Length: " + songLength + "\n" + "Times Played: " + timesPlayed + "\n" + "Lyric: " + lyric);
    }
    
    public void playSong() {
    	System.out.println("\""+ lyric + "\"\n");
    	timesPlayed++;
    }
    
}