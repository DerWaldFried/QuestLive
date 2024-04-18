package process;

import java.beans.Expression;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
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
	
	public int[] loadProfile(File file) {
	    int[] returner = new int[2];
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(working_dir + "\\" + file));

	        // Lese die erste Zeile und speichere den Wert in XPStr
	        String XPStr = reader.readLine();
	        // Lese die zweite Zeile und speichere den Wert in LevelStr
	        String LevelStr = reader.readLine();
	        
	        reader.close();

	        if (XPStr != null)
	            returner[0] = Integer.parseInt(XPStr);

	        if (LevelStr != null)
	            returner[1] = Integer.parseInt(LevelStr);

	    } catch (IOException e) {
	        // Wenn das Laden nicht funktioniert
	        e.printStackTrace();
	    }
	    return returner;
	}
	
	public void writeFirstIntLine(File file, int newLine) {
	    try {
	        // Erstelle einen BufferedReader zum Lesen der Datei
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        // Lese die erste Zeile
	        String firstLine = reader.readLine();
	        // Lese die zweite Zeile
	        String secondLine = reader.readLine();
	        // Schließe den Reader
	        reader.close();

	        // Erstelle einen BufferedWriter zum Schreiben in die Datei
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        // Schreibe die neue erste Zeile
	        writer.write("" + (Integer.parseInt(firstLine) + newLine));
	        writer.newLine();
	        // Schreibe die unveränderte zweite Zeile
	        if (secondLine != null) {
	            writer.write(secondLine);
	            writer.newLine();
	        }
	        // Schreibe den Rest der Originaldatei, beginnend von der dritten Zeile
	        reader = new BufferedReader(new FileReader(file)); // Öffne den Reader erneut
	        reader.readLine(); // Überspringe die ersten beiden Zeilen
	        reader.readLine();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            writer.write(line);
	            writer.newLine();
	        }
	        // Schließe den Reader und den Writer
	        reader.close();
	        writer.close();
	    } catch (IOException | NumberFormatException e) {
	        e.printStackTrace();
	    }
	}
}
