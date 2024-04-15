package process;

public class QuestSystem {
	private String name;
	private String desc;
	
	public QuestSystem(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public String getQName() {
		return name;
	}
	public String getQDesc() {
		return desc;
	}
}
