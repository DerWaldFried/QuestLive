package pluginsystem;

import java.util.List;

import process.QuestSystem;
import windows.SettingsWindow;

public class QuestLoader {
	public static List<QuestSystem> getNewQuests() {
        SettingsWindow settingsWindow = new SettingsWindow();
        return settingsWindow.getNewQuests();
    }
}
