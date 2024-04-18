package process;

import java.io.File;
import java.io.Serializable;

public class ExperiencePoints implements Serializable{
	File file = new File("profile.txt");
	FileSystem fileSystem = new FileSystem();
	
	
	public int readyQ(int xp) {
		int xpcheck = xp;
		
		checkFunc(file);
		
		if(fileSystem.Filechecker(file)) {
			fileSystem.writeFirstIntLine(file, xpcheck);
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
    	
    	if(xp>150) {
    		level += 1;
    	}
    	
    	fileSystem.writeFile(file, xp, level);
	}
	
	private void checkFunc(File file) {
		if(fileSystem.Filechecker(file)) {
        	System.out.println("Configdatei ist vorhanden.");
        	
        }else {
        	System.out.println("Die Konfiguration für das Profile ist nicht da.");
        	System.out.println("Bitte wende die an den Support. Wenn es nach einem Neustart nicht funktioniert.");
        	fileSystem.writeFile(file, 0,1);
        }
	}
}
