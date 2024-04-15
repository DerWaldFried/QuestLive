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
        // Beispielquests hinzufügen
        // ...
    }

    public Set<QuestSystem> generateDailyQuests() {
        Set<QuestSystem> dailyQuests = new HashSet<>();
        if (allQuests.size() > 0) {
            while (dailyQuests.size() < 5) {
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

