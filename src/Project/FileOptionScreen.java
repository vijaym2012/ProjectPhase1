package Project;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileOptionScreen implements Screen {
	
	private Directory dir = new Directory();
	
	private ArrayList<String> options = new ArrayList<>();

	private Scanner scanner;

    public FileOptionScreen() {
    	
    	options.add("1. Add New File");
        options.add("2. Delete File");
        options.add("3. Search File");
        options.add("4. Return to Main Menu");
        
    }
    
    @Override
    public void Show() {
    	System.out.println("File Options");
        for (String s : options) {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        
    	switch(option) {

            case 1: // Add File
                this.AddFile();
                
                this.Show();
                break;
                
            case 2: // Delete File
                this.DeleteFile();
                
                this.Show();
                break;
                
            case 3: // Search File
                this.SearchFile();
                this.Show();
                break;
                
            
                
            case 4: // Return to Menu         	
            	ScreenService.setCurrentScreen(ScreenService.WelcomeScreen);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
                
                
        }

    }
    
   public void AddFile() {
        System.out.println("Please Enter the File name:");

        String fileName = this.getInputString();

        System.out.println("File Name: " + fileName);
        
		try {
			FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
			File file = new File(dir.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File Created Sucessfully !: " + file.getName());
		    	  dir.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("This File is Already Exits");
		      }
		}catch (IOException e){
			System.out.println(e);
			}
		}
        
   public void DeleteFile() {
    	
    	System.out.println("Please Enter the File Name: ");

        String fileName = this.getInputString();

        System.out.println("Deleted File Name: " + fileName);
        
        
	    //TODO: Delete file
        // Finished TODO
        
		Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());
	    	  dir.getFiles().remove(file);
	      } else {
	        System.out.println("Cannot Delete File: " + fileName + ", File not Found !");
	      }
   }
    
    
   public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("Please Enter the Filename: ");

        String fileName = this.getInputString();

        System.out.println("Searched File Name: " + fileName);
        
     
        ArrayList<File> files = dir.getFiles();
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("File Found " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("File Not Found !");
       }
   }
    
   private String getInputString() {

        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        return(in.nextLine());

   }
    
   private int getOption() {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
        	System.out.println("Invalid input");
        }
        return returnOption;

        


    }

}
