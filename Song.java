public class Song{

    String name;
    String artist;
    Double songLength;

    public Song(String n, String a, Double l){
        name = n;
        artist = a;
        songLength = l;
    }

    public String getName(){
        return name;
    }

    public String getArtist(){
        return artist;
    }

    public String getSong(Song song1){
        return "Song: " + song1.getName() + "\n" + "Aritist: " + song1.getArtist() + "\n";
    }
    
}