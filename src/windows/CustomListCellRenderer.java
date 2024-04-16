/*
 * 
 * AI GENERATED TO MAKE COLORCHANGE POSSIBLE
 * 
 */
package windows;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import process.QuestSystem;

public class CustomListCellRenderer extends DefaultListCellRenderer {

	private QuestSystem questsystem;
	
	 // Index des Eintrags, dessen Textfarbe geändert werden soll
    private int targetIndex = 1; // Ändere dies auf den Index des Eintrags, den du ändern möchtest

    // Farbe für den gezielten Eintrag1
    private Color targetColor = Color.RED; // Ändere dies auf die gewünschte Farbe

    public CustomListCellRenderer(QuestSystem questsystem) {
    	this.questsystem = questsystem;
    }
    
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        // Lasse die Standard-Renderung durchführen
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // Überprüfe, ob der aktuelle Index dem Zielindex entspricht
     // Überprüfe, ob der aktuelle Index dem Zielindex entspricht
        if (index == targetIndex) {
            // Setze die Textfarbe basierend auf der Bedingung
            if (questsystem.getQAccepted()== "Ja") {
                setForeground(Color.GREEN); // Grüne Farbe, wenn accepted true ist
            } else if(questsystem.getQAccepted()== null) {
                setForeground(Color.YELLOW); // Gelbe Farbe, wenn accepted false ist
            }
        }

        return this;
        
    }
}
