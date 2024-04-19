package process;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import pluginsystem.QuestLoader;
import windows.SettingsWindow;

public class QuestGenerator implements Serializable {
    private ArrayList<QuestSystem> allQuests;
    private Random random;

    public QuestGenerator() {
        allQuests = new ArrayList<>();
        random = new Random();
        
        // Fügen Sie hier weitere Quests hinzu
        allQuests.add(new QuestSystem("10 Liegestützt", "", 10, false, false));
        allQuests.add(new QuestSystem("Kaufe ein Wasser", "", 5, false, false));
        allQuests.add(new QuestSystem("Spende 2 Euro", "", 2, false, false));
        allQuests.add(new QuestSystem("Rede nicht. Handel!", "", 20, false, false));
        allQuests.add(new QuestSystem("Kauf dir ein Obst/Gemüse", "", 20, false, false));
        allQuests.add(new QuestSystem("Erledige Papierkram", "", 10, false, false));
        allQuests.add(new QuestSystem("Mach 10 Hampelmänner", "", 10, false, false));
        allQuests.add(new QuestSystem("Jogge 2km", "", 20, false, false));
        allQuests.add(new QuestSystem("Entspanne zu einem Tee", "", 25, false, false));
        
        //Lade alle Quest aus Settings
        List<QuestSystem> newQuests = QuestLoader.getNewQuests();
        if(newQuests != null)
        	allQuests.addAll(newQuests);
        
        System.out.println(allQuests);
    }

    public Set<QuestSystem> generateDailyQuests() {
        Set<QuestSystem> dailyQuests = new HashSet<>();
        File file = new File("dailyQ.txt");
        
        //Vorgang wenn die Datei vorhanden ist oder nicht vorhanden ist.
        if(file.exists()){
        	try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
        		// Wenn die letzte Generierung weniger als 24 Stunden her ist, verwende ich die gespeicherten Quests.
        		LocalDateTime lastGenerated = (LocalDateTime) ois.readObject();
        		if(Duration.between(lastGenerated, LocalDateTime.now()).toHours() < 24) {
        			dailyQuests = (Set<QuestSystem>) ois.readObject();
        			return dailyQuests;
        		}
        		
        	}catch(StreamCorruptedException e) {
        		System.out.println("Die Datei 'dailyQ.txt' wurde manuell verändert und kann nicht gelesen werden.");
        		file.delete();
        	}catch(IOException | ClassNotFoundException e) {
        		e.printStackTrace();
        	}
        }
        //Vorgang Ende
        
        // Wenn die Liste der Quests nicht leer ist, generiere ich zufällig 7 tägliche Quests.
        if (allQuests.size() > 0) {
            while (dailyQuests.size() < 5) {
                int index = random.nextInt(allQuests.size());
                dailyQuests.add(allQuests.get(index));
            }
        } else {
            /*
             * Wenn keine Quest vorhanden sind, zeigen wir erstmal nur eine Information in der Konsole. Der Inhalt in der
             * Swing Ansicht bekommt einen InfoEintrag als Quest
             */
            System.out.println("Keine Quests verfügbar.");
            allQuests.add(new QuestSystem("Der verflixte Fehler", "Melde den Fehler im Github.", 100, true, false));
        }
        
     // Ich speichere die generierten täglichen Quests in der Datei.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(LocalDateTime.now());
            oos.writeObject(dailyQuests);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return dailyQuests;
    }
}

