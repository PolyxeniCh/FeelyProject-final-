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

public class TvSeriesAdd {
	
	JPanel Tv_Series_add_p = new JPanel();

	public TvSeriesAdd(){
		Tv_Series_add_p.setBackground(new Color(255, 250, 205));
		
		Tv_Series_add_p.setLayout(null);
		
		JLabel lblAddingStuffToTvSeries = new JLabel("Adding Stuff to: Tv Series");
		lblAddingStuffToTvSeries.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddingStuffToTvSeries.setBounds(10, 0, 194, 22);
		Tv_Series_add_p.add(lblAddingStuffToTvSeries);
		
		JTabbedPane tvSeriesTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tvSeriesTabbedPane.setBounds(10, 44, 356, 219);
		Tv_Series_add_p.add(tvSeriesTabbedPane);

		JPanel addTitlePanel = new JPanel();
		tvSeriesTabbedPane.addTab("Title", null, addTitlePanel, null);
		addTitlePanel.setLayout(null);

		JTextField txtTvSeriesTitle = new JTextField();
		txtTvSeriesTitle.setText("Tv Series title");
		txtTvSeriesTitle.setColumns(20);
		txtTvSeriesTitle.setBounds(10, 68, 157, 20);
		addTitlePanel.add(txtTvSeriesTitle);

		JPanel addTrailerLinkPanel = new JPanel();
		tvSeriesTabbedPane.addTab("Trailer", null, addTrailerLinkPanel, null);
		addTrailerLinkPanel.setLayout(null);

		JTextField txtTrailerLink = new JTextField();
		txtTrailerLink.setText("Trailer link");
		txtTrailerLink.setColumns(20);
		txtTrailerLink.setBounds(10, 68, 157, 20);
		addTrailerLinkPanel.add(txtTrailerLink);
		
		JPanel addIMDbLinkPanel = new JPanel();
		tvSeriesTabbedPane.addTab("IMDb", null, addIMDbLinkPanel, null);
		addIMDbLinkPanel.setLayout(null);

		JTextField txtLinkToIMDb = new JTextField();
		txtLinkToIMDb.setText("Tv Series link in IMDb");
		txtLinkToIMDb.setColumns(20);
		txtLinkToIMDb.setBounds(10, 68, 157, 20);
		addIMDbLinkPanel.add(txtLinkToIMDb);

		JPanel addGenrePanel = new JPanel();
		tvSeriesTabbedPane.addTab("Genre", null, addGenrePanel, null);
		addGenrePanel.setLayout(null);
		
		ButtonGroup tvSeriesGenreButtonGroup = new ButtonGroup();
		Box tvSeriesGenreBox = Box.createVerticalBox();
		ArrayList<JRadioButton> radioButtonList = new ArrayList<JRadioButton>();
		
		for(int i=0 ; i<CategoryManagement.getTvseriesMoviegenrematrix().length ; i++){
			JRadioButton radioButton = new JRadioButton(CategoryManagement.getTvseriesMoviegenrematrix()[i].toString());
			tvSeriesGenreButtonGroup.add(radioButton);
			radioButtonList.add(radioButton);
			tvSeriesGenreBox.add(radioButton);
		}

		JScrollPane tvGenreScrollPane = new JScrollPane(tvSeriesGenreBox);
		tvGenreScrollPane.setBounds(0, 0, 351, 191);
		addGenrePanel.add(tvGenreScrollPane);

		JLabel moodLabel = new JLabel("Choose Mood");
		moodLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		moodLabel.setBounds(375, 100, 109, 14);
		Tv_Series_add_p.add(moodLabel);
		
		JComboBox<String> moodComboBox = new JComboBox<String>();
		moodComboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		moodComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Lovestruck", "Happy", "Bored", "Sad", "Angry"}));
		moodComboBox.setToolTipText("");
		moodComboBox.setBounds(375, 125, 109, 28);
		moodComboBox.setSelectedIndex(2);
		Tv_Series_add_p.add(moodComboBox);


		/*
		 * Κουμπί "Save"
		 */
		JLabel save_tv_add = new JLabel("");
		save_tv_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_tv_add.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				save_tv_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				save_tv_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_tv_add.setIcon(IH);
				
				if( !(txtTvSeriesTitle.getText().equals("") || txtTvSeriesTitle.getText().equals("Tv Series title"))
						&& !(txtTrailerLink.getText().equals("") || txtTrailerLink.getText().equals("Trailer link"))
						&& !(txtLinkToIMDb.getText().equals("") || txtLinkToIMDb.getText().equals("Tv Series link in IMDb"))
						&& !tvSeriesGenreButtonGroup.isSelected(null)) {

					ArrayList<String> genre = new ArrayList<String>();
					for(JRadioButton r : radioButtonList){
						if(r.isSelected()){
							genre.add(r.getText());
						}
					}
					ArrayList<String> mood = new ArrayList<String>();
					mood.add(moodComboBox.getSelectedItem().toString());
					
					boolean tvSeriesExists = false;
					
					for (TvSeries tvSeriesTitle : CategoryManagement.getTvSeriesList()) {
						if (tvSeriesTitle.getTitle().equalsIgnoreCase(txtTvSeriesTitle.getText())) {
							JOptionPane.showMessageDialog(null, "This TV series already exists!");
							tvSeriesExists = true;
							break;
						}
					}
					
					if (!tvSeriesExists) {
						CategoryManagement.addNewTvSeries(txtTvSeriesTitle.getText(), txtTrailerLink.getText(), txtLinkToIMDb.getText(), genre, mood);
						CategoryManagement.serialization();
						JOptionPane.showMessageDialog(null, "TV series successfully added!");
						HomeScreen.cd.show(HomeScreen.container, "add");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill in all the necessary fields!");
				}
				
			}
		});
		save_tv_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		save_tv_add.setBounds(398, 300, 60, 25);
		Tv_Series_add_p.add(save_tv_add);


		/*
		 * Κουμπί "Back"
		 */
		JLabel back_tv_add = new JLabel("");
		back_tv_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_tv_add.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_tv_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_tv_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_tv_add.setIcon(IH);
				HomeScreen.cd.show(HomeScreen.container, "add");
			}
		});
		back_tv_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_tv_add.setBounds(319, 290, 40, 40);
		Tv_Series_add_p.add(back_tv_add);


		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_tv_add = new JLabel("");
		Help_tv_add.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_tv_add.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_tv_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_tv_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_tv_add.setIcon(IH);
				String Identifier = "tv_a";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		Help_tv_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_tv_add.setBounds(459, 0, 25, 25);
		Tv_Series_add_p.add(Help_tv_add);
	}

}
