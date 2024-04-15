package windows;

import javax.swing.*;

import process.QuestGenerator;
import process.QuestSystem;

//Ich importiere die benötigten Swing-Komponenten für die GUI.
import javax.swing.*;

import java.util.Set;
import java.util.Vector;

//Ich definiere eine Klasse QuestFrame, die von JFrame erbt, um ein Fenster zu erstellen.
public class QuestFrame extends JFrame {
 // Ich deklariere eine JList, die QuestSystem-Objekte halten wird.
 private JList<QuestSystem> questList;
 // Ich deklariere einen QuestGenerator, der für die Erzeugung der Quests zuständig ist.
 private QuestGenerator generator;

 // Im Konstruktor der QuestFrame-Klasse initialisiere ich die Komponenten.
 public QuestFrame() {
     // Ich erstelle eine Instanz von QuestGenerator.
     generator = new QuestGenerator();
     // Ich rufe die Methode generateDailyQuests auf, um ein Set von Quests für den Tag zu erhalten.
     Set<QuestSystem> todaysQuests = generator.generateDailyQuests();
     // Ich initialisiere die JList mit den Quests, die in einen Vector umgewandelt wurden.
     questList = new JList<>(new Vector<>(todaysQuests));
     // Ich füge die JList in einen JScrollPane ein, damit sie scrollbar ist.
     add(new JScrollPane(questList));
     // Ich setze den Titel des Fensters.
     setTitle("Tägliche Quests");
     // Ich setze die Größe des Fensters.
     setSize(400, 300);
     // Ich sorge dafür, dass das Programm beendet wird, wenn das Fenster geschlossen wird.
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     // Ich zentriere das Fenster auf dem Bildschirm.
     setLocationRelativeTo(null);
 }
}

