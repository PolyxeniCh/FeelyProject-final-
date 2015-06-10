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

public class ActivityPreferences {

	JPanel Activities = new JPanel();

	private ArrayList<JCheckBox> checkboxList = new ArrayList<JCheckBox>();
	private Box genre_act = Box.createVerticalBox();

	public ActivityPreferences(){
		Activities.setBackground(new Color(255, 250, 205));

		Activities.setLayout(null);
		JLabel Activities2 = new JLabel("Activities");
		Activities2.setFont(new Font("Tahoma", Font.BOLD, 13));
		Activities2.setBounds(10, 11, 98, 22);
		Activities.add(Activities2);


		/*
		 * Ενεργοποίηση των αντίστοιχων checkbox, ανάλογα με τις προτιμήσεις του χρήστη.
		 */
		for(int i=0;i<CategoryManagement.getActivityintensitymatrix().length;i++){

			JCheckBox j = new JCheckBox(CategoryManagement.getActivityintensitymatrix()[i]);
			checkboxList.add(j);

			for(String s:UserManagement.getCurrentUser().getActivityIntensityList()) {
				if(s.equals(j.getText()))
					j.setSelected(true);
			}
			genre_act.add(j);
		}

		JScrollPane scrollPane_4 = new JScrollPane(genre_act);
		scrollPane_4.setBounds(20, 39, 213, 281);
		Activities.add(scrollPane_4);


		/*
		 * Κουμπί "Back"
		 */
		JLabel back_activities = new JLabel("");
		back_activities.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_activities.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_activities.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_activities.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_activities.setIcon(IH);
				
				HomeScreen.cd.show(HomeScreen.container, "ep");
			}
		});

		back_activities.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_activities.setBounds(319, 290, 40, 40);
		Activities.add(back_activities);


		/*
		 * Κουμπί "Save"
		 */
		JLabel save_activities = new JLabel("");
		save_activities.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_activities.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				save_activities.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				save_activities.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_activities.setIcon(IH);

				ArrayList<String> Activities_intensity = new ArrayList<String>();

				//Activities_intensity.clear();
				for(JCheckBox c:checkboxList){
					if(c.isSelected()){
						Activities_intensity.add(c.getText());
					}
				}

				UserManagement.getCurrentUser().setActivityIntensityList(Activities_intensity);
				UserManagement.serialization();
				
				HomeScreen.cd.show(HomeScreen.container, "ep");
			}
		});

		save_activities.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		save_activities.setBounds(398, 300, 60, 25);
		Activities.add(save_activities);


		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_A_Pref = new JLabel("");
		Help_A_Pref.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_A_Pref.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_A_Pref.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_A_Pref.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_A_Pref.setIcon(IH);
				String Identifier = "Activities";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		Help_A_Pref.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_A_Pref.setBounds(459, 0, 25, 25);
		Activities.add(Help_A_Pref);

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
