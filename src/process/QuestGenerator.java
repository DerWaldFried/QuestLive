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
        allQuests.add(new QuestSystem("10 Liegestützt", "", 10, false));
        allQuests.add(new QuestSystem("Kaufe ein Wasser", "", 5, false));
        allQuests.add(new QuestSystem("Spende 2 Euro", "", 2,false));
        allQuests.add(new QuestSystem("Rede nicht. Handel!", "", 20,false));
        allQuests.add(new QuestSystem("Kauf dir ein Obst/Gemüse", "", 20,false));
        allQuests.add(new QuestSystem("Erledige Papierkram", "", 10,false));
        allQuests.add(new QuestSystem("Mach 10 Hampelmänner", "", 10,false));
        allQuests.add(new QuestSystem("Jogge 2km", "", 20,false));
        allQuests.add(new QuestSystem("Entspanne zu einem Tee", "", 25,false));
    }

    public Set<QuestSystem> generateDailyQuests() {
        Set<QuestSystem> dailyQuests = new HashSet<>();
        if (allQuests.size() > 0) {
            while (dailyQuests.size() < 7) {
                int index = random.nextInt(allQuests.size());
                dailyQuests.add(allQuests.get(index));
            }
        } else {
            /*
             * Wenn keine Quest vorhanden sind, zeigen wir erstmal nur eine Information in der Konsole. Der Inhalt in der
             * Swing Ansicht bekommt einen InfoEintrag als Quest
             */
            System.out.println("Keine Quests verfügbar.");
            allQuests.add(new QuestSystem("Der verflixte Fehler", "Melde den Fehler im Github.", 100, false));
        }
        return dailyQuests;
    }
}

