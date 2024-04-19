package process;

import java.awt.Component;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public abstract class AbstractQuest implements Serializable{
	private static final long serialVersionUID = 1L;

	private String name;
    private String desc;
    private int xp;
    private boolean accepted;
    private boolean finished;

    transient ExperiencePoints xpPoints = new ExperiencePoints();

    public AbstractQuest(String name, String desc, int xp, boolean accepted, boolean finished) {
        this.name = name;
        this.desc = desc;
        this.xp = xp;
        this.accepted = accepted;
        this.finished = finished;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void onDoubleClick();
    public abstract void itIsReady();

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getXp() {
        return xp;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
	
}
