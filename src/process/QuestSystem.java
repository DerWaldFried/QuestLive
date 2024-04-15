package process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestSystem<Quest> {
	private String name;
	private String desc;
	private boolean finished;
	
	public QuestSystem(String name, String desc, boolean finished) {
		this.name = name;
		this.desc = desc;
		this.finished = finished;
	}
	
	public String getQName() {
		return name;
	}
	public String getQDesc() {
		return desc;
	}
	public boolean getQFinished() {
		return finished;
	}

	class QuestGenerator{
		private List<Quest> allQuest;
		private Random random;
		
		public QuestGenerator() {
			allQuest = new ArrayList<>();
			random = new Random();
			
			//Erster Eintrag
			allQuest.add((Quest) new QuestSystem<Quest>("Stay Fresh", "Putze dir deine Zähne", false));
		}
		
	}
}