import java.io.Serializable;

public class Song  implements Serializable {

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
    
    //Prints the song information
    public void getSong(){
        System.out.println("Song: " + name + "\n" + "Aritist: " + artist + "\n" + "Genre: " + genre + "\n" + "Song Length: " + songLength + "\n" + "Times Played: " + timesPlayed + "\n" + "Lyric: " + lyric);
    }
    
    //Plays the lyric of the current song
    public void playSong() {
    	System.out.println("\""+ lyric + "\"\n");
    	timesPlayed++;
    }
    
}