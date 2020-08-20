import java.util.Scanner; 
public class MusicPlayer{
    public static void main(String[] args){
        //Create scanner
        Scanner input = new Scanner(System.in);
        
        //List of albums
        PriorityQueue[] albumList = new PriorityQueue[30];
        
        //Will always know the amount of albums
        int currentAlbums = 0;
        

        System.out.println("Welcome to our music Player!\n");

        //Loop
        while(true){
        	//Asking user to enter input
            System.out.println("Please select an option: \n");
            System.out.println("1. Create an album\n2. Enter a ablum\n3. Display Albums\n4. Show Statistics\n5. Exit");
            int userInput = input.nextInt();
            input.nextLine();
            
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
                	//Asks the user what album they would like to enter
                	System.out.println("What album would you like to enter?");
                	int albumInt = input.nextInt();
                	input.nextLine();
                	
                	//Enters the user into the album
                	AlbumEnter(albumList, albumInt);
                case 3:
                	//Displays all the current albums
                    DisplayAlbums(albumList);
				case 4:
					//Ask the user what statistic they would like to enter
					System.out.print("What statistics would you like?");
					int statInt = input.nextInt();
					input.nextLine();

					//Displays statistics to user
					Statistics(albumList, statInt);
                case 5:
                	break;
                default: 
                    continue;
            }

            if(userInput==8){
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
    	System.out.println("\n1.Add a Song\n2. Remove a song\n3. Play music\n4. Sort\n5.Go back");
    	int userInput = input.nextInt();
        input.nextLine();
        
        //Allowing the user to continue adding, deleting or sorting
        while(true) {
	        switch(userInput) {
	        case 1:
	        	AddSong(albumList, entry);
	        	break;
	        }
        }
    	
    }
    
    //Displays all the songs in the current album
    public static void DisplaySongs(PriorityQueue[] albumList, int entry) {
    	System.out.println("Current Albums: ");
    	//Loops through the songs of the array in the priority queue
    	for(int i = 0; i < 30; i++) {
    		if(albumList[entry].queueArray[i] != null) {
    			System.out.println(i + ". " + albumList[entry].queueArray[i].song.name);
    		}
    	}
    }
    
    //Displays all the albums
    public static void DisplayAlbums(PriorityQueue[] albumList) {
    	System.out.println("Current Albums: ");
    	//Loops through the array of albums and displays their names
    	for(int i = 0; i < 30; i++) {
    		if(albumList[i] != null) {
    			System.out.println(i + ". " + albumList[i].albumName);
    		}
    	}
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
    	double length = input.nextDouble();
    	input.nextLine();
    	
    	//Adding song into priority queue
    	Song song = new Song(songName, artist, genre, length);
    	albumList[entry].enqueue(song, albumList[entry].prority);
    	AlbumEnter(albumList, entry);
    	
	}
	
	public static void Statistics(PriorityQueue[] albumList, int entry){
		//Scanner
		Scanner input = new Scanner(System.in);
		
		//User options
		System.out.println("\n1. Most played song\n2. Most played genre\n3. Total album length\n4. Go back");

		int userInput = input.nextInt();
        input.nextLine();
        
        //Stat functions
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
			default:
				continue;
			}
        }
	}

	public static void MostPlayedSong(PriorityQueue[] albumList, int entry){
		int max = 0;
		Song mostPlayed = null;
		//displays most played song/s in album using total times played
		System.out.println("Most played song: ");

		//finds most played song or lists multiple if tie
		for(int i = 0; i < 30; i++) {
			albumList[entry].queueArray[i].song.timesPlayed = max;
			albumList[entry].queueArray[i].song = mostPlayed;

    		if(albumList[entry].queueArray[i] != null) {

				//System.out.println(i + ". " + albumList[entry].queueArray[i].song.name);

				if (albumList[entry].queueArray[i].song.timesPlayed > max){

					albumList[entry].queueArray[i].song.timesPlayed = max;
					albumList[entry].queueArray[i].song = mostPlayed;
				}
    		}
		}
		
		System.out.println(mostPlayed);
	}

	public static void MostPlayedGenre(PriorityQueue[] albumList, int entry){
		int max = 0;
		String mostPlayed = "";

		//displays most played genre in album from most played song/s and finds most popular genre
		System.out.println("Most played genre: ");

		for(int i = 0; i < 30; i++) {
			albumList[entry].queueArray[i].song.timesPlayed = max;
			albumList[entry].queueArray[i].song.genre = mostPlayed;

    		if(albumList[entry].queueArray[i] != null) {

				//System.out.println(i + ". " + albumList[entry].queueArray[i].song.name);

				if (albumList[entry].queueArray[i].song.timesPlayed > max){

					albumList[entry].queueArray[i].song.timesPlayed = max;
					albumList[entry].queueArray[i].song.genre = mostPlayed;
				}
    		}
		}
		
		System.out.println(mostPlayed);
	}

	public static void TotalAlbumLength(PriorityQueue[] albumList, int entry){
		int totalLength = 0;

		//displays total album length by adding total song length
		System.out.println("Total album length: ");

		//adds total song length and displays

		for(int i = 0; i < 30; i++) {
    		if(albumList[entry].queueArray[i] != null) {
				totalLength+=albumList[entry].queueArray[i].song.songLength;
    		}
		}
		
		System.out.println(totalLength);
	}
}