package windows;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InfoWindow {

	public InfoWindow(){
		// Ich erstelle das Informationsfenster
        JFrame infoFrame = new JFrame("Info Fenster");
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoFrame.setSize(400, 350);
        infoFrame.setResizable(false);
        infoFrame.getContentPane().setLayout(new BoxLayout(infoFrame.getContentPane(),  BoxLayout.Y_AXIS));
        
        JLabel infoLbl = new JLabel("Bei Problemen wendet euch bitte über Github an mich.");
        JLabel info2Lbl = new JLabel("Dieses Projekt ist innerhalb von einer Umschulung entstanden.");
        
        infoFrame.add(infoLbl);
        infoFrame.add(info2Lbl);
        
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setVisible(true);
	}
}
