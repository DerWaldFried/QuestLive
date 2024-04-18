package windows;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import process.FileSystem;

public class ProfileWindow {
	int fontSize = 25;
	
	public ProfileWindow() {
    	File file = new File("profile.txt");
    	FileSystem filesystem = new FileSystem();
    	JProgressBar xpProgressBar;
    	
        // Ich erstelle das Einstellungsfenster
        JFrame profileFrame = new JFrame("Profil");
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileFrame.setSize(400, 200);
        profileFrame.setResizable(false);
        profileFrame.getContentPane().setLayout(new BoxLayout(profileFrame.getContentPane(),  BoxLayout.Y_AXIS));

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(null);
        btnPanel.setSize(400, 40);
        
        /*
         * Komponenten der Einstellungen
         */
        
        //XP Komponenten
        JLabel XPLabel = new JLabel("Deine Erfahrungspunkte:");
     // Erstelle den XP Ladebalken
        xpProgressBar = new JProgressBar();
        xpProgressBar.setStringPainted(true); // Zeige den Text an
        xpProgressBar.setMinimum(0); // Mindestwert für XP
        xpProgressBar.setMaximum(150); // Maximalwert für XP
        XPLabel.setLabelFor(xpProgressBar);
        
        JLabel lvlLabel = new JLabel("Dein aktuelles Level:");
        JLabel lvlViewLbl = new JLabel();
        //Schaltfläche zum Speichern
        JButton saveConfigBTN = new JButton("Ok");
        saveConfigBTN.setBounds(0, 0, 400, 40);
        
        /*
         * Beginn FileCheck
         */
    		if(filesystem.Filechecker(file)) {
            	System.out.println("Configdatei ist vorhanden.");
            	
            	//Methode zum beschreiben der Datei
            	int[] returner = filesystem.loadProfile(file);
            	xpProgressBar.setValue(returner[0]);
            	lvlViewLbl.setText(""+returner[1]);
            	
            	Font oldFont = lvlViewLbl.getFont();
            	Font newFont = new Font(oldFont.getName(), oldFont.getStyle(), fontSize);
            	lvlViewLbl.setFont(newFont);
            	
            }else {
            	System.out.println("Die Konfiguration für das Profile ist nicht da.");
            	System.out.println("Bitte wende die an den Support. Wenn es nach einem Neustart nicht funktioniert.");
            	filesystem.writeFile(file, 0,1);
            }
        /*
         * Ende FileCheck
         */
        
        //Einbinden ins Fenster
        profileFrame.getContentPane().add(XPLabel);
        profileFrame.getContentPane().add(xpProgressBar);
        profileFrame.getContentPane().add(lvlLabel);
        profileFrame.getContentPane().add(lvlViewLbl);
        profileFrame.getContentPane().add(btnPanel);
        
        btnPanel.add(saveConfigBTN);
        /*
         * Button Klick Event
         */
        saveConfigBTN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        profileFrame.dispose();
			}
		});
        /*
         * Button Klick Event Ende
         */
        
        profileFrame.setLocationRelativeTo(null);
        profileFrame.setVisible(true);
        
    }
}
