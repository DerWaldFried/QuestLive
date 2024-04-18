package process;

import java.awt.Component;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class QuestSystem implements Serializable{
	/**
	 * 
	 */
	private String name;
	private String desc;
	private int xp;
	private boolean accepted;
	private boolean finished;
	
	transient ExperiencePoints xpPoints = new ExperiencePoints();
	
	public QuestSystem(String name, String desc, int xp, boolean accepted, boolean finished) {
		this.name = name;
		this.desc = desc;
		this.xp = xp;
		this.accepted = accepted;
		this.finished = finished;
	}
	
	//Getter dienen der späteren Funktionalitäten in den JDialog Bereichen
	public String getQName() {
		return name;
	}
	public String getQDesc() {
		return desc;
	}
	public int getQXp() {
		return xp;
	}
	public String getQAccepted() {
		if(accepted == true) {
			return "Ja";
		}else {
			return "Nein";
		}
	}
	public boolean getQFinished() {
		return finished;
	}
	
	@Override
	public String toString() {
		return name+"→ "+desc+" XP: "+xp+" | Angenommen: "+accepted+" | Erledigt: "+finished;
	}

	public void onDoubleClick() {

		// Ich erstelle den Text für den Dialog
        String message = "Name: " + getQName() + "\n" +
                         "Beschreibung: " + getQDesc() + "\n" +
                         "XP: " + getQXp();

        // Erstelle einen Annehmen-Button und dazu passend den Action Listener
        JButton acceptButton = new JButton("Annehmen");
        acceptButton.addActionListener(e -> {
            // Was passiert wenn Quest angenommen?
            JOptionPane.showMessageDialog(null, "Quest angenommen: " + getQName());
            accepted = true;
            System.out.println("Quest angenommen?:"+getQAccepted());
         // Schließe den Dialog, nachdem der Button gedrückt wurde
            JDialog dialog = (JDialog) SwingUtilities.getRoot((Component) e.getSource());
            dialog.dispose();
        });
        //Wenn Quest Angenommen, füge Erledigt Button hinzu
        JButton finishButton = new JButton("Quest abgeben");
        finishButton.addActionListener(e -> {
            // Was passiert wenn Quest angenommen?
            JOptionPane.showMessageDialog(null, "Quest abgegeben: " + getQName());
            finished = true;
            System.out.println("Quest abgegeben?:"+getQFinished());
            xpPoints = new ExperiencePoints();
            // Schließe den Dialog, nachdem der Button gedrückt wurde
            xpPoints.readyQ(getQXp());
            JDialog dialog = (JDialog) SwingUtilities.getRoot((Component) e.getSource());
            dialog.dispose();
        });
        
        // Nun Erstelle ich eine OptionPane mit dem Text und dem Annehmen-Button und binde ihn ein.
        JOptionPane optionPane = null;
        
        
        
        if( accepted == true ) {
        	optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{finishButton});        	
        }
        else {
        	optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{acceptButton});        	
        }
        JDialog dialog = optionPane.createDialog("Quest Details");

        // dialog sichtbar
        dialog.setVisible(true);
		
	}

	public void itIsReady() {
		
		// Ich erstelle den Text für den Dialog
        String message = "Name: " + getQName() + "\n" +
                         "Beschreibung: " + getQDesc() + "\n" +
                         "XP: " + getQXp()+"\n"+
                         "Diese Quest wurde schon erledigt!";

        // Erstelle einen Annehmen-Button und dazu passend den Action Listener
        JButton acceptButton = new JButton("Ok");
        acceptButton.addActionListener(e -> {
            
        });
        
        // Nun Erstelle ich eine OptionPane mit dem Text und dem Annehmen-Button und binde ihn ein.
        JOptionPane optionPane = null;
        
        optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{acceptButton});        	
        	
        JDialog dialog = optionPane.createDialog("Quest Details");

        // dialog sichtbar
        dialog.setVisible(true);
        
	}
	
	
}