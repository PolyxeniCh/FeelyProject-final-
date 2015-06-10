package FeelyGUI;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class EditPreferences {

	JPanel Edit_Pref = new JPanel();

	public EditPreferences(){
		Edit_Pref.setBackground(new Color(255, 250, 205));

		Edit_Pref.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Edit your Preferences/Interests");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 0, 210, 16);
		Edit_Pref.add(lblNewLabel_1);

		/*
		 * Κουμπί "Tv Series"
		 */
		JLabel TV = new JLabel("");
		TV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_TvSeries.png"));
				TV.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_TvSeries.png"));
				TV.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_TvSeries.png"));
				TV.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_TvSeries.png"));
				TV.setIcon(IH);
				
				HomeScreen.container.add(new TvSeriesPreferences().Tv_Series,"tv");
				HomeScreen.cd.show(HomeScreen.container, "tv");
			}
		});
		TV.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_TvSeries.png")));
		TV.setBounds(10, 59, 120, 25);
		Edit_Pref.add(TV);

		
		/*
		 * Κουμπί "Music"
		 */
		JLabel Music1 = new JLabel("");
		Music1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Music.png"));
				Music1.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_Music.png"));
				Music1.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_Music.png"));
				Music1.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Music.png"));
				Music1.setIcon(IH);
				HomeScreen.container.add(new MusicPreferences().Music,"music");
				HomeScreen.cd.show(HomeScreen.container, "music");
			}
		});
		Music1.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_Music.png")));
		Music1.setBounds(10, 112, 120, 25);
		Edit_Pref.add(Music1);

		
		/*
		 * Κουμπί "Books"
		 */
		JLabel Books1 = new JLabel("");
		Books1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Books.png"));
				Books1.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_Books.png"));
				Books1.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_Books.png"));
				Books1.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Books.png"));
				Books1.setIcon(IH);
				HomeScreen.container.add(new BookPreferences().Books,"books");
				HomeScreen.cd.show(HomeScreen.container, "books");
			}
		});
		Books1.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_Books.png")));
		Books1.setBounds(10, 165, 120, 25);
		Edit_Pref.add(Books1);

		
		/*
		 * Κουμπί "Destinations"
		 */
		JLabel Destinations1 = new JLabel("");
		Destinations1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Destinations.png"));
				Destinations1.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_Destinations.png"));
				Destinations1.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_Destinations.png"));
				Destinations1.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Destinations.png"));
				Destinations1.setIcon(IH);
				HomeScreen.container.add(new DestinationPreferences().Destinations,"dest");
				HomeScreen.cd.show(HomeScreen.container, "dest");
			}
		});
		Destinations1.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_Destinations.png")));
		Destinations1.setBounds(157, 59, 120, 25);
		Edit_Pref.add(Destinations1);

		
		/*
		 * Κουμπί "Movies"
		 */
		JLabel Movies1 = new JLabel("");
		Movies1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Movies.png"));
				Movies1.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_Movies.png"));
				Movies1.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_Movies.png"));
				Movies1.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Movies.png"));
				Movies1.setIcon(IH);
				HomeScreen.container.add(new MoviePreferences().Movies,"mov");
				HomeScreen.cd.show(HomeScreen.container, "mov");
			}
		});
		Movies1.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_Movies.png")));
		Movies1.setBounds(157, 112, 120, 25);
		Edit_Pref.add(Movies1);

		
		/*
		 * Κουμπί "Activities"
		 */
		JLabel Activities1 = new JLabel("");
		Activities1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Activities.png"));
				Activities1.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_Activities.png"));
				Activities1.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_Activities.png"));
				Activities1.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Activities.png"));
				Activities1.setIcon(IH);
				HomeScreen.container.add(new ActivityPreferences().Activities,"act");
				HomeScreen.cd.show(HomeScreen.container, "act");
			}
		});
		Activities1.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_Activities.png")));
		Activities1.setBounds(157, 165, 120, 25);
		Edit_Pref.add(Activities1);

		
		/*
		 * Κουμπί "Log Out"
		 */
		JLabel Log_Out_pref = new JLabel("");
		Log_Out_pref.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Hover.png"));
				Log_Out_pref.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Default.png"));
				Log_Out_pref.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Pressed.png"));
				Log_Out_pref.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Hover.png"));
				Log_Out_pref.setIcon(IH);
				HomeScreen.cd.show(HomeScreen.container, "ls");
			}
		});
		Log_Out_pref.setIcon(new ImageIcon(Main.class.getResource("/Images/Log_Out_Default.png")));
		Log_Out_pref.setBounds(386, 0, 32, 32);
		Edit_Pref.add(Log_Out_pref);

		
		/*
		 * Κουμπί "Help"
		 */
		JLabel Help1 = new JLabel("");
		Help1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help1.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help1.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help1.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help1.setIcon(IH);
				String Identifier = "ep";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		Help1.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help1.setBounds(459, 0, 25, 25);
		Edit_Pref.add(Help1);

		
		/*
		 * Κουμπί "Next"
		 */
		JLabel Next_Pref = new JLabel("");
		Next_Pref.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Next_Hover.png"));
				Next_Pref.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Next_Default.png"));
				Next_Pref.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Next_Pressed.png"));
				Next_Pref.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Next_Hover.png"));
				Next_Pref.setIcon(IH);
				HomeScreen.container.add(new MoodSelection().Mood,"m");
				HomeScreen.cd.show(HomeScreen.container, "m");
			}
		});
		Next_Pref.setIcon(new ImageIcon(Main.class.getResource("/Images/Next_Default.png")));
		Next_Pref.setBounds(385, 290, 40, 40);
		Edit_Pref.add(Next_Pref);



	}
}
