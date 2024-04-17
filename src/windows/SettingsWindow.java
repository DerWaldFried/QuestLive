package windows;

import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class SettingsWindow {
    public SettingsWindow() {
        // Ich erstelle das Einstellungsfenster
        JFrame settingsFrame = new JFrame("Einstellungen");
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingsFrame.setSize(400, 200);
        settingsFrame.getContentPane().setLayout(new BoxLayout(settingsFrame.getContentPane(),  BoxLayout.Y_AXIS));

        /*
         * Komponenten der Einstellungen
         */
        
        //Schwierigkeitsgrad Komponenten
        JLabel difficultyLabel = new JLabel("Schwierigkeitsgrad:");
        JSlider difficultySlider = new JSlider(1, 10, 5);
        difficultyLabel.setLabelFor(difficultySlider);
        
        //Aufsteh Timer Komponenten Text
        JLabel standUpTimer = new JLabel("Wann müssen sie immer aufstehen?");
        JLabel standUPMin = new JLabel("Achtung: Schlafenszeit setzt automatisch 8 Stunden.");
        
        //Aufsteh Timer Komponenten
        SpinnerDateModel model = new SpinnerDateModel();
        model.setCalendarField(Calendar.MINUTE);
        JSpinner timeSpinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(timeSpinner,"HH:mm");
        timeSpinner.setEditor(editor);
        standUpTimer.setLabelFor(timeSpinner);
        
        //Schaltfläche zum Speichern
        JButton saveConfigBTN = new JButton("Speichern"); 

        //Einbinden ins Fenster
        settingsFrame.getContentPane().add(difficultyLabel);
        settingsFrame.getContentPane().add(difficultySlider);
        settingsFrame.getContentPane().add(standUpTimer);
        settingsFrame.getContentPane().add(timeSpinner);
        settingsFrame.getContentPane().add(standUPMin);
        settingsFrame.add(saveConfigBTN);
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setVisible(true);
    }
}
