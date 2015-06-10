package FeelyGUI;

import Feely.*;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;

public class MoodSelection {

	JPanel Mood = new JPanel();

	JComboBox<String> moodBox = new JComboBox<String>();
	ArrayList<JCheckBox> checkboxList = new ArrayList<JCheckBox>();

	public MoodSelection(){
		Mood.setBackground(new Color(255, 250, 205));

		Mood.setLayout(null);
		JLabel lblIWouldLike = new JLabel("I would like you to suggest/show me:");
		lblIWouldLike.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblIWouldLike.setBounds(10, 41, 230, 27);
		Mood.add(lblIWouldLike);

		JCheckBox chckbxTvSeries = new JCheckBox("TV Series");
		chckbxTvSeries.setBackground(new Color(255, 250, 205));
		chckbxTvSeries.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		chckbxTvSeries.setBounds(20, 75, 119, 23);
		chckbxTvSeries.setEnabled(!new TvSeriesPreferences().noBoxChecked());
		checkboxList.add(chckbxTvSeries);
		Mood.add(chckbxTvSeries);

		JCheckBox chckbxMusic = new JCheckBox("Music");
		chckbxMusic.setBackground(new Color(255, 250, 205));
		chckbxMusic.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		chckbxMusic.setBounds(20, 101, 119, 23);
		chckbxMusic.setEnabled(!new MusicPreferences().noBoxChecked());
		checkboxList.add(chckbxMusic);
		Mood.add(chckbxMusic);

		JCheckBox chckbxMovies = new JCheckBox("Movies");
		chckbxMovies.setBackground(new Color(255, 250, 205));
		chckbxMovies.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		chckbxMovies.setBounds(20, 127, 119, 23);
		chckbxMovies.setEnabled(!new MoviePreferences().noBoxChecked());
		checkboxList.add(chckbxMovies);
		Mood.add(chckbxMovies);

		JCheckBox chckbxActivities = new JCheckBox("Activities");
		chckbxActivities.setBackground(new Color(255, 250, 205));
		chckbxActivities.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		chckbxActivities.setBounds(20, 153, 119, 23);
		chckbxActivities.setEnabled(!new ActivityPreferences().noBoxChecked());
		checkboxList.add(chckbxActivities);
		Mood.add(chckbxActivities);

		JCheckBox chckbxDestinations = new JCheckBox("Destinations");
		chckbxDestinations.setBackground(new Color(255, 250, 205));
		chckbxDestinations.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		chckbxDestinations.setBounds(20, 179, 119, 23);
		chckbxDestinations.setEnabled(!new DestinationPreferences().noBoxChecked());
		checkboxList.add(chckbxDestinations);
		Mood.add(chckbxDestinations);

		JCheckBox chckbxBooks = new JCheckBox("Books");
		chckbxBooks.setBackground(new Color(255, 250, 205));
		chckbxBooks.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		chckbxBooks.setBounds(20, 205, 119, 27);
		chckbxBooks.setEnabled(!new BookPreferences().noBoxChecked());
		checkboxList.add(chckbxBooks);
		Mood.add(chckbxBooks);

		moodBox.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		moodBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Lovestruck", "Happy", "Bored", "Sad", "Angry"}));
		moodBox.setToolTipText("");
		moodBox.setBounds(321, 124, 109, 28);
		moodBox.setSelectedIndex(2);
		Mood.add(moodBox);


		/*
		 * Κουμπί "Select All"
		 */
		JLabel select_all_mood = new JLabel("");
		select_all_mood.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Select_All_Hover.png"));
				select_all_mood.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Select_All_Default.png"));
				select_all_mood.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Select_All_Pressed.png"));
				select_all_mood.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Select_All_Hover.png"));
				select_all_mood.setIcon(IH);

				boolean flag = true;

				for (JCheckBox c: checkboxList){
					if (!c.isSelected() && c.isEnabled() && flag){
						flag = false;
					}
				}

				for (JCheckBox c: checkboxList){
					if (c.isEnabled()) {
						c.setSelected(!flag);
					}
				}

			}
		});


		/*
		 * Κουμπί "Back"
		 */
		JLabel back_mood = new JLabel("");
		back_mood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_mood.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_mood.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_mood.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_mood.setIcon(IH);

				UserManagement.getCurrentUser().setSuggestionList(new ArrayList<String>());

				moodBox.setSelectedIndex(2);
				HomeScreen.cd.show(HomeScreen.container, "ep");
			}
		});
		back_mood.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_mood.setBounds(319, 290, 40, 40);
		Mood.add(back_mood);


		/*
		 * Κουμπί "Next"
		 */
		JLabel next_mood = new JLabel("");
		next_mood.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Next_Hover.png"));
				next_mood.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Next_Default.png"));
				next_mood.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Next_Pressed.png"));
				next_mood.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Next_Hover.png"));
				next_mood.setIcon(IH);

				ArrayList<String> suggestionsTemp = new ArrayList<String>();

				for(JCheckBox c:checkboxList){
					if(c.isSelected()){
						suggestionsTemp.add(c.getText());
					}
				}

				if(!suggestionsTemp.isEmpty()){
					CategoryManagement.setCurrentMood(moodBox.getSelectedItem().toString());
					UserManagement.getCurrentUser().setSuggestionList(suggestionsTemp);

					HomeScreen.container.add(new Suggestions().Options,"o");
					HomeScreen.cd.show(HomeScreen.container, "o");
				}
				else
					JOptionPane.showMessageDialog(null, "Please select one Category!");
			}
		});
		next_mood.setIcon(new ImageIcon(Main.class.getResource("/Images/Next_Default.png")));
		next_mood.setBounds(385, 290, 40, 40);
		Mood.add(next_mood);


		/*
		 * Κουμπί "Log Out"
		 */
		JLabel Log_Out_Mood = new JLabel("");
		Log_Out_Mood.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Hover.png"));
				Log_Out_Mood.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Default.png"));
				Log_Out_Mood.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Pressed.png"));
				Log_Out_Mood.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Hover.png"));
				Log_Out_Mood.setIcon(IH);

				chckbxTvSeries.setSelected(false);
				chckbxMusic.setSelected(false);
				chckbxMovies.setSelected(false);
				chckbxBooks.setSelected(false);
				chckbxActivities.setSelected(false);
				chckbxDestinations.setSelected(false);

				HomeScreen.cd.show(HomeScreen.container, "ls");
			}
		});
		Log_Out_Mood.setIcon(new ImageIcon(Main.class.getResource("/Images/Log_Out_Default.png")));
		Log_Out_Mood.setBounds(386, 0, 32, 32);
		Mood.add(Log_Out_Mood);


		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_Mood = new JLabel("");
		Help_Mood.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_Mood.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_Mood.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_Mood.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_Mood.setIcon(IH);
				String Identifier = "m";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		Help_Mood.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_Mood.setBounds(459, 0, 25, 25);
		Mood.add(Help_Mood);

		select_all_mood.setIcon(new ImageIcon(Main.class.getResource("/Images/Select_All_Default.png")));
		select_all_mood.setBounds(30, 257, 80, 25);
		Mood.add(select_all_mood);

		JLabel lblChooseMood = new JLabel("Choose Mood");
		lblChooseMood.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChooseMood.setBounds(321, 81, 109, 14);
		Mood.add(lblChooseMood);
	}

}
