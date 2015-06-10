package FeelyGUI;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class AddStuff {
	
	JPanel Add_Stuff = new JPanel();
	
	public AddStuff(){
		Add_Stuff.setBackground(new Color(255, 250, 205));
		Add_Stuff.setLayout(null);
		JLabel lblNewLabel_2 = new JLabel("Choose Category to Add Stuff");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 0, 188, 15);
		Add_Stuff.add(lblNewLabel_2);
		
		/*
		 * Κουμπί "Tv Series"
		 */
		JLabel Tv_series_add_s = new JLabel("");
		Tv_series_add_s.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_TvSeries.png"));
				Tv_series_add_s.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_TvSeries.png"));
				Tv_series_add_s.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_TvSeries.png"));
				Tv_series_add_s.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_TvSeries.png"));
				Tv_series_add_s.setIcon(IH);
				HomeScreen.container.add(new TvSeriesAdd().Tv_Series_add_p,"tv_a");
				HomeScreen.cd.show(HomeScreen.container, "tv_a");
			}
		});
		Tv_series_add_s.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_TvSeries.png")));
		Tv_series_add_s.setBounds(10, 59, 120, 25);
		Add_Stuff.add(Tv_series_add_s);
		
		
		/*
		 * Κουμπί "Music"
		 */
		JLabel Music_add_s1 = new JLabel("");
		Music_add_s1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Music.png"));
				Music_add_s1.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_Music.png"));
				Music_add_s1.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_Music.png"));
				Music_add_s1.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Music.png"));
				Music_add_s1.setIcon(IH);
				HomeScreen.container.add(new MusicAdd().Music_add_p,"music_a");
				HomeScreen.cd.show(HomeScreen.container, "music_a");
			}
		});
		Music_add_s1.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_Music.png")));
		Music_add_s1.setBounds(10, 112, 120, 25);
		Add_Stuff.add(Music_add_s1);
		
		
		/*
		 * Κουμπί "Books"
		 */
		JLabel Books_add_s1 = new JLabel("");
		Books_add_s1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Books.png"));
				Books_add_s1.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_Books.png"));
				Books_add_s1.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_Books.png"));
				Books_add_s1.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Books.png"));
				Books_add_s1.setIcon(IH);
				HomeScreen.container.add(new BookAdd().Books_add_p,"books_a");
				HomeScreen.cd.show(HomeScreen.container, "books_a");
			}
		});
		Books_add_s1.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_Books.png")));
		Books_add_s1.setBounds(10, 165, 120, 25);
		Add_Stuff.add(Books_add_s1);
		
		
		/*
		 * Κουμπί "Destinations"
		 */
		JLabel Destinations_add_s1 = new JLabel("");
		Destinations_add_s1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Destinations.png"));
				Destinations_add_s1.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_Destinations.png"));
				Destinations_add_s1.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_Destinations.png"));
				Destinations_add_s1.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Destinations.png"));
				Destinations_add_s1.setIcon(IH);
				HomeScreen.container.add(new DestinationAdd().Destinations_add_p,"dest_a");
				HomeScreen.cd.show(HomeScreen.container, "dest_a");
			}
		});
		Destinations_add_s1.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_Destinations.png")));
		Destinations_add_s1.setBounds(157, 59, 120, 25);
		Add_Stuff.add(Destinations_add_s1);
		
		
		/*
		 * Κουμπί "Movies"
		 */
		JLabel Movies_add_s1 = new JLabel("");
		Movies_add_s1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Movies.png"));
				Movies_add_s1.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_Movies.png"));
				Movies_add_s1.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_Movies.png"));
				Movies_add_s1.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Movies.png"));
				Movies_add_s1.setIcon(IH);
				HomeScreen.container.add(new MovieAdd().Movies_add_p,"mov_a");
				HomeScreen.cd.show(HomeScreen.container, "mov_a");
			}
		});
		Movies_add_s1.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_Movies.png")));
		Movies_add_s1.setBounds(157, 112, 120, 25);
		Add_Stuff.add(Movies_add_s1);
		
		
		/*
		 * Κουμπί "Actvities"
		 */
		JLabel Activities_add_s1 = new JLabel("");
		Activities_add_s1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Activities.png"));
				Activities_add_s1.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Default_Activities.png"));
				Activities_add_s1.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Pressed_Activities.png"));
				Activities_add_s1.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Pref_Hover_Activities.png"));
				Activities_add_s1.setIcon(IH);
				HomeScreen.container.add(new ActivityAdd().Activities_add_p,"act_a");
				HomeScreen.cd.show(HomeScreen.container, "act_a");
			}
		});
		Activities_add_s1.setIcon(new ImageIcon(Main.class.getResource("/Images/Pref_Default_Activities.png")));
		Activities_add_s1.setBounds(157, 165, 120, 25);
		Add_Stuff.add(Activities_add_s1);
		
		
		/*
		 * Κουμπί "Back"
		 */
		JLabel back_add = new JLabel("");
		back_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_add.setIcon(IH);
				HomeScreen.cd.show(HomeScreen.container, "o");
			}
		});
		back_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_add.setBounds(319, 290, 40, 40);
		Add_Stuff.add(back_add);
		
		
		/*
		 * Κουμπί "Help"
		 */
		JLabel help_add = new JLabel("");
		help_add.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				help_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				help_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				help_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				help_add.setIcon(IH);
				String Identifier = "add";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		help_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		help_add.setBounds(459, 0, 25, 25);
		Add_Stuff.add(help_add);
		
		
		/*
		 * Κουμπί "Log Out"
		 */
		JLabel Log_Out_add = new JLabel("");
		Log_Out_add.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Hover.png"));
				Log_Out_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Default.png"));
				Log_Out_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Pressed.png"));
				Log_Out_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Hover.png"));
				Log_Out_add.setIcon(IH);
				HomeScreen.cd.show(HomeScreen.container, "ls");
			}
		});
		Log_Out_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Log_Out_Default.png")));
		Log_Out_add.setBounds(386, 0, 32, 32);
		Add_Stuff.add(Log_Out_add);
		
	}

}
