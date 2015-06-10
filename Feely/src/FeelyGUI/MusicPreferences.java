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

public class MusicPreferences {

	JPanel Music = new JPanel();

	private ArrayList<JCheckBox> checkboxList = new ArrayList<JCheckBox>();
	private Box genre_music = Box.createVerticalBox();

	public MusicPreferences() {
		Music.setBackground(new Color(255, 250, 205));

		Music.setLayout(null);
		JLabel Music2 = new JLabel("Music");
		Music2.setFont(new Font("Tahoma", Font.BOLD, 13));
		Music2.setBounds(10, 11, 98, 22);
		Music.add(Music2);


		/*
		 * Ενεργοποίηση των αντίστοιχων checkbox, ανάλογα με τις προτιμήσεις του χρήστη.
		 */
		for(int i=0;i<CategoryManagement.getMusicgenrematrix().length;i++){

			JCheckBox j = new JCheckBox(CategoryManagement.getMusicgenrematrix()[i]);
			checkboxList.add(j);

			for(String s:UserManagement.getCurrentUser().getMusicGenreList()) {
				if(s.equals(j.getText()))
					j.setSelected(true);
			}
			genre_music.add(j);      	
		}


		JScrollPane scrollPane_1 = new JScrollPane(genre_music);
		scrollPane_1.setBounds(20, 39, 213, 281);
		Music.add(scrollPane_1);


		/*
		 * Κουμπί "Back"
		 */
		 JLabel back_music = new JLabel("");
		 back_music.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent arg0) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				 back_music.setIcon(IH);

			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				 back_music.setIcon(IH);
			 }
			 @Override
			 public void mousePressed(MouseEvent e) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				 back_music.setIcon(IH);
			 }
			 @Override
			 public void mouseReleased(MouseEvent e) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				 back_music.setIcon(IH);

				 /*
				 genre_music.removeAll();
				 for(JCheckBox c : checkboxList){
					 c.setSelected(false);
					 for(String s:UserManagement.getCurrentUser().getMusicGenreList()){
						 if(s.equals(c.getText()))
							 c.setSelected(true);
					 }
					 genre_music.add(c);
				 }*/
				 
				 HomeScreen.cd.show(HomeScreen.container, "ep");
			 }
		 });

		 back_music.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		 back_music.setBounds(319, 290, 40, 40);
		 Music.add(back_music);


		 /*
		  * Κουμπί "Save"
		  */
		 JLabel save_music = new JLabel("");
		 save_music.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent arg0) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				 save_music.setIcon(IH);

			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				 save_music.setIcon(IH);
			 }
			 @Override
			 public void mousePressed(MouseEvent e) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				 save_music.setIcon(IH);
			 }
			 @Override
			 public void mouseReleased(MouseEvent e) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				 save_music.setIcon(IH);

				 ArrayList<String> music_genre = new ArrayList<String>();
				 
				 //music_genre.clear();
				 for(JCheckBox c : checkboxList){
					 if(c.isSelected()){
						 music_genre.add(c.getText());
					 }
				 }

				 UserManagement.getCurrentUser().setMusicGenreList(music_genre);
				 UserManagement.serialization();
				 
				 HomeScreen.cd.show(HomeScreen.container, "ep");
			 }
		 });

		 save_music.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		 save_music.setBounds(398, 300, 60, 25);
		 Music.add(save_music);


		 /*
		  * Κουμπί "Help"
		  */
		 JLabel Help_M_Pref = new JLabel("");
		 Help_M_Pref.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent arg0) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				 Help_M_Pref.setIcon(IH);

			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				 Help_M_Pref.setIcon(IH);
			 }
			 @Override
			 public void mousePressed(MouseEvent e) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				 Help_M_Pref.setIcon(IH);
			 }
			 @Override
			 public void mouseReleased(MouseEvent e) {
				 ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				 Help_M_Pref.setIcon(IH);
				 String Identifier = "Music";
				 HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				 HomeScreen.cd.show(HomeScreen.container, "Help");
			 }
		 });

		 Help_M_Pref.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		 Help_M_Pref.setBounds(459, 0, 25, 25);
		 Music.add(Help_M_Pref);

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
