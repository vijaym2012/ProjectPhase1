package Project;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WelcomeScreen implements Screen {

    private String Welcome = "********Welcome to LockedMe.com********";
    private String Developer = "*****Developer Name is Vijay Mahar*****";
    private String Location = "***********Location is India***********";

    private ArrayList<String> options = new ArrayList<>();
	private Scanner in;


    public WelcomeScreen() {
        options.add("1. List of Files in Directory");
        options.add("2. Show File Options");
        options.add("3. Exit Programme");

    }
    
    public void introWS() {
    	System.out.println(Welcome);
        System.out.println(Developer);
        System.out.println(Location);
        System.out.println("\n");
        Show();
    }
    
    public void Show() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles(); 
                
                this.Show();
                
                break;
                
            case 2: // Show File Options
            	ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void ShowFiles() {

        //TODO: Get the Files from the Directory

        System.out.println("List of the Files: ");
    	DirectoryService.PrintFiles();

    }
    
    private int getOption() {
        in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
}
