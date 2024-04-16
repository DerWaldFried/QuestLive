package process;

public class QuestSystem<Quest> {
	private String name;
	private String desc;
	private int xp;
	private boolean finished;
	
	public QuestSystem(String name, String desc, int xp, boolean finished) {
		this.name = name;
		this.desc = desc;
		this.xp = xp;
		this.finished = finished;
	}
	
	public String getQName() {
		return name;
	}
	public String getQDesc() {
		return desc;
	}
	public int getQXp() {
		return xp;
	}
	public boolean getQFinished() {
		return finished;
	}
	
	@Override
	public String toString() {
		return name+": "+desc+"|XP: "+xp;
	}
}