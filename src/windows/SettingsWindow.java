package windows;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class SettingsWindow {
    public SettingsWindow() {
        // Ich erstelle das Einstellungsfenster
        JFrame settingsFrame = new JFrame("Einstellungen");
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingsFrame.setSize(300, 200);

        // Füge Einstellungsoptionen hinzu
        JLabel difficultyLabel = new JLabel("Schwierigkeitsgrad:");
        JSlider difficultySlider = new JSlider(1, 10, 5);
        difficultyLabel.setLabelFor(difficultySlider);

        settingsFrame.getContentPane().add(difficultyLabel);
        settingsFrame.getContentPane().add(difficultySlider);
        settingsFrame.setVisible(true);
    }
}
