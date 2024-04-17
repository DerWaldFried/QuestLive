package process;

import java.io.File;
import java.io.IOException;

public class FileSystem {

	String working_dir = System.getProperty("user.dir");
	
	public boolean Filechecker(File file) {
		boolean checkup;
		
			File filePath = new File(working_dir + "/" + file);
			if(filePath.exists()) {
				checkup = true;
			}else {
				checkup = false;
				createFileConfig(file);
			}
		
		return checkup;
	}
	
	private void createFileConfig(File file) {
		boolean checkupCreate;
		
		try {
			File configFileObj = new File(working_dir+file);
		    if (configFileObj.createNewFile()) {
		    	System.out.println("File created: " + configFileObj.getName());
		    	} else {
		    		System.out.println("File already exists.");
		    	}
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
}
