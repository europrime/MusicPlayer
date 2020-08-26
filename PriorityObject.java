import java.io.Serializable;

//Object that holds the song and priority
public class PriorityObject implements Serializable {

	private static final long serialVersionUID = 1L;
	int priority;
	Song song;
	
	//Constructor
	public PriorityObject(int priority, Song song) {
		this.priority = priority;
		this.song = song;
	}
}
