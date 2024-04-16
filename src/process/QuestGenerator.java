package process;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuestGenerator {
    private List<QuestSystem> allQuests;
    private Random random;

    public QuestGenerator() {
        allQuests = new ArrayList<>();
        random = new Random();
        
        // Fügen Sie hier weitere Quests hinzu
        allQuests.add(new QuestSystem("Der verlorene Zauberstab", "Finde den verlorenen Zauberstab des Magiers.", 10, false));
        allQuests.add(new QuestSystem("Die verfluchte Rüstung", "Befreie die Rüstung von ihrem Fluch.", 25, false));
        allQuests.add(new QuestSystem("Die verfluchte Rüstung2", "Befreie die Rüstung von ihrem Fluch.", 25,false));
        allQuests.add(new QuestSystem("Die verfluchte Rüstung3", "Befreie die Rüstung von ihrem Fluch.", 25,false));
        allQuests.add(new QuestSystem("Die verfluchte Rüstung4", "Befreie die Rüstung von ihrem Fluch.", 25,false));
        allQuests.add(new QuestSystem("Die verfluchte Rüstung5", "Befreie die Rüstung von ihrem Fluch.", 25,false));
        allQuests.add(new QuestSystem("Die verfluchte Rüstung6", "Befreie die Rüstung von ihrem Fluch.", 25,false));
        allQuests.add(new QuestSystem("Die verfluchte Rüstung7", "Befreie die Rüstung von ihrem Fluch.", 25,false));
        allQuests.add(new QuestSystem("Die verfluchte Rüstung8", "Befreie die Rüstung von ihrem Fluch.", 25,false));
    }

    public Set<QuestSystem> generateDailyQuests() {
        Set<QuestSystem> dailyQuests = new HashSet<>();
        if (allQuests.size() > 0) {
            while (dailyQuests.size() < 7) {
                int index = random.nextInt(allQuests.size());
                dailyQuests.add(allQuests.get(index));
            }
        } else {
            // Behandeln Sie den Fall, dass keine Quests verfügbar sind
            System.out.println("Keine Quests verfügbar.");
        }
        return dailyQuests;
    }
}

