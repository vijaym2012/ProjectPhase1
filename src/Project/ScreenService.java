package Project;

import Project.WelcomeScreen;

public class ScreenService {
	
	static Directory dir = new Directory();
	
	
	
	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
    public static FileOptionScreen FileOptionsScreen = new FileOptionScreen();
    
    

    public static Screen CurrentScreen = (Screen) WelcomeScreen;

    
    public static Screen getCurrentScreen() {
        return CurrentScreen;
    }

    
    public static void setCurrentScreen(Screen currentScreen) {
        CurrentScreen = currentScreen;
    }
    
    
    
}
