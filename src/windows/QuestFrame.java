package windows;

import javax.swing.*;

import process.QuestGenerator;
import process.QuestSystem;

import java.util.Set;
import java.util.Vector;

public class QuestFrame extends JFrame {
    private JList<QuestSystem> questList;
    private QuestGenerator generator;

    public QuestFrame() {
        generator = new QuestGenerator();
        Set<QuestSystem> todaysQuests = generator.generateDailyQuests();
        questList = new JList<>(new Vector<>(todaysQuests));
        add(new JScrollPane(questList));
        setTitle("Tägliche Quests");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuestFrame frame = new QuestFrame();
            frame.setVisible(true);
        });
    }
}

