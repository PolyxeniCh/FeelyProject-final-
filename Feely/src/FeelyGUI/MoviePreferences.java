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

public class MoviePreferences {

	JPanel Movies = new JPanel();

	private ArrayList<JCheckBox> checkboxList = new ArrayList<JCheckBox>();
	private Box genre_mov = Box.createVerticalBox();

	public MoviePreferences(){
		Movies.setBackground(new Color(255, 250, 205));

		Movies.setLayout(null);
		JLabel Movies2 = new JLabel("Movies");
		Movies2.setFont(new Font("Tahoma", Font.BOLD, 13));
		Movies2.setBounds(10, 11, 98, 22);
		Movies.add(Movies2);


		/*
		 * Ενεργοποίηση των αντίστοιχων checkbox, ανάλογα με τις προτιμήσεις του χρήστη.
		 */
		for(int i=0;i<CategoryManagement.getTvseriesMoviegenrematrix().length;i++){

			JCheckBox j = new JCheckBox(CategoryManagement.getTvseriesMoviegenrematrix()[i]);
			checkboxList.add(j);

			for(String s:UserManagement.getCurrentUser().getMovieGenreList()) {
				if(s.equals(j.getText()))
					j.setSelected(true);
			}
			genre_mov.add(j);        	
		}

		JScrollPane scrollPane_2 = new JScrollPane(genre_mov);
		scrollPane_2.setBounds(20, 39, 213, 281);
		Movies.add(scrollPane_2);


		/*
		 * Κουμπί "Back"
		 */
		JLabel back_movies = new JLabel("");
		back_movies.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_movies.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_movies.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_movies.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_movies.setIcon(IH);
				
				HomeScreen.cd.show(HomeScreen.container, "ep");
			}
		});

		back_movies.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_movies.setBounds(319, 290, 40, 40);
		Movies.add(back_movies);


		/*
		 * Κουμπί "Save"
		 */
		JLabel save_movies = new JLabel("");
		save_movies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_movies.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				save_movies.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				save_movies.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_movies.setIcon(IH);
				
				ArrayList<String> Movies_genre = new ArrayList<String>();

				for(JCheckBox c : checkboxList){
					if(c.isSelected()){
						Movies_genre.add(c.getText());
					}
				}

				UserManagement.getCurrentUser().setMovieGenreList(Movies_genre);;
				UserManagement.serialization();
				
				HomeScreen.cd.show(HomeScreen.container, "ep");
			}
		});

		save_movies.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		save_movies.setBounds(398, 300, 60, 25);
		Movies.add(save_movies);


		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_Mov_Pref = new JLabel("");
		Help_Mov_Pref.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_Mov_Pref.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_Mov_Pref.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_Mov_Pref.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_Mov_Pref.setIcon(IH);
				String Identifier = "Movies";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});

		Help_Mov_Pref.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_Mov_Pref.setBounds(459, 0, 25, 25);
		Movies.add(Help_Mov_Pref);
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
