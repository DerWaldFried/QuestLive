package base;

import javax.swing.SwingUtilities;

import windows.QuestFrame;

public class QuestLive {

	 // Die main-Methode, die beim Start des Programms aufgerufen wird.
	 public static void main(String[] args) {
	     // Ich sorge dafür, dass die GUI im Event-Dispatch-Thread von Swing erstellt wird.
	     SwingUtilities.invokeLater(() -> {
	         // Ich erstelle eine Instanz von QuestFrame.
	         QuestFrame frame = new QuestFrame();
	         // Ich mache das Fenster sichtbar.
	         frame.setVisible(true);
	     });
	 }

}
