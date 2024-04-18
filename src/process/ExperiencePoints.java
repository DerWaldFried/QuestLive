package process;

import java.io.File;

public class ExperiencePoints {
	File file = new File("profile.txt");
	FileSystem fileSystem = new FileSystem();
	
	
	public int readyQ(int xp) {
		int xpcheck = xp;
		
		if(fileSystem.Filechecker(file)) {
			fileSystem.writeFirstIntLine(file, 0,xp);
			checkXPtoLevel();
		}else {
			System.out.println("Es gibt ein Problem mit dem Lesen oder finden der Datei.");
		}
		
		return xpcheck;
	}
	
	private void checkXPtoLevel() {
		int[] returner = fileSystem.loadProfile(file);
    	//Zwischenspeichern
		int xp = returner[0];
    	int level = returner[1];
    	
    	if(xp>1000) {
    		level += 1;
    	}
    	
    	fileSystem.writeFile(file, xp, level);
	}
}
