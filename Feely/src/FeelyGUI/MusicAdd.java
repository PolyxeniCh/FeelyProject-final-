package FeelyGUI;

import Feely.*;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.Color;

public class MusicAdd {
	
	JPanel Music_add_p = new JPanel();
	
	public MusicAdd(){
		Music_add_p.setBackground(new Color(255, 250, 205));
		
		Music_add_p.setLayout(null);
		
		JLabel lblAddingStuffToMusic = new JLabel("Adding Stuff to: Music");
		lblAddingStuffToMusic.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddingStuffToMusic.setBounds(10, 0, 194, 22);
		Music_add_p.add(lblAddingStuffToMusic);
		
		JTabbedPane musicTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		musicTabbedPane.setBounds(10, 44, 356, 219);
		Music_add_p.add(musicTabbedPane);
		
		JPanel addTitlePanel = new JPanel();
		musicTabbedPane.addTab("Title", null, addTitlePanel, null);
		addTitlePanel.setLayout(null);
		
		JTextField txtSongTitle = new JTextField();
		txtSongTitle.setText("Song title");
		txtSongTitle.setColumns(20);
		txtSongTitle.setBounds(10, 68, 157, 20);
		addTitlePanel.add(txtSongTitle);
		
		JPanel addArtistPanel = new JPanel();
		musicTabbedPane.addTab("Artist", null, addArtistPanel, null);
		addArtistPanel.setLayout(null);
		
		JTextField txtArtist = new JTextField();
		txtArtist.setText("Artist name");
		txtArtist.setColumns(20);
		txtArtist.setBounds(10, 68, 157, 20);
		addArtistPanel.add(txtArtist);
		
		JPanel songLinkPanel = new JPanel();
		musicTabbedPane.addTab("Song's Link", null, songLinkPanel, null);
		songLinkPanel.setLayout(null);
		
		JTextField txtSongLink = new JTextField();
		txtSongLink.setText("Link to the Song");
		txtSongLink.setColumns(20);
		txtSongLink.setBounds(10, 68, 157, 20);
		songLinkPanel.add(txtSongLink);
		
		JPanel addGenrePanel = new JPanel();
		musicTabbedPane.addTab("Genre", null, addGenrePanel, null);
		addGenrePanel.setLayout(null);
		
		ButtonGroup musicGenreButtonGroup = new ButtonGroup();
		Box musicGenreBox = Box.createVerticalBox();
		ArrayList<JRadioButton> radioButtonList = new ArrayList<JRadioButton>();
		
		for(int i=0 ; i<CategoryManagement.getMusicgenrematrix().length ; i++){
			JRadioButton radioButton = new JRadioButton(CategoryManagement.getMusicgenrematrix()[i].toString());
			musicGenreButtonGroup.add(radioButton);
			radioButtonList.add(radioButton);
			musicGenreBox.add(radioButton);
		}
		
		JScrollPane musicGenreScrollPane = new JScrollPane(musicGenreBox);
		musicGenreScrollPane.setBounds(0, 0, 351, 191);
		addGenrePanel.add(musicGenreScrollPane);
		
		JLabel moodLabel = new JLabel("Choose Mood");
		moodLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		moodLabel.setBounds(375, 100, 109, 14);
		Music_add_p.add(moodLabel);
		
		JComboBox<String> moodComboBox = new JComboBox<String>();
		moodComboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		moodComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Lovestruck", "Happy", "Bored", "Sad", "Angry"}));
		moodComboBox.setToolTipText("");
		moodComboBox.setBounds(375, 125, 109, 28);
		moodComboBox.setSelectedIndex(2);
		Music_add_p.add(moodComboBox);
		
		
		/*
		 * Κουμπί "Save"
		 */
		JLabel save_music_add = new JLabel("");
		save_music_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_music_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				save_music_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				save_music_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_music_add.setIcon(IH);
				
				if( !(txtSongTitle.getText().equals("") || txtSongTitle.getText().equals("Song title"))
						&& !(txtArtist.getText().equals("") || txtArtist.getText().equals("Artist name"))
						&& !(txtSongLink.getText().equals("") || txtSongLink.getText().equals("Link to the Song"))
						&& !musicGenreButtonGroup.isSelected(null)) {

					ArrayList<String> genre = new ArrayList<String>();
					for(JRadioButton r : radioButtonList){
						if(r.isSelected()){
							genre.add(r.getText());
						}
					}
					ArrayList<String> mood = new ArrayList<String>();
					mood.add(moodComboBox.getSelectedItem().toString());
					
					boolean musicExists = false;
					
					for (Music musicTitle : CategoryManagement.getMusicList()) {
						if (musicTitle.getTitle().equalsIgnoreCase(txtSongTitle.getText())) {
							JOptionPane.showMessageDialog(null, "This song already exists!");
							musicExists = true;
							break;
						}
					}
					
					if (!musicExists) {
						CategoryManagement.addNewMusic(txtSongTitle.getText(), txtSongLink.getText(), txtArtist.getText(), genre, mood);
						CategoryManagement.serialization();
						JOptionPane.showMessageDialog(null, "Song successfully added!");
						HomeScreen.cd.show(HomeScreen.container, "add");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill in all the necessary fields!");
				}
				
			}
		});
		save_music_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		save_music_add.setBounds(398, 300, 60, 25);
		Music_add_p.add(save_music_add);
		
		
		/*
		 * Κουμπί "Back"
		 */
		JLabel back_music_add = new JLabel("");
		back_music_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_music_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_music_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_music_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_music_add.setIcon(IH);
				HomeScreen.cd.show(HomeScreen.container, "add");
			}
		});
		back_music_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_music_add.setBounds(319, 290, 40, 40);
		Music_add_p.add(back_music_add);
		
		
		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_music_add = new JLabel("");
		Help_music_add.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_music_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_music_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_music_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_music_add.setIcon(IH);
				String Identifier = "music_a";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		Help_music_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_music_add.setBounds(459, 0, 25, 25);
		Music_add_p.add(Help_music_add);
		
	}

}
