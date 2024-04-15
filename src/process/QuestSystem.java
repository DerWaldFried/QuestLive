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
	
	@Override
	public String toString() {
		return name+": "+desc;
	}
}