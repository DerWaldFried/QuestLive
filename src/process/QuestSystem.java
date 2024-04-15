package process;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
		
		public Set<Quest> generateDailyQuests() {
	        Set<Quest> dailyQuests = new HashSet<>();
	        while (dailyQuests.size() < 5) {
	            int index = random.nextInt(allQuest.size());
	            dailyQuests.add(allQuest.get(index));
	        }
	        return dailyQuests;
	    }
		
	}
}