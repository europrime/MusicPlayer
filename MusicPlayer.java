import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner; 
public class MusicPlayer{
	
	//Holds the amount of albums
	public static int currentAlbums = 0;
	
	//Main method
    public static void main(String[] args){

        //List of albums
        PriorityQueue[] albumList = new PriorityQueue[30];
        //Calls the method that starts the program
       MainEnter(albumList);
    }
    
    
    public static void MainEnter(PriorityQueue[] albumList) {
    	 //Create scanner
        Scanner input = new Scanner(System.in);
        
        //Welcomes user
        System.out.println("Welcome to our music Player!\n");
        int userInput = 0;
        
        //Loop
        while(userInput != 8){
        	//Asking user to enter input
            System.out.println("Please select an option: \n");
            System.out.println("1. Create an album\n2. Enter a album\n3. Display Albums \n4. Show Statistics \n5. Remove Album \n6. Save \n7. Load  \n8. Exit");
           
            //Input it checked incase they entered a letter 
            userInput = CheckInt(input.nextLine());
            
            //Switch case on the users input
            switch(userInput){
                case 1:
                	//Create album by asking user for a album name
                	System.out.println("Please enter the name of the album");
                	String albumName = input.nextLine();

                	PriorityQueue newAlbum = new PriorityQueue(albumName);
                	
                	albumList[currentAlbums] = newAlbum;
                	currentAlbums++;
                	
                	break;
                case 2:
                	int albumInt = 0;
                	//Asks the user what album they would like to enter
                	System.out.println("What album would you like to enter?");

                	albumInt = CheckInt(input.nextLine());
                	
                	//Incase the user enters the wrong album
                	if(albumInt - 1 < 0 || albumInt > 30 || albumList[albumInt - 1] == null) {
                		System.out.println("Sorry! Album " + albumInt + " does not exist\n");
                	}else {
	                	//Enters the user into the album
	                	AlbumEnter(albumList, albumInt - 1);
                	}
                	break;
                case 3:
                	//Displays all the current albums
                    DisplayAlbums(albumList);
                    break;
				case 4:
					//Ask the user what statistic they would like to enter
					System.out.print("What album would you like a statistic for?");
					int statInt = CheckInt(input.nextLine());

					if((statInt - 1 < 0 || statInt > 30 || albumList[statInt - 1] == null)) {

                		System.out.println("Sorry! Album " + statInt + " does not exist\n");
					}else {
						//Displays statistics to user
						Statistics(albumList, statInt -1);
					}
                    break;
                case 5:
                	//Asks user which album to remove
                	System.out.println("What album would you like to remove?");

                	albumInt = CheckInt(input.nextLine());
                	
                	//Incase the user enters the wrong album
                	if(albumList[albumInt] == null) {
                		System.out.println("Sorry! Album " + albumInt + " does not exist\n");
                	}else {
	                	albumList[albumInt] = null;
                	}
         
                	break;
                	
                case 6:
                	//Albums are saved
                	Save(albumList);
                	break;
                	
                case 7:
                	//Albums are loaded
                	albumList = Load(albumList);
                	break;
                	
                case 8:
                	//Application closes 
                		System.out.println("Have a good day!");
                	break;
                default: 
                	//If they enter any other number then an error message is shown
                	System.out.println("Sorry you have entered an invalid number");
                   break;
            }
        
        }
    }
    
    //Enters the user into the album of their choosing
    public static void AlbumEnter(PriorityQueue[] albumList, int entry) {
    	//Scanner
    	Scanner input = new Scanner(System.in);
    	
    	//Shows the list of the songs in that album
    	DisplaySongs(albumList, entry);
    	
    	//Giving the user options
    	System.out.println("\n1. Add a Song\n2. Remove a song\n3. Play music \n4. Song Information \n5. Sort\n6. Go back");
    	int userInput = 0;
    	userInput = CheckInt(input.nextLine());
    	boolean loopEnd = true;
        
    	
        //Allowing the user to continue adding, deleting or sorting
        do{ 
	        switch(userInput) {
	        case 1:
	        	//Calls the add song method
	        	AddSong(albumList, entry);
	        break;
	        
	        case 2:
	        	//sks user what song they want to delete 
	        	System.out.println("Enter the name of the song to delete");
	        	String songDelete = input.nextLine();
	        	
	        	//Calls delete song method
	        	DeleteSong(albumList, entry, songDelete);
	        	
	        	break;
	        	
	        case 3:
	        	//Calls the play song method
	        	PlaySong(albumList, entry);
	        break;
	        
	        case 4:
	        	//Asks the user which song they want
	        	System.out.println("Which song would you like information on?");
	        	String songInfo = input.nextLine();
	        	
	        	//Calls display info method
	        	DisplayInfo(albumList, entry, songInfo);

	        	//Recalls the current method
	        	AlbumEnter(albumList, entry);
	        	break;
	        	
	        case 5:
	        	//Asks the user what would they like the songs to be sorted by
	        	System.out.println("\n1. Sort by Priority \n2. Sort by length \n3. Times played");
	        	int sort = 0;
	        	sort = CheckInt(input.nextLine());
	        	
	        	//Sorts the album
	        	albumList[entry].BubbleSort(sort);
	        	AlbumEnter(albumList, entry);
	        	
	        	break;
	        
	        case 6: 
	        	//Allows the user to back to the previous page
	        	MainEnter(albumList);
	        break;
	   
	        	default:
	        		//Error message if their number is invalid and recalls the current method
	        		System.out.println("Sorry you entered an invalid number");
	        		AlbumEnter(albumList, entry);
	        	break;
	        		
	        		
	        }
        } while(loopEnd == true);
    	
    }
    
    //Method displays the info of the song
    public static void DisplayInfo(PriorityQueue[] albumList, int entry, String infoName) {
    	//Loops until it finds a song math and displays its information
    	for(int i = 0; i < 30; i++) {
    		if(albumList[entry].queueArray[i] != null && albumList[entry].queueArray[i].song.name.equals(infoName)) {
    			albumList[entry].queueArray[i].song.getSong();
    		}
    	}
    }
    
    //Displays all the songs in the current album
    public static void DisplaySongs(PriorityQueue[] albumList, int entry) {
    	//Loops through the songs of the array in the priority queue
    	System.out.println("Album: " + albumList[entry].albumName + "\n");
    	System.out.println("Current Songs: ");
    	
    	System.out.println("\nRating	Name");
    	//Loops through the songs of the array in the priority queue
    	int p = 1;
    	for(int i = 0; i < 30; i++) {
    		if(albumList[entry].queueArray[i] != null) {
    			System.out.println(albumList[entry].queueArray[i].priority + "	" + albumList[entry].queueArray[i].song.name);
    		}
    	}
    }
    
    //Displays all the albums
    public static void DisplayAlbums(PriorityQueue[] albumList) {
    	System.out.println("Current Albums: ");
    	//Loops through the array of albums and displays their names
    	int p = 1;
    	for(int i = 0; i < 30; i++) {
    		if(albumList[i] != null) {
    			System.out.println(p + ". " + albumList[i].albumName);
    			p++;
    		}
    	}
    }
    
    
  //Allows user to add songs
    public static void DeleteSong(PriorityQueue[] albumList, int entry, String song) {
    	albumList[entry].Delete(song);
    	AlbumEnter(albumList, entry);
    }
    
    //Allows user to add songs
    public static void AddSong(PriorityQueue[] albumList, int entry) {
    	//SCanner
    	Scanner input = new Scanner(System.in);
    	
    	//Asking for details of each song for the user to input
    	System.out.println("Please enter the song name");
    	String songName = input.nextLine();
    	
    	System.out.println("Please enter the artist");
    	String artist = input.nextLine();
    	
    	System.out.println("Please enter the genre");
    	String genre = input.nextLine();
    	
    	System.out.println("Please enter the length of the song");
    	double length = 0;
    	length = CheckDouble(input.nextLine());
    	
    	System.out.println("Enter a lyric for the song");
    	String lyric = input.nextLine();
    	
    	System.out.println("How would you rate this song?");
    	int priority = 0;
    	
    	priority = CheckInt(input.nextLine());
    	if(length != 0) {
        	//Adding song into priority queue
        	Song song = new Song(songName, artist, genre, length, lyric);
        	albumList[entry].enqueue(song, priority);
        	AlbumEnter(albumList, entry);
    	}else {
    		System.out.println("Please enter a valid song length");
    		AlbumEnter(albumList, entry);
    	}
    }
	
	
	public static void Statistics(PriorityQueue[] albumList, int entry){
		//Scanner
		Scanner input = new Scanner(System.in);
		
		//User options
		System.out.println("\nAlbum Statistics\n1. Most played song\n2. Most played genre\n3. Total album length\n4. Go back");
		int userInput = CheckInt(input.nextLine());
        
        //Stat functions depending on which statistic the user would like to know
        while(true) {
	        switch(userInput) {
	        case 1:
	        	MostPlayedSong(albumList, entry);
				break;
			case 2:
				MostPlayedGenre(albumList, entry);
				break;
			case 3:
				TotalAlbumLength(albumList, entry);
				break;
				
			case 4:
				MainEnter(albumList);
				break;
			default:
				System.out.println("Sorry you entered an invalid number");
				break;
			}
        }
	}

	//Prompts the user the most played song of the specified playlist
	public static void MostPlayedSong(PriorityQueue[] albumList, int entry){
		int max = 0;
		Song mostPlayed = null;
		//displays most played song/s in album using total times played
		System.out.println("Most played song: ");
		
		//finds most played song or lists multiple if tie
		for(int i = 0; i < 30; i++) {
			if(albumList[entry].queueArray[i] != null) {
				 if(albumList[entry].queueArray[i].song.timesPlayed > max){
					max = albumList[entry].queueArray[i].song.timesPlayed;
					mostPlayed = albumList[entry].queueArray[i].song;
					
				 }
				}
    		}
		System.out.println(mostPlayed.name);
		
		Statistics(albumList, entry);
	}

	//Prompts the user the most played genre of the specified playlist
	public static void MostPlayedGenre(PriorityQueue[] albumList, int entry){
		int max = 0;
		String mostPlayed = "";

		//displays most played genre in album from most played song/s and finds most popular genre
		System.out.println("Most played genre: ");

		for(int i = 0; i < 30; i++) {
    		if(albumList[entry].queueArray[i] != null) {
				if (albumList[entry].queueArray[i].song.timesPlayed > max){
					max = albumList[entry].queueArray[i].song.timesPlayed; 
					mostPlayed = albumList[entry].queueArray[i].song.genre;
				}
    		}
		}
		System.out.println(mostPlayed);
		

		Statistics(albumList, entry);
	}

	//Prompts the user length of the album
	public static void TotalAlbumLength(PriorityQueue[] albumList, int entry){
		int totalLength = 0;

		//displays total album length by adding total song length
		System.out.println("Amount of songs in album: ");

		//adds total song length and displays

		for(int i = 0; i < 30; i++) {
    		if(albumList[entry].queueArray[i] != null) {
				totalLength++;
    		}
		}
		
		System.out.println(totalLength);
		

		Statistics(albumList, entry);
	}
    
    
	//Method to check if the current number is a double
    public static double CheckDouble(String parseDouble) {
    	double inputAnswer;
	    	try {
	    		inputAnswer = Double.parseDouble(parseDouble);
	    		return inputAnswer;
	       	}catch(Exception e) {
	       		System.out.println("Invalid number\n");
	       	}
    	return 0;
    }
    
  //Method to check if the current number is a int
    public static int CheckInt(String parseInt) {
    	int inputAnswer;
	    	try {
	    		inputAnswer = Integer.parseInt(parseInt);
	    		return inputAnswer;
	       	}catch(Exception e) {
	       		System.out.println("Invalid number\n");
	       	}
    	return 0;
    }
    
    //Method to save the albums
    public static void Save(PriorityQueue[] albumList) {
    	//Try catch
    	try {
    		//Outputstream is made with albumList.ser to make it serilizable
    		FileOutputStream fileOut = new FileOutputStream("albumList.ser");
    		//ObjectOutputStream is made with the fileOut
    	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	    //Album is written onto the file
    	    out.writeObject(albumList);
    	    //Flush the outputstrem
    	    out.flush();
    	    //Close the output stream
    	    out.close();
    	    System.out.println("Saved!");
    	}catch(Exception e) {
    		System.out.println("Unable to save");
    	}
    }
    
    
    //Loads the albums the user has saved
    public static PriorityQueue[] Load(PriorityQueue[] albumList) {
    	try {
    		//FileInput with the same name as the output
    		FileInputStream fileInput = new FileInputStream("albumList.ser");
    		//ObjectInputStream with the fileinput
            ObjectInputStream in = new ObjectInputStream(fileInput);
            //The current albumList array is now whatever was saved
            albumList = (PriorityQueue[])in.readObject();
            //Close the inputstream
            in.close();
            System.out.println("Loaded!");
    	}catch(Exception e) {
    		System.out.println("Unable to load");
    	}
    	return albumList;
    }
    
    //Plays whatever song the user asks
    public static void PlaySong(PriorityQueue[] albumList, int entry) {
    	//Scanner
    	Scanner input = new Scanner(System.in);
    	
    	//Asks user what song to play
    	System.out.println("Which song would you like to play?");
    	int userInput = 0;
    	userInput = CheckInt(input.nextLine());
    	
    	//As longs as the values exists the song is played
    	if(!(userInput - 1 < 0) || !(userInput > 30) || albumList[entry].queueArray[userInput - 1] != null) {
    		albumList[entry].queueArray[userInput - 1].song.playSong();
    	}else {
    		System.out.println("Sorry that song doesn't exist");
    	}
    	
    	//Re enter the album
    	AlbumEnter(albumList, entry);
    }
}