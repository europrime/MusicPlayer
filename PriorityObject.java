import java.io.Serializable;

public class PriorityObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int priority;
	Song song;
	
	public PriorityObject(int priority, Song song) {
		this.priority = priority;
		this.song = song;
	}
}
