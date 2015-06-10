package FeelyGUI;

import Feely.*;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;

public class DestinationPreferences {

	JPanel Destinations = new JPanel();

	private ArrayList<JCheckBox> checkboxList = new ArrayList<JCheckBox>();
	private Box genre_dest = Box.createVerticalBox();

	public DestinationPreferences() {
		Destinations.setBackground(new Color(255, 250, 205));

		Destinations.setLayout(null);
		JLabel Destinations2 = new JLabel("Destinations");
		Destinations2.setFont(new Font("Tahoma", Font.BOLD, 13));
		Destinations2.setBounds(10, 11, 98, 22);
		Destinations.add(Destinations2);


		/*
		 * Ενεργοποίηση των αντίστοιχων checkbox, ανάλογα με τις προτιμήσεις του χρήστη.
		 */
		for(int i=0;i<CategoryManagement.getDestinationcategorymatrix().length;i++){

			JCheckBox j = new JCheckBox(CategoryManagement.getDestinationcategorymatrix()[i]);
			checkboxList.add(j);

			for(String s:UserManagement.getCurrentUser().getDestinationCategoryList()) {
				if(s.equals(j.getText()))
					j.setSelected(true);
			}
			genre_dest.add(j);        	
		}

		JScrollPane scrollPane_5 = new JScrollPane(genre_dest);
		scrollPane_5.setBounds(20, 39, 213, 281);
		Destinations.add(scrollPane_5);

		
		/*
		 * Κουμπί "Back"
		 */
		JLabel back_destinations = new JLabel("");
		back_destinations.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_destinations.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_destinations.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_destinations.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_destinations.setIcon(IH);

				/*
				genre_dest.removeAll();
				for(JCheckBox c : checkboxList){
					c.setSelected(false);
					for(String s:UserManagement.getCurrentUser().getDestinationCategoryList()){
						if(s.equals(c.getText()))
							c.setSelected(true);
					}
					genre_dest.add(c);
				}*/
				
				HomeScreen.cd.show(HomeScreen.container, "ep");
			}
		});

		back_destinations.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_destinations.setBounds(319, 290, 40, 40);
		Destinations.add(back_destinations);


		/*
		 * Κουμπί "Save"
		 */
		JLabel save_destinations = new JLabel("");
		save_destinations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_destinations.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				save_destinations.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				save_destinations.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_destinations.setIcon(IH);

				ArrayList<String> dest_cat = new ArrayList<String>();
				
				//dest_cat.clear();
				for(JCheckBox c : checkboxList){
					if(c.isSelected()){
						dest_cat.add(c.getText());
					}
				}

				UserManagement.getCurrentUser().setDestinationCategoryList(dest_cat);;
				UserManagement.serialization();
				
				HomeScreen.cd.show(HomeScreen.container, "ep");
			}
		});

		save_destinations.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		save_destinations.setBounds(398, 300, 60, 25);
		Destinations.add(save_destinations);


		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_D_Pref = new JLabel("");
		Help_D_Pref.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_D_Pref.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_D_Pref.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_D_Pref.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_D_Pref.setIcon(IH);
				String Identifier = "Destinations";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});

		Help_D_Pref.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_D_Pref.setBounds(459, 0, 25, 25);
		Destinations.add(Help_D_Pref);
	}
	
	public boolean noBoxChecked() {
		for (JCheckBox c: checkboxList) {
			if (c.isSelected()) {
				return false;
			}
		}
		return true;
	}

}
