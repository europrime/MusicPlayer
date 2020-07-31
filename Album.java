import java.util.ArrayList;

public class Album{

    ArrayList<Song> newAlbum = new ArrayList<>();
    int size;

    public Album(Song song1){
        newAlbum.add(song1);
    }

    public void addSong(Song song1){
        newAlbum.add(song1);
    }

    public void removeSong(Song song1){
        newAlbum.remove(song1);
    }

    public void getAlbum(){
        for(int i = 0; i < newAlbum.size(); i++) {   
            Song song1 = newAlbum.get(i);
            System.out.println(song1.getSong(song1));
        }  
    }
}