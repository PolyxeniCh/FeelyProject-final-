package FeelyGUI;

import Feely.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.Component;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Color;

public class Suggestions {

	JPanel Options = new JPanel();

	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	public Suggestions(){

		tabbedPane.removeAll();
		Options.setBackground(new Color(255, 250, 205));
		Options.setLayout(null);
		tabbedPane.setBounds(10, 44, 464, 244);
		Options.add(tabbedPane);


		for(String s:UserManagement.getCurrentUser().getSuggestionList()){

			if(s.equals("TV Series")){

				JPanel Tv_Series_O = new JPanel();

				DefaultTableModel tvSeriesModel = new DefaultTableModel();

				// Create a couple of columns 
				tvSeriesModel.addColumn("Title"); 
				tvSeriesModel.addColumn("Series Trailer");
				tvSeriesModel.addColumn("Series IMDb");
				tvSeriesModel.addColumn("Genre");
				tvSeriesModel.addColumn("Views");

				// Append a row
				for(TvSeries t : CategoryManagement.recommendTvSeries(UserManagement.getCurrentUser().getTvSeriesGenreList())){

					String title = t.getTitle();
					JButton linkButton = new JButton();
					JButton imdbButton = new JButton();
					String genre = "";
					if(!t.getGenre().isEmpty()){
						genre = t.getGenre().get(0);
						for(int i=1 ; i<t.getGenre().size() ; i++){
							genre = genre + ", " + t.getGenre().get(i);
						}
					}
					int views = t.getViews();
					tvSeriesModel.addRow(new Object[]{ title, linkButton, imdbButton, genre, views});

				}
				
				JTable tvSeriesTable = new JTable(tvSeriesModel);
				
				tvSeriesTable.getColumn("Title").setPreferredWidth(150);
				tvSeriesTable.getColumn("Views").setPreferredWidth(35);
				tvSeriesTable.setRowSelectionAllowed(false);

				tvSeriesTable.getColumn("Series Trailer").setCellRenderer(new ButtonRenderer());
				tvSeriesTable.getColumn("Series Trailer").setCellEditor(new ButtonEditor(new JCheckBox()));

				tvSeriesTable.getColumn("Series IMDb").setCellRenderer(new ButtonRenderer());
				tvSeriesTable.getColumn("Series IMDb").setCellEditor(new ButtonEditor(new JCheckBox()));

				tvSeriesTable.addMouseListener(new JTableTvSeriesButtonMouseListener(tvSeriesTable));

				JScrollPane Tv_ScrollPane = new JScrollPane(tvSeriesTable);
				Tv_ScrollPane.setBounds(0, 0, 459, 216);
				Tv_Series_O.add(Tv_ScrollPane);
				Tv_Series_O.setLayout(null);

				tabbedPane.addTab("TV Series", null, Tv_Series_O, null);

			}
			else if(s.equals("Music")){

				JPanel Music_O = new JPanel();

				DefaultTableModel musicModel = new DefaultTableModel(); 

				// Create a couple of columns 
				musicModel.addColumn("Title"); 
				musicModel.addColumn("Artist");
				musicModel.addColumn("Song Link");
				musicModel.addColumn("Genre");
				musicModel.addColumn("Views"); 

				// Append a row
				for(Music t : CategoryManagement.recommendMusic(UserManagement.getCurrentUser().getMusicGenreList())){
					String title = t.getTitle();
					String artist = t.getArtist();
					String link = t.getLink();
					String genre = "";
					if(!t.getGenre().isEmpty()){
						genre = t.getGenre().get(0);
						for(int i=1 ; i<t.getGenre().size() ; i++){
							genre = genre + ", " + t.getGenre().get(i);
						}
					}
					int views = t.getViews();
					musicModel.addRow(new Object[]{ title, artist, link, genre, views});
				}

				JTable musicTable = new JTable(musicModel);
				
				musicTable.getColumn("Title").setPreferredWidth(120);
				musicTable.getColumn("Views").setPreferredWidth(35);
				musicTable.setRowSelectionAllowed(false);
				
				musicTable.getColumn("Song Link").setCellRenderer(new ButtonRenderer());
				musicTable.getColumn("Song Link").setCellEditor(new ButtonEditor(new JCheckBox()));

				musicTable.addMouseListener(new JTableMusicButtonMouseListener(musicTable));

				JScrollPane Music_ScrollPane = new JScrollPane(musicTable);
				Music_ScrollPane.setBounds(0, 0, 459, 216);
				Music_O.add(Music_ScrollPane);
				Music_O.setLayout(null);

				tabbedPane.addTab("Music", null, Music_O, null);

			}
			else if(s.equals("Movies")) {

				JPanel Movies_O = new JPanel();

				DefaultTableModel moviesModel = new DefaultTableModel(); 

				// Create a couple of columns 
				moviesModel.addColumn("Title"); 
				moviesModel.addColumn("Movie Trailer");
				moviesModel.addColumn("Movie IMDb");
				moviesModel.addColumn("Genre");
				moviesModel.addColumn("Views"); 

				// Append a row
				for(Movie t : CategoryManagement.recommendMovie(UserManagement.getCurrentUser().getMovieGenreList())){
					String title = t.getTitle();
					JButton linkButton = new JButton();
					JButton imdbButton = new JButton();
					String genre = "";
					if(!t.getGenre().isEmpty()){
						genre = t.getGenre().get(0);
						for(int i=1 ; i<t.getGenre().size() ; i++){
							genre = genre + ", " + t.getGenre().get(i);
						}
					}
					int views = t.getViews();
					moviesModel.addRow(new Object[]{ title, linkButton, imdbButton, genre, views});
				}

				JTable moviesTable = new JTable(moviesModel);
				
				moviesTable.getColumn("Title").setPreferredWidth(150);
				moviesTable.getColumn("Views").setPreferredWidth(35);
				moviesTable.setRowSelectionAllowed(false);

				moviesTable.getColumn("Movie Trailer").setCellRenderer(new ButtonRenderer());
				moviesTable.getColumn("Movie Trailer").setCellEditor(new ButtonEditor(new JCheckBox()));

				moviesTable.getColumn("Movie IMDb").setCellRenderer(new ButtonRenderer());
				moviesTable.getColumn("Movie IMDb").setCellEditor(new ButtonEditor(new JCheckBox()));

				moviesTable.addMouseListener(new JTableMovieButtonMouseListener(moviesTable));

				JScrollPane Movies_ScrollPane = new JScrollPane(moviesTable);
				Movies_ScrollPane.setBounds(0, 0, 459, 216);
				Movies_O.add(Movies_ScrollPane);
				Movies_O.setLayout(null);

				tabbedPane.addTab("Movies", null, Movies_O, null);

			}
			else if(s.equals("Activities")) {

				JPanel Activities_O = new JPanel();

				DefaultTableModel activitiesModel = new DefaultTableModel(); 

				// Create a couple of columns 
				activitiesModel.addColumn("Title"); 
				activitiesModel.addColumn("Info");
				activitiesModel.addColumn("Intensity");
				activitiesModel.addColumn("Views"); 

				// Append a row
				for(Activity t : CategoryManagement.recommendActivity(UserManagement.getCurrentUser().getActivityIntensityList())){
					String title = t.getTitle();
					String link = t.getLink();
					String intensity = t.getIntensity();
					int views = t.getViews();
					activitiesModel.addRow(new Object[]{ title, link, intensity, views});
				}
				
				JTable activitiesTable = new JTable(activitiesModel);
				
				activitiesTable.getColumn("Title").setPreferredWidth(250);
				activitiesTable.getColumn("Views").setPreferredWidth(35);
				activitiesTable.setRowSelectionAllowed(false);
				
				activitiesTable.getColumn("Info").setCellRenderer(new ButtonRenderer());
				activitiesTable.getColumn("Info").setCellEditor(new ButtonEditor(new JCheckBox()));

				activitiesTable.addMouseListener(new JTableActivityButtonMouseListener(activitiesTable));

				JScrollPane Activities_ScrollPane = new JScrollPane(activitiesTable);
				Activities_ScrollPane.setBounds(0, 0, 459, 216);
				Activities_O.add(Activities_ScrollPane);
				Activities_O.setLayout(null);

				tabbedPane.addTab("Activities", null, Activities_O, null);

			}
			else if(s.equals("Destinations")) {

				JPanel Destinations_O = new JPanel();

				DefaultTableModel destinationsModel = new DefaultTableModel(); 

				// Create a couple of columns 
				destinationsModel.addColumn("Title"); 
				destinationsModel.addColumn("Link");
				destinationsModel.addColumn("Category");
				destinationsModel.addColumn("Views"); 

				// Append a row
				for(Destination t : CategoryManagement.recommendDestination(UserManagement.getCurrentUser().getDestinationCategoryList())){
					String title = t.getTitle();
					String link = t.getLink();
					String category = t.getCategory();
					int views = t.getViews();
					destinationsModel.addRow(new Object[]{ title, link, category, views});
				}
				
				JTable destinationsTable = new JTable(destinationsModel);
				
				destinationsTable.getColumn("Title").setPreferredWidth(200);
				destinationsTable.getColumn("Views").setPreferredWidth(35);
				destinationsTable.setRowSelectionAllowed(false);
				
				destinationsTable.getColumn("Link").setCellRenderer(new ButtonRenderer());
				destinationsTable.getColumn("Link").setCellEditor(new ButtonEditor(new JCheckBox()));

				destinationsTable.addMouseListener(new JTableDestinationButtonMouseListener(destinationsTable));

				JScrollPane Destinations_ScrollPane = new JScrollPane(destinationsTable);
				Destinations_ScrollPane.setBounds(0, 0, 459, 216);
				Destinations_O.add(Destinations_ScrollPane);
				Destinations_O.setLayout(null);

				tabbedPane.addTab("Destinations", null, Destinations_O, null);

			}
			else if(s.equals("Books")){

				JPanel Books_O = new JPanel();

				DefaultTableModel booksModel = new DefaultTableModel(); 

				// Create a couple of columns 
				booksModel.addColumn("Title"); 
				booksModel.addColumn("Author");
				booksModel.addColumn("Book Link");
				booksModel.addColumn("Genre");
				booksModel.addColumn("Views"); 

				// Append a row
				for(Book t : CategoryManagement.recommendBook(UserManagement.getCurrentUser().getBookGenreList())){
					String title = t.getTitle();
					String author = t.getAuthor();
					String link = t.getLink();
					String genre = "";
					if(!t.getGenre().isEmpty()){
						genre = t.getGenre().get(0);
						for(int i=1 ; i<t.getGenre().size() ; i++){
							genre = genre + ", " + t.getGenre().get(i);
						}
					}
					int views = t.getViews();
					booksModel.addRow(new Object[]{ title, author, link, genre, views});
				}
				
				JTable booksTable = new JTable(booksModel);
				
				booksTable.getColumn("Title").setPreferredWidth(120);
				booksTable.getColumn("Views").setPreferredWidth(35);
				booksTable.setRowSelectionAllowed(false);
				
				booksTable.getColumn("Book Link").setCellRenderer(new ButtonRenderer());
				booksTable.getColumn("Book Link").setCellEditor(new ButtonEditor(new JCheckBox()));

				booksTable.addMouseListener(new JTableBookButtonMouseListener(booksTable));

				JScrollPane Books_ScrollPane = new JScrollPane(booksTable);
				Books_ScrollPane.setBounds(0, 0, 459, 216);
				Books_O.add(Books_ScrollPane);
				Books_O.setLayout(null);

				tabbedPane.addTab("Books", null, Books_O, null);

			}

		}


		/*
		 * Κουμπί "Back"
		 */
		JLabel back_options = new JLabel("");
		back_options.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_options.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_options.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_options.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_options.setIcon(IH);

				for(String s:UserManagement.getCurrentUser().getSuggestionList()){
					for(JCheckBox c:new MoodSelection().checkboxList){
						if(c.getText().equals(s)){
							c.setSelected(true);
						}
					}
				}

				tabbedPane.removeAll();

				new MoodSelection().moodBox.setSelectedItem(CategoryManagement.getCurrentMood());
				HomeScreen.cd.show(HomeScreen.container, "m");
			}
		});
		back_options.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_options.setBounds(319, 290, 40, 40);
		Options.add(back_options);


		/*
		 * Κουμπί "Help"
		 */
		JLabel help_options = new JLabel("");
		help_options.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				help_options.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				help_options.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				help_options.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				help_options.setIcon(IH);
				String Identifier = "o";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		help_options.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		help_options.setBounds(459, 0, 25, 25);
		Options.add(help_options);


		/*
		 * Κουμπί "Log Out"
		 */
		JLabel Log_Out_options = new JLabel("");
		Log_Out_options.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Hover.png"));
				Log_Out_options.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Default.png"));
				Log_Out_options.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Pressed.png"));
				Log_Out_options.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_Out_Hover.png"));
				Log_Out_options.setIcon(IH);
				HomeScreen.cd.show(HomeScreen.container, "ls");
			}
		});
		Log_Out_options.setIcon(new ImageIcon(Main.class.getResource("/Images/Log_Out_Default.png")));
		Log_Out_options.setBounds(386, 0, 32, 32);
		Options.add(Log_Out_options);


		/*
		 * Κουμπί "Add Stuff"
		 */
		JLabel add_options = new JLabel("");
		add_options.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Add_Stuff_Hover.png"));
				add_options.setIcon(IH);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Add_Stuff_Default.png"));
				add_options.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Add_Stuff_Pressed.png"));
				add_options.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Add_Stuff_Hover.png"));
				add_options.setIcon(IH);
				HomeScreen.container.add(new AddStuff().Add_Stuff,"add");
				HomeScreen.cd.show(HomeScreen.container, "add");
			}
		});
		add_options.setIcon(new ImageIcon(Main.class.getResource("/Images/Add_Stuff_Default.png")));
		add_options.setBounds(10, 299, 60, 25);
		Options.add(add_options);

	}





	class ButtonRenderer extends JButton implements TableCellRenderer {

		private static final long serialVersionUID = 1L;

		public ButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {

			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			} else {
				setForeground(table.getForeground());
				setBackground(table.getForeground());
			}

			if(value == null){
				setText("");
			}
			else if(table.getColumnName(column).equals("Series Trailer")){
				if(!CategoryManagement.recommendTvSeries(UserManagement.getCurrentUser().getTvSeriesGenreList()).get(row).getLink().equals("")){
					setText("trailer");
				}
				else setText("no link");
			}
			else if(table.getColumnName(column).equals("Series IMDb")){
				if(!CategoryManagement.recommendTvSeries(UserManagement.getCurrentUser().getTvSeriesGenreList()).get(row).getIMDBLink().equals("")){
					setText("IMDb");
				}
				else setText("no link");
			}
			else if(table.getColumnName(column).equals("Song Link")){
				if(!CategoryManagement.recommendMusic(UserManagement.getCurrentUser().getMusicGenreList()).get(row).getLink().equals("")){
					setText("song");
				}
				else setText("no link");
			}
			else if(table.getColumnName(column).equals("Movie Trailer")){
				if(!CategoryManagement.recommendMovie(UserManagement.getCurrentUser().getMovieGenreList()).get(row).getLink().equals("")){
					setText("trailer");
				}
				else setText("no link");
			}
			else if(table.getColumnName(column).equals("Movie IMDb")){
				if(!CategoryManagement.recommendMovie(UserManagement.getCurrentUser().getMovieGenreList()).get(row).getIMDBLink().equals("")){
					setText("IMDb");
				}
				else setText("no link");
			}
			else if(table.getColumnName(column).equals("Info")){
				if(!CategoryManagement.recommendActivity(UserManagement.getCurrentUser().getActivityIntensityList()).get(row).getLink().equals("")){
					setText("info");
				}
				else setText("no link");
			}
			else if(table.getColumnName(column).equals("Link")){
				if(!CategoryManagement.recommendDestination(UserManagement.getCurrentUser().getDestinationCategoryList()).get(row).getLink().equals("")){
					setText("info");
				}
				else setText("no link");
			}
			else if(table.getColumnName(column).equals("Book Link")){
				if(!CategoryManagement.recommendBook(UserManagement.getCurrentUser().getBookGenreList()).get(row).getLink().equals("")){
					setText("book");
				}
				else setText("no link");
			}
			
			//setText((value == null) ? "" : "link");
			return this;
		}
	}


	class ButtonEditor extends DefaultCellEditor {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected JButton button;

		private String label;

		private boolean isPushed;

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
		}

		public Component getTableCellEditorComponent(JTable table, Object value,
				boolean isSelected, int row, int column) {

			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}

			if(value == null){
				button.setText("");
			}
			else if(table.getColumnName(column).equals("Series Trailer")){
				if(!CategoryManagement.recommendTvSeries(UserManagement.getCurrentUser().getTvSeriesGenreList()).get(row).getLink().equals("")){
					button.setText("trailer");
				}
				else button.setText("no link");
			}
			else if(table.getColumnName(column).equals("Series IMDb")){
				if(!CategoryManagement.recommendTvSeries(UserManagement.getCurrentUser().getTvSeriesGenreList()).get(row).getIMDBLink().equals("")){
					button.setText("IMDb");
				}
				else button.setText("no link");
			}
			else if(table.getColumnName(column).equals("Song Link")){
				if(!CategoryManagement.recommendMusic(UserManagement.getCurrentUser().getMusicGenreList()).get(row).getLink().equals("")){
					button.setText("song");
				}
				else button.setText("no link");
			}
			else if(table.getColumnName(column).equals("Movie Trailer")){
				if(!CategoryManagement.recommendMovie(UserManagement.getCurrentUser().getMovieGenreList()).get(row).getLink().equals("")){
					button.setText("trailer");
				}
				else button.setText("no link");
			}
			else if(table.getColumnName(column).equals("Movie IMDb")){
				if(!CategoryManagement.recommendMovie(UserManagement.getCurrentUser().getMovieGenreList()).get(row).getIMDBLink().equals("")){
					button.setText("IMDb");
				}
				else button.setText("no link");
			}
			else if(table.getColumnName(column).equals("Info")){
				if(!CategoryManagement.recommendActivity(UserManagement.getCurrentUser().getActivityIntensityList()).get(row).getLink().equals("")){
					button.setText("info");
				}
				else button.setText("no link");
			}
			else if(table.getColumnName(column).equals("Link")){
				if(!CategoryManagement.recommendDestination(UserManagement.getCurrentUser().getDestinationCategoryList()).get(row).getLink().equals("")){
					button.setText("info");
				}
				else button.setText("no link");
			}
			else if(table.getColumnName(column).equals("Book Link")){
				if(!CategoryManagement.recommendBook(UserManagement.getCurrentUser().getBookGenreList()).get(row).getLink().equals("")){
					button.setText("book");
				}
				else button.setText("no link");
			}
			
			label = ((value == null) ? "" : value.toString());
			
			isPushed = true;
			return button;
		}

		public Object getCellEditorValue() {
			if (isPushed) {
			}
			isPushed = false;
			return new String(label);
		}

		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}

	}


	/*
	 * TV SERIES BUTTON LISTENER
	 */
	class JTableTvSeriesButtonMouseListener implements MouseListener {

		private JTable table;

		private void forwardEventToButton(MouseEvent e) {

			TableColumnModel columnModel = table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / table.getRowHeight();
			Object value;
			JButton button;
			MouseEvent buttonEvent;

			if(row >= table.getRowCount() || row < 0 || column >= table.getColumnCount() || column < 0)
				return;

			value = table.getValueAt(row, column);

			if(!(value instanceof JButton))
				return;

			button = (JButton)value;
			buttonEvent = (MouseEvent)SwingUtilities.convertMouseEvent(table, e, button);
			button.dispatchEvent(buttonEvent);
			table.repaint();
		}
		public JTableTvSeriesButtonMouseListener(JTable atable) {
			table = atable;
		}
		public void mouseClicked(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseEntered(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseExited(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mousePressed(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseReleased(MouseEvent e) {

			// Open a link
			String link = "";
			
			TvSeries selectedTvSeries = CategoryManagement.recommendTvSeries(UserManagement.getCurrentUser().getTvSeriesGenreList()).get(table.getSelectedRow());

			if(table.getSelectedColumn()==1){
				link = selectedTvSeries.getLink();
			}
			else if(table.getSelectedColumn()==2){
				link = selectedTvSeries.getIMDBLink();
			}
			
			if(!link.equals("")){
				Desktop des = Desktop.getDesktop();
				try {
					des.browse(new URI(link));
					selectedTvSeries.setViews(selectedTvSeries.getViews() + 1);
					CategoryManagement.serialization();
				} catch (IOException | URISyntaxException e1) {
					JOptionPane.showMessageDialog(null, "Link not found!");
				}
			}

			forwardEventToButton(e);
		}
	}

	/*
	 * MOVIE BUTTON LISTENER
	 */
	class JTableMovieButtonMouseListener implements MouseListener {

		private JTable table;

		private void forwardEventToButton(MouseEvent e) {

			TableColumnModel columnModel = table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / table.getRowHeight();
			Object value;
			JButton button;
			MouseEvent buttonEvent;

			if(row >= table.getRowCount() || row < 0 || column >= table.getColumnCount() || column < 0)
				return;

			value = table.getValueAt(row, column);

			if(!(value instanceof JButton))
				return;

			button = (JButton)value;
			buttonEvent = (MouseEvent)SwingUtilities.convertMouseEvent(table, e, button);
			button.dispatchEvent(buttonEvent);
			table.repaint();
		}
		public JTableMovieButtonMouseListener(JTable atable) {
			table = atable;
		}
		public void mouseClicked(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseEntered(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseExited(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mousePressed(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseReleased(MouseEvent e) {

			// Open a link
			String link = "";
			
			Movie selectedMovie = CategoryManagement.recommendMovie(UserManagement.getCurrentUser().getMovieGenreList()).get(table.getSelectedRow());

			if(table.getSelectedColumn()==1){
				link = CategoryManagement.recommendMovie(UserManagement.getCurrentUser().getMovieGenreList()).get(table.getSelectedRow()).getLink();
			}
			else if(table.getSelectedColumn()==2){
				link = CategoryManagement.recommendMovie(UserManagement.getCurrentUser().getMovieGenreList()).get(table.getSelectedRow()).getIMDBLink();
			}
			
			if(!link.equals("")){
				Desktop des = Desktop.getDesktop();
				try {
					des.browse(new URI(link));
					selectedMovie.setViews(selectedMovie.getViews() + 1);
					CategoryManagement.serialization();
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}

			forwardEventToButton(e);
		}
	}
	
	/*
	 * MUSIC BUTTON LISTENER
	 */
	class JTableMusicButtonMouseListener implements MouseListener {

		private JTable table;

		private void forwardEventToButton(MouseEvent e) {

			TableColumnModel columnModel = table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / table.getRowHeight();
			Object value;
			JButton button;
			MouseEvent buttonEvent;

			if(row >= table.getRowCount() || row < 0 || column >= table.getColumnCount() || column < 0)
				return;

			value = table.getValueAt(row, column);

			if(!(value instanceof JButton))
				return;

			button = (JButton)value;
			buttonEvent = (MouseEvent)SwingUtilities.convertMouseEvent(table, e, button);
			button.dispatchEvent(buttonEvent);
			table.repaint();
		}
		public JTableMusicButtonMouseListener(JTable atable) {
			table = atable;
		}
		public void mouseClicked(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseEntered(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseExited(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mousePressed(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseReleased(MouseEvent e) {

			// Open a link
			String link = "";
			
			Music selectedMusic = CategoryManagement.recommendMusic(UserManagement.getCurrentUser().getMusicGenreList()).get(table.getSelectedRow());
			
			if(table.getSelectedColumn()==2){
				link = CategoryManagement.recommendMusic(UserManagement.getCurrentUser().getMusicGenreList()).get(table.getSelectedRow()).getLink();
			}
			
			if(!link.equals("")){
				Desktop des = Desktop.getDesktop();
				try {
					des.browse(new URI(link));
					selectedMusic.setViews(selectedMusic.getViews() + 1);
					CategoryManagement.serialization();
				} catch (IOException | URISyntaxException e1) {
					JOptionPane.showMessageDialog(null, "Link not found!");
				}
			}
			
			forwardEventToButton(e);
		}
	}
	
	/*
	 * ACTIVITY BUTTON LISTENER
	 */
	class JTableActivityButtonMouseListener implements MouseListener {

		private JTable table;

		private void forwardEventToButton(MouseEvent e) {

			TableColumnModel columnModel = table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / table.getRowHeight();
			Object value;
			JButton button;
			MouseEvent buttonEvent;

			if(row >= table.getRowCount() || row < 0 || column >= table.getColumnCount() || column < 0)
				return;

			value = table.getValueAt(row, column);

			if(!(value instanceof JButton))
				return;

			button = (JButton)value;
			buttonEvent = (MouseEvent)SwingUtilities.convertMouseEvent(table, e, button);
			button.dispatchEvent(buttonEvent);
			table.repaint();
		}
		public JTableActivityButtonMouseListener(JTable atable) {
			table = atable;
		}
		public void mouseClicked(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseEntered(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseExited(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mousePressed(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseReleased(MouseEvent e) {

			// Open a link
			String link = "";
			
			Activity selectedActivity = CategoryManagement.recommendActivity(UserManagement.getCurrentUser().getActivityIntensityList()).get(table.getSelectedRow());
			
			if(table.getSelectedColumn()==1){
				link = CategoryManagement.recommendActivity(UserManagement.getCurrentUser().getActivityIntensityList()).get(table.getSelectedRow()).getLink();
			}
			
			if(!link.equals("")){
				Desktop des = Desktop.getDesktop();
				try {
					des.browse(new URI(link));
					selectedActivity.setViews(selectedActivity.getViews() + 1);
					CategoryManagement.serialization();
				} catch (IOException | URISyntaxException e1) {
					JOptionPane.showMessageDialog(null, "Link not found!");
				}
			}
			
			forwardEventToButton(e);
		}
	}
	
	/*
	 * DESTINATION BUTTON LISTENER
	 */
	class JTableDestinationButtonMouseListener implements MouseListener {

		private JTable table;

		private void forwardEventToButton(MouseEvent e) {

			TableColumnModel columnModel = table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / table.getRowHeight();
			Object value;
			JButton button;
			MouseEvent buttonEvent;

			if(row >= table.getRowCount() || row < 0 || column >= table.getColumnCount() || column < 0)
				return;

			value = table.getValueAt(row, column);

			if(!(value instanceof JButton))
				return;

			button = (JButton)value;
			buttonEvent = (MouseEvent)SwingUtilities.convertMouseEvent(table, e, button);
			button.dispatchEvent(buttonEvent);
			table.repaint();
		}
		public JTableDestinationButtonMouseListener(JTable atable) {
			table = atable;
		}
		public void mouseClicked(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseEntered(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseExited(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mousePressed(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseReleased(MouseEvent e) {

			// Open a link
			String link = "";
			
			Destination selectedDestination = CategoryManagement.recommendDestination(UserManagement.getCurrentUser().getDestinationCategoryList()).get(table.getSelectedRow());

			if(table.getSelectedColumn()==1){
				link = CategoryManagement.recommendDestination(UserManagement.getCurrentUser().getDestinationCategoryList()).get(table.getSelectedRow()).getLink();
			}
			
			if(!link.equals("")){
				Desktop des = Desktop.getDesktop();
				try {
					des.browse(new URI(link));
					selectedDestination.setViews(selectedDestination.getViews() + 1);
					CategoryManagement.serialization();
				} catch (IOException | URISyntaxException e1) {
					JOptionPane.showMessageDialog(null, "Link not found!");
				}
			}
			
			forwardEventToButton(e);
		}
	}
	
	/*
	 * BOOK BUTTON LISTENER
	 */
	class JTableBookButtonMouseListener implements MouseListener {

		private JTable table;

		private void forwardEventToButton(MouseEvent e) {

			TableColumnModel columnModel = table.getColumnModel();
			int column = columnModel.getColumnIndexAtX(e.getX());
			int row = e.getY() / table.getRowHeight();
			Object value;
			JButton button;
			MouseEvent buttonEvent;

			if(row >= table.getRowCount() || row < 0 || column >= table.getColumnCount() || column < 0)
				return;

			value = table.getValueAt(row, column);

			if(!(value instanceof JButton))
				return;

			button = (JButton)value;
			buttonEvent = (MouseEvent)SwingUtilities.convertMouseEvent(table, e, button);
			button.dispatchEvent(buttonEvent);
			table.repaint();
		}
		public JTableBookButtonMouseListener(JTable atable) {
			table = atable;
		}
		public void mouseClicked(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseEntered(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseExited(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mousePressed(MouseEvent e) {
			forwardEventToButton(e);
		}
		public void mouseReleased(MouseEvent e) {

			// Open a link
			String link = "";
			
			Book selectedBook = CategoryManagement.recommendBook(UserManagement.getCurrentUser().getBookGenreList()).get(table.getSelectedRow());
			
			if(table.getSelectedColumn()==2){
				link = CategoryManagement.recommendBook(UserManagement.getCurrentUser().getBookGenreList()).get(table.getSelectedRow()).getLink();
			}
			
			if(!link.equals("")){
				Desktop des = Desktop.getDesktop();
				try {
					des.browse(new URI(link));
					selectedBook.setViews(selectedBook.getViews() + 1);
					CategoryManagement.serialization();
				} catch (IOException | URISyntaxException e1) {
					JOptionPane.showMessageDialog(null, "Link not found!");
				}
			}
			
			forwardEventToButton(e);
		}
	}

}


