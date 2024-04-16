package process;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class QuestSystem<Quest> {
	private String name;
	private String desc;
	private int xp;
	private boolean accepted;
	private boolean finished;
	
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
		return name+"→ "+desc+" XP: "+xp+" | Angenommen: "+accepted;
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
        });

        // Nun Erstelle ich eine OptionPane mit dem Text und dem Annehmen-Button und binde ihn ein.
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{acceptButton});
        JDialog dialog = optionPane.createDialog("Quest Details");

        // dialog sichtbar
        dialog.setVisible(true);
		
	}
	
	
}