package windows;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import process.FileSystem;

public class SettingsWindow {
    public SettingsWindow() {
    	File file = new File("config.txt");
    	FileSystem filesystem = new FileSystem();
    	
        // Ich erstelle das Einstellungsfenster
        JFrame settingsFrame = new JFrame("Einstellungen");
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingsFrame.setSize(400, 200);
        settingsFrame.setResizable(false);
        settingsFrame.getContentPane().setLayout(new BoxLayout(settingsFrame.getContentPane(),  BoxLayout.Y_AXIS));

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(null);
        btnPanel.setSize(400, 40);
        
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
        saveConfigBTN.setBounds(0, 0, 400, 40);

        //Einbinden ins Fenster
        settingsFrame.getContentPane().add(difficultyLabel);
        settingsFrame.getContentPane().add(difficultySlider);
        settingsFrame.getContentPane().add(standUpTimer);
        settingsFrame.getContentPane().add(timeSpinner);
        settingsFrame.getContentPane().add(standUPMin);
        settingsFrame.getContentPane().add(btnPanel);
        
        btnPanel.add(saveConfigBTN);
        /*
         * Button Klick Event
         */
        saveConfigBTN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int difficulty = difficultySlider.getValue();
		        Date time = (Date) timeSpinner.getValue();
		        
		        if(filesystem.Filechecker(file)) {
		        	
		        }else {
		        	System.out.println("Die Configdatei fehlt und wird nun angelegt");
		        	filesystem.Filechecker(file);
		        }
				
			}
		});       
        /*
         * Button Klick Event Ende
         */
        
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setVisible(true);
        
    }
}
