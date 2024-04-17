package process;

import java.beans.Expression;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import windows.SettingsWindow;

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
			File configFileObj = new File(working_dir+"/"+file);
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
	
	public void writeFile(File file, Object... values) {
		
		try {
			FileWriter fwrite = new FileWriter(working_dir+"/"+file);
			for (Object value : values) {
                fwrite.write(value.toString() + "\n");
                System.out.println(value);
            }
			fwrite.close();
			
			System.out.println("Schreiben in Datei ausgeführt.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadConfig(File file) {
		try {
            BufferedReader reader = new BufferedReader(new FileReader(working_dir+"/"+file));
            String dateTimeStr = reader.readLine();
            String diffStr = reader.readLine();
            reader.close();

            SimpleDateFormat formatter = new SimpleDateFormat("HH");
            Date time = formatter.parse(dateTimeStr);
            int difficulty = Integer.parseInt(diffStr);
            
        } catch (IOException e) {
        	// Wenn das laden nicht funktioniert
            e.printStackTrace();
        } catch (ParseException e) {
			// Wenn Parse nicht funktioniert
			e.printStackTrace();
		}
	}
	
}
