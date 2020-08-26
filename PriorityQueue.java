import java.io.Serializable;

//Priority queue data structure
public class PriorityQueue implements Serializable {
	
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
	
	
	//Song is inserted at the end of the queue
	public void enqueue(Song song, int priority) {
		priority++;
		PriorityObject tempData = new PriorityObject(priority, song);
		
		if(priority == 0) {
			tempData.priority = 10;
		}
		
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
	public void BubbleSort(int sortBy) {
		//Depending how the user wants to sort
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
	
	
	//Sorts by the songs priority on the queue
	public void SortByPriority() {
		//Nested for loop
		for (int i = 0; i < 30 - 1; i++) {
			for (int j = 0; j < 30 - i - 1; j++) {
				//If the objects exists and one is more than the other then they switch
				if (queueArray[j] != null && queueArray[j + 1] != null && queueArray[j].priority < queueArray[j+1].priority){
					PriorityObject temp = queueArray[j];
	                queueArray[j] = queueArray[j+1];
	                queueArray[j + 1] = temp;
	                System.out.println("Workin");
				}
			}
		}
	}
	
	//Sorts by how many times the song was listened to
	public void SortByPlayed() {
		//Nested for loop
        for (int i = 0; i < 30 - 1; i++) {
            for (int j = 0; j < 30 - i - 1; j++) {
            	//If the objects exists and one is more than the other then they switch
                if (queueArray[j] != null && queueArray[j + 1] != null && queueArray[j].song.timesPlayed < queueArray[j+1].song.timesPlayed){
                	PriorityObject temp = queueArray[j];
                    queueArray[j] = queueArray[j + 1];
                    queueArray[j + 1] = temp;
                    System.out.println("Workin");
                }
            }
        }
	}
	
	//Sorts by the length of the song
	public void SortByLength() {
		//Nested for loop
        for (int i = 0; i < 30 - 1; i++) {
            for (int j = 0; j < 30 - i - 1; j++) {
            	//If the objects exists and one is more than the other then they switch
                if (queueArray[j] != null && queueArray[j + 1] != null && queueArray[j].song.songLength < queueArray[j+1].song.songLength){
                	PriorityObject temp = queueArray[j];
                    queueArray[j] = queueArray[j+ 1];
                    queueArray[j + 1] = temp;
                    System.out.println("Workin");
                }
            }
        }
	}
	
	//Delete method deletes the song the user wanted to delete
	public void Delete(String song) {
		//Creating a temp array
		PriorityObject[] tempArray = new PriorityObject[capacity];
		int p = 1;
		
		//Loops through the list and adds the songs that do not equal what the user wants to remove to the temp array
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
		
		//Songs are now adding to a new array
		for(int i = 0; i < 30; i++) {
			if(tempArray[i] != null) {
				queueArray[pos] = tempArray[i];
				pos++;
			}
		}
		
		front = 0;
		size = p;
		
	}
	
	
	//Method to dequeue the entire album
	public void DequeueAll() {
		for(int i = 0; i < 30; i++) {
			dequeue();
			System.out.println("Worked");
		}
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
			return queueArray[front].song;
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
