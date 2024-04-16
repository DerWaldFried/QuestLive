package windows;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import process.QuestGenerator;
import process.QuestSystem;

//Ich importiere die benötigten Swing-Komponenten für die GUI.
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;
import java.util.Vector;

class JQuestList<E> extends JList<E> {
	public JQuestList(final Vector<? extends E> listData) {
		super(listData);
		
	     this.setCellRenderer(new CustomListCellRenderer((QuestSystem)listData.get(0)));
	}
}


//Ich definiere eine Klasse QuestFrame, die von JFrame erbt, um ein Fenster zu erstellen.
public class QuestFrame extends JFrame {
 // Ich deklariere eine JList, die QuestSystem-Objekte halten wird.
 private JList<QuestSystem> questList;
 // Ich deklariere 3 JButton der die Wege eröffnet
 private JButton configbtn;
 private JButton profilebtn;
 private JButton infobtn;
 // Ich deklariere einen QuestGenerator, der für die Erzeugung der Quests zuständig ist.
 private QuestGenerator generator;

 // Im Konstruktor der QuestFrame-Klasse initialisiere ich die Komponenten.
 public QuestFrame() {
     // Ich erstelle eine Instanz von QuestGenerator.
     generator = new QuestGenerator();
     // Ich rufe die Methode generateDailyQuests auf, um ein Set von Quests für den Tag zu erhalten.
     Set<QuestSystem> todaysQuests = generator.generateDailyQuests();
     // Ich initialisiere die JList mit den Quests, die in einen Vector umgewandelt wurden.
     questList = new JQuestList<>(new Vector<>(todaysQuests));
     // Ich füge die JList in einen JScrollPane ein, damit sie scrollbar ist.
     add(new JScrollPane(questList));
     
     // Ich erstelle ein neues JPanel für die Buttons
     JPanel buttonPanel = new JPanel();
     // Ich setze das Layout des Panels auf FlowLayout, damit die Buttons nebeneinander angeordnet werden
     buttonPanel.setLayout(new FlowLayout());
     
     // Generiere die JBUtton Komponenenten für den Panel
     configbtn = new JButton("Einstellungen");
     profilebtn = new JButton("Profil");
     infobtn = new JButton("Informationen");
     
     // Ich füge die Buttons dem Panel hinzu
     buttonPanel.add(configbtn);
     buttonPanel.add(profilebtn);
     buttonPanel.add(infobtn);

     // Ich füge das Button-Panel unterhalb der JScrollPane hinzu
     add(buttonPanel, BorderLayout.SOUTH);
     
     // Ich setze den Titel des Fensters.
     setTitle("Tägliche Quests");
     // Ich setze die Größe des Fensters.
     setSize(400, 300);
     // Ich sorge dafür, dass das Programm beendet wird, wenn das Fenster geschlossen wird.
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     // Ich zentriere das Fenster auf dem Bildschirm.
     setLocationRelativeTo(null);
     
     //AI Generated. Um Farbe in JList zu ändern.
//     questList.setCellRenderer(new CustomListCellRenderer());
     
     questList.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             if (e.getClickCount() == 2) {
                 int index = questList.locationToIndex(e.getPoint());
                 QuestSystem selectedQuest = questList.getModel().getElementAt(index);
                 // Doppelclick Reaktion
                 if(selectedQuest.getQFinished() == true) {
                	 selectedQuest.itIsReady();
                 }else {
                	 selectedQuest.onDoubleClick();
                 }
                 
             }
         }
     });
 }
}

