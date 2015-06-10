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

public class MovieAdd {

	JPanel Movies_add_p = new JPanel();

	public MovieAdd(){
		Movies_add_p.setBackground(new Color(255, 250, 205));

		Movies_add_p.setLayout(null);

		JLabel lblAddingStuffToMovies = new JLabel("Adding Stuff to: Movies");
		lblAddingStuffToMovies.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddingStuffToMovies.setBounds(10, 0, 194, 22);
		Movies_add_p.add(lblAddingStuffToMovies);

		JTabbedPane moviesTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		moviesTabbedPane.setBounds(10, 44, 356, 219);
		Movies_add_p.add(moviesTabbedPane);

		JPanel addTitlePanel = new JPanel();
		moviesTabbedPane.addTab("Title", null, addTitlePanel, null);
		addTitlePanel.setLayout(null);

		JTextField txtMovieTitle = new JTextField();
		txtMovieTitle.setText("Movie title");
		txtMovieTitle.setColumns(20);
		txtMovieTitle.setBounds(10, 68, 157, 20);
		addTitlePanel.add(txtMovieTitle);

		JPanel addTrailerLinkPanel = new JPanel();
		moviesTabbedPane.addTab("Trailer", null, addTrailerLinkPanel, null);
		addTrailerLinkPanel.setLayout(null);

		JTextField txtTrailerLink = new JTextField();
		txtTrailerLink.setText("Trailer link");
		txtTrailerLink.setColumns(20);
		txtTrailerLink.setBounds(10, 68, 157, 20);
		addTrailerLinkPanel.add(txtTrailerLink);

		JPanel addIMDbLinkPanel = new JPanel();
		moviesTabbedPane.addTab("IMDB", null, addIMDbLinkPanel, null);
		addIMDbLinkPanel.setLayout(null);

		JTextField txtLinkToIMDb = new JTextField();
		txtLinkToIMDb.setText("Movie link in IMDb");
		txtLinkToIMDb.setColumns(20);
		txtLinkToIMDb.setBounds(10, 68, 157, 20);
		addIMDbLinkPanel.add(txtLinkToIMDb);

		JPanel addGenrePanel = new JPanel();
		moviesTabbedPane.addTab("Genre", null, addGenrePanel, null);
		addGenrePanel.setLayout(null);

		ButtonGroup movieGenreButtonGroup = new ButtonGroup();
		Box movieGenreBox = Box.createVerticalBox();
		ArrayList<JRadioButton> radioButtonList = new ArrayList<JRadioButton>();

		for(int i=0 ; i<CategoryManagement.getTvseriesMoviegenrematrix().length ; i++){
			JRadioButton radioButton = new JRadioButton(CategoryManagement.getTvseriesMoviegenrematrix()[i].toString());
			movieGenreButtonGroup.add(radioButton);
			radioButtonList.add(radioButton);
			movieGenreBox.add(radioButton);
		}

		JScrollPane movieGenreScrollPane = new JScrollPane(movieGenreBox);
		movieGenreScrollPane.setBounds(0, 0, 351, 191);
		addGenrePanel.add(movieGenreScrollPane);

		JLabel moodLabel = new JLabel("Choose Mood");
		moodLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		moodLabel.setBounds(375, 100, 109, 14);
		Movies_add_p.add(moodLabel);

		JComboBox<String> moodComboBox = new JComboBox<String>();
		moodComboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		moodComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Lovestruck", "Happy", "Bored", "Sad", "Angry"}));
		moodComboBox.setToolTipText("");
		moodComboBox.setBounds(375, 125, 109, 28);
		moodComboBox.setSelectedIndex(2);
		Movies_add_p.add(moodComboBox);


		/*
		 * Κουμπί "Save"
		 */
		JLabel save_mov_add = new JLabel("");
		save_mov_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_mov_add.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				save_mov_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				save_mov_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_mov_add.setIcon(IH);

				if( !(txtMovieTitle.getText().equals("") || txtMovieTitle.getText().equals("Movie title"))
						&& !(txtTrailerLink.getText().equals("") || txtTrailerLink.getText().equals("Trailer link"))
						&& !(txtLinkToIMDb.getText().equals("") || txtLinkToIMDb.getText().equals("Movie link in IMDb"))
						&& !movieGenreButtonGroup.isSelected(null)) {

					ArrayList<String> genre = new ArrayList<String>();
					for(JRadioButton r : radioButtonList){
						if(r.isSelected()){
							genre.add(r.getText());
						}
					}
					ArrayList<String> mood = new ArrayList<String>();
					mood.add(moodComboBox.getSelectedItem().toString());
					
					boolean movieExists = false;
					
					for (Movie movieTitle : CategoryManagement.getMovieList()) {
						if (movieTitle.getTitle().equalsIgnoreCase(txtMovieTitle.getText())) {
							JOptionPane.showMessageDialog(null, "This movie already exists!");
							movieExists = true;
							break;
						}
					}
					
					if (!movieExists) {
						CategoryManagement.addNewMovie(txtMovieTitle.getText(), txtTrailerLink.getText(), txtLinkToIMDb.getText(), genre, mood);
						CategoryManagement.serialization();
						JOptionPane.showMessageDialog(null, "Movie successfully added!");
						HomeScreen.cd.show(HomeScreen.container, "add");
					}

				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill in all the necessary fields!");
				}

			}
		});
		save_mov_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		save_mov_add.setBounds(398, 300, 60, 25);
		Movies_add_p.add(save_mov_add);


		/*
		 * Κουμπί "Back"
		 */
		JLabel back_mov_add = new JLabel("");
		back_mov_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_mov_add.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_mov_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_mov_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_mov_add.setIcon(IH);
				HomeScreen.cd.show(HomeScreen.container, "add");
			}
		});
		back_mov_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_mov_add.setBounds(319, 290, 40, 40);
		Movies_add_p.add(back_mov_add);


		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_mov_add = new JLabel("");
		Help_mov_add.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_mov_add.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_mov_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_mov_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_mov_add.setIcon(IH);
				String Identifier = "mov_a";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		Help_mov_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_mov_add.setBounds(459, 0, 25, 25);
		Movies_add_p.add(Help_mov_add);

	}

}
