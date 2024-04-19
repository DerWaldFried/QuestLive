package windows;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import process.FileSystem;
import process.QuestSystem;

public class SettingsWindow {
	private JTextField qName;
    private JTextField qDesc;
    
    public SettingsWindow() {
    	File file = new File("config.txt");
    	FileSystem filesystem = new FileSystem();
    	
        // Ich erstelle das Einstellungsfenster
        JFrame settingsFrame = new JFrame("Einstellungen");
        settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingsFrame.setSize(400, 250);
        settingsFrame.setResizable(false);
        settingsFrame.getContentPane().setLayout(new BoxLayout(settingsFrame.getContentPane(),  BoxLayout.Y_AXIS));

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(null);
        btnPanel.setSize(400, 40);
        
        JPanel questCPanel = new JPanel();
        questCPanel.setLayout(null);
        questCPanel.setSize(400, 50);
        
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
        
        /**
         * Test für ein QuestAdd System
         */
        
        	JLabel qNameLbl = new JLabel("QuestName:");
    		qNameLbl.setBounds(0, 0, 100, 20);
        	qName = new JTextField();
        	qName.setBounds(200, 0, 300, 20);

        	JLabel qDescLbl = new JLabel("Quest Beschreibung:");
        	qDescLbl.setBounds(0, 20, 100, 20);
        	qDesc = new JTextField();
        	qDesc.setBounds(200, 20, 300, 20);
        	
        	JButton sQuestBTN = new JButton();
        	sQuestBTN.setBounds(0, 30, 0, 10);
        	sQuestBTN.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//Eintrag hinzufügen
					QuestSystem cquest = new QuestSystem(qName.getText(), qDesc.getText(), 20, false, false);
					
					
				}
			});
        	
        
        /*
         * Test Ende
         */
        
        //Schaltfläche zum Speichern
        JButton saveConfigBTN = new JButton("Speichern");
        saveConfigBTN.setBounds(0, 0, 400, 40);

        //Einbinden ins Fenster
        settingsFrame.getContentPane().add(difficultyLabel);
        settingsFrame.getContentPane().add(difficultySlider);
        settingsFrame.getContentPane().add(standUpTimer);
        settingsFrame.getContentPane().add(timeSpinner);
        settingsFrame.getContentPane().add(standUPMin);
        settingsFrame.getContentPane().add(questCPanel);
        settingsFrame.getContentPane().add(btnPanel);
        
        questCPanel.add(qNameLbl);
        questCPanel.add(qName);
        questCPanel.add(qDesc);
        questCPanel.add(qDescLbl);
        
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
		        	System.out.println("Configdatei ist vorhanden.");
		        	
		        	//Methode zum beschreiben der Datei
		        	filesystem.writeFile(file, time, difficulty);
		        	
		        }else {
		        	System.out.println("Die Configdatei fehlt und wird nun angelegt");
		        	filesystem.Filechecker(file);
		        	filesystem.writeFile(file, time, difficulty);
		        }
		        settingsFrame.dispose();
			}
		});       
        /*
         * Button Klick Event Ende
         */
        
        settingsFrame.setLocationRelativeTo(null);
        settingsFrame.setVisible(true);
        
    }

    public List<QuestSystem> getNewQuests() {
        List<QuestSystem> newQuests = new ArrayList<>();
        String name = qName.getText();
        String description = qDesc.getText();
        if (!name.isEmpty() && !description.isEmpty()) {
            QuestSystem quest = new QuestSystem(name, description, 20, false, false);
            newQuests.add(quest);
        }
        return newQuests;
    }
}
