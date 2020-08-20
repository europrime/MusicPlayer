/**
 * 
 *  Stefano Iaconetti
 *  110023563
 *
 */
public class PriorityQueue {
	
	//Variables
	int front = 0;
	int rear = 0;
	int size = 0;
	int prority = 0;
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
	public void SelectionSort() {
		//Loops through the queue
		for(int i = 0; i < size - 1; i++) {
			//Creating a min that is equal to i
			int min = i;
			
			//J is always 1 ahead of i
			for (int j = i + 1; j < size; j++) {
				//If the data[i] is less than the data[min] then swap 
				if(queueArray[i].priority < queueArray[min].priority) {
					min = j;
				}
				
				//Swapping
				PriorityObject tempData = queueArray[i];
				PriorityObject tempDataMin = queueArray[min];
				
				queueArray[i] = tempDataMin;
				queueArray[min] = tempData;
				
			}
		}
		
		
		//Loops through changing priorities
		 for (int i = front; i < rear; i++) {  
			 queueArray[i].priority = i;
	     } 
	}
	
	public void Delete(String song) {
		PriorityObject[] tempArray = new PriorityObject[capacity];
		int p = 0;

		for(int i = front; i < size; i++) {
			if(!song.contains(peek().song.name)) {
				PriorityObject tempObject = new PriorityObject(1, peek().song);
				tempArray[p] = tempObject;
				p++;
				dequeue();
			}else {
				dequeue();
			}
		}
		
		this.queueArray = tempArray;
		
	}
	
	
	//Dequeue
	public Song dequeue() {
		//If the list is empty then return an empty string
		if(isEmpty()) {
			return null;
			
			//Otherwise return the front and remove the front and change it to front + 1
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
