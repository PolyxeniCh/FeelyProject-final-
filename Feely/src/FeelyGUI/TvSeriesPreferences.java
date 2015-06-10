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

public class TvSeriesPreferences {

	protected JPanel Tv_Series = new JPanel();

	private ArrayList<JCheckBox> checkboxList = new ArrayList<JCheckBox>();
	private Box genre_tv = Box.createVerticalBox();

	public TvSeriesPreferences(){
		Tv_Series.setBackground(new Color(255, 250, 205));

		Tv_Series.setLayout(null);
		JLabel TvSeries = new JLabel("Tv Series");
		TvSeries.setFont(new Font("Tahoma", Font.BOLD, 13));
		TvSeries.setBounds(10, 11, 98, 22);
		Tv_Series.add(TvSeries);


		/*
		 * Ενεργοποίηση των αντίστοιχων checkbox, ανάλογα με τις προτιμήσεις του χρήστη.
		 */
		for(int i=0;i<CategoryManagement.getTvseriesMoviegenrematrix().length;i++){

			JCheckBox j = new JCheckBox(CategoryManagement.getTvseriesMoviegenrematrix()[i]);
			checkboxList.add(j);

			for(String s:UserManagement.getCurrentUser().getTvSeriesGenreList()) {
				if(s.equals(j.getText()))
					j.setSelected(true);
			}
			genre_tv.add(j);
		}

		JScrollPane scrollPane = new JScrollPane(genre_tv);
		scrollPane.setBounds(20, 39, 213, 281);
		Tv_Series.add(scrollPane);


		/*
		 * Κουμπί "Back"
		 */
		JLabel back_tv = new JLabel("");
		back_tv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_tv.setIcon(IH);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_tv.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_tv.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_tv.setIcon(IH);

				/*
				genre_tv.removeAll();
				for(JCheckBox c : checkboxList){
					c.setSelected(false);
					for(String s:UserManagement.getCurrentUser().getTvSeriesGenreList()){
						if(s.equals(c.getText()))
							c.setSelected(true);
					}
					genre_tv.add(c);
				}*/

				HomeScreen.cd.show(HomeScreen.container, "ep");
			}
		});

		back_tv.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_tv.setBounds(319, 290, 40, 40);
		Tv_Series.add(back_tv);


		/*
		 * Κουμπί "Save"
		 */
		JLabel save_tv = new JLabel("");
		save_tv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_tv.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				save_tv.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				save_tv.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_tv.setIcon(IH);

				ArrayList<String> Tv_Series_genre = new ArrayList<String>();

				//Tv_Series_genre.clear();
				for(JCheckBox c : checkboxList){
					if(c.isSelected()){
						Tv_Series_genre.add(c.getText());
					}
				}

				UserManagement.getCurrentUser().setTvSeriesGenreList(Tv_Series_genre);
				UserManagement.serialization();

				HomeScreen.cd.show(HomeScreen.container, "ep");
			}
		});

		save_tv.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		save_tv.setBounds(398, 300, 60, 25);
		Tv_Series.add(save_tv);


		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_T_Pref = new JLabel("");
		Help_T_Pref.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_T_Pref.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_T_Pref.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_T_Pref.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_T_Pref.setIcon(IH);
				String Identifier = "Tv";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		Help_T_Pref.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_T_Pref.setBounds(459, 0, 25, 25);
		Tv_Series.add(Help_T_Pref);

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
