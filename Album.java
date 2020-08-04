public class Album{

    PriorityQueue newAlbum = new PriorityQueue(30);
    int size;

    public Album(Song song1){
        newAlbum.enqueue(song1, 1);
    }

    public void addSong(Song song1){
        newAlbum.enqueue(song1, 1);
    }

    public void removeSong(Song song1){
        newAlbum.Delete(song1);
    }

    public void getAlbum(){
       newAlbum.display(); 
    }
}