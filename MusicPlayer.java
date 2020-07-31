import java.util.Scanner; 
public class MusicPlayer{
    public static void main(String[] args){
        //test
        Song song1 = new Song("bad guy", "Billie Eillish", 3.14);
        Album album1 = new Album(song1);

        //create scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to our music Player!\n");

        while(true){
            System.out.println("Please select an option: \n");
            System.out.println("1. Add music\n2. Remove music\n3. Play music\n4. Display music\n5. Show Statistics\n6. Simulate music\n7. Sort music\n 8. Exit");
            int userInput = input.nextInt();

            switch(userInput){
                case 1:
                //add
                case 2:
                //remove
                case 3:
                //play
                case 4:
                //display
                case 5:
                //stats
                case 6:
                //simulation
                case 7:
                    break;
                default: 
                    continue;
            }

            if(userInput==8){
                break;
            }
        
        }

        System.out.println("TEST: ");
        //add item
        Song song2 = new Song("xanny", "Billie Eillish", 4.04);
        album1.addSong(song2);

        //prints out song
        System.out.println(song1.getSong(song1));

        //prints out album
        System.out.println("Album 1: \n");
        album1.getAlbum();
    }
}