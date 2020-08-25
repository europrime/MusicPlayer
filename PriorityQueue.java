import java.io.Serializable;

/**
 * 
 *  Stefano Iaconetti
 *  110023563
 *
 */
public class PriorityQueue implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Variables
	int front = 0;
	int rear = 0;
	int size = 0;
	int capacity = 30;
	String albumName;
	PriorityObject[] queueArray;
	
	//Constructor
	public PriorityQueue(String albumName) {
		this.albumName = albumName;
		queueArray = new PriorityObject[30];
	}
	
	
	//Inserts variable at the end of the queue
	public void enqueue(Song song, int priority) {
		priority++;
		PriorityObject tempData = new PriorityObject(priority, song);
		
		if(priority == 0) {
			tempData.priority = 10;
		}
		
		//If the queue is full then return
		if(isFull()) {
			return;
		}else {
			//If the rear is 0 then just increase size and input variable into queue
			if(rear == 0) {
				size++;
				
				queueArray[rear] = tempData;
				rear++;
				
				//Otherwise increase rear aswell
			}else {
				queueArray[rear] = tempData;
				rear++;
				size++;
			}
		}
	}
	
	//Selection sort
	public void SelectionSort(int sortBy) {
		
		switch(sortBy) {
		case 1:
			SortByPriority();
			break;
		case 2:
			SortByLength();
			break;
		case 3:
			SortByPlayed();
			break;
			
			default:
				System.out.println("Please enter a valid input");
				break;
		}
		
	}
	
	
	
	public void SortByPriority() {
		 int n = 30;
	        for (int i = 0; i < n-1; i++)
	            for (int j = 0; j < n-i-1; j++)
	                if (queueArray[j] != null && queueArray[j + 1] != null && queueArray[j].priority < queueArray[j+1].priority)
	                {
	                    // swap temp and arr[i]
	                	PriorityObject temp = queueArray[j];
	                    queueArray[j] = queueArray[j+1];
	                    queueArray[j+1] = temp;
	                    System.out.println("Workin");
	                }
	}
	
	public void SortByPlayed() {
		
		int n = 30;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (queueArray[j] != null && queueArray[j + 1] != null && queueArray[j].song.timesPlayed < queueArray[j+1].song.timesPlayed)
                {
                    // swap temp and arr[i]
                	PriorityObject temp = queueArray[j];
                    queueArray[j] = queueArray[j+1];
                    queueArray[j+1] = temp;
                    System.out.println("Workin");
                }
	}
	
	public void SortByLength() {
		int n = 30;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (queueArray[j] != null && queueArray[j + 1] != null && queueArray[j].song.songLength < queueArray[j+1].song.songLength)
                {
                    // swap temp and arr[i]
                	PriorityObject temp = queueArray[j];
                    queueArray[j] = queueArray[j+1];
                    queueArray[j+1] = temp;
                    System.out.println("Workin");
                }
	}
	
	public void Delete(String song) {
		PriorityObject[] tempArray = new PriorityObject[capacity];
		int p = 1;
		
		
		for(int i = 0; i < 30; i++) {
			if(queueArray[i] != null && song.equals(queueArray[i].song.name)) {
				queueArray[i] = null;
			}else if(queueArray[i] != null) {
				PriorityObject tempObject = new PriorityObject(p, queueArray[i].song);
				tempArray[i] = tempObject;
				p++;
			}
		}
		
		queueArray = new PriorityObject[30];

		int pos = 0;
		
		for(int i = 0; i < 30; i++) {
			if(tempArray[i] != null) {
				queueArray[pos] = tempArray[i];
				pos++;
			}
		}
		
		front = 0;
		size = p;
		
	}
	
	//Dequeue
	public Song dequeue() {
		//If the list is empty then return an empty string
		if(isEmpty()) {
			return null;
			//Otherwise return the front after increasing
		}else {
			front++;
			size--;
			return queueArray[front - 1].song;
		}
	}
	
	//Peek
	public PriorityObject peek() {
		return queueArray[front];
	}
	
	//Returns the size of the array
	public int getSize() {
		return size;
	}
	
	//Is Empty
	public boolean isEmpty() { 
	//If the front and the rear are the same then it is empty
		if(front == rear) {
			return true;
		}else {
			return false;
		}
	}
	
	//Is Full
	public boolean isFull() {
		//If the size and the capacity are the same then we cannot add anymore variables
		if(size == capacity) {
			System.out.println("The queue is full");
			return true;
		}else {
			return false;
		}
	}
	
	//Display
	public void display() {
		//Loops through and displays only the valid data
		for(int i = front; i < capacity; i++) {
			if(queueArray[i] != null) {
				System.out.println("Priority: " + queueArray[i].priority + " Data: " + queueArray[i].song.name);
			}
		}
	}
}
