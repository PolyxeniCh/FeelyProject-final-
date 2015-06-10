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

public class BookAdd {

	JPanel Books_add_p = new JPanel();

	public BookAdd(){
		Books_add_p.setBackground(new Color(255, 250, 205));

		Books_add_p.setLayout(null);

		JLabel lblAddingStuffToBooks = new JLabel("Adding Stuff to: Books");
		lblAddingStuffToBooks.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddingStuffToBooks.setBounds(10, 0, 194, 22);
		Books_add_p.add(lblAddingStuffToBooks);

		JTabbedPane bookTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		bookTabbedPane.setBounds(10, 44, 356, 219);
		Books_add_p.add(bookTabbedPane);

		JPanel addTitlePanel = new JPanel();
		bookTabbedPane.addTab("Title", null, addTitlePanel, null);
		addTitlePanel.setLayout(null);

		JTextField txtBookTitle = new JTextField();
		txtBookTitle.setText("Book Title");
		txtBookTitle.setColumns(20);
		txtBookTitle.setBounds(10, 68, 157, 20);
		addTitlePanel.add(txtBookTitle);

		JPanel addAuthorPanel = new JPanel();
		bookTabbedPane.addTab("Author", null, addAuthorPanel, null);
		addAuthorPanel.setLayout(null);

		JTextField txtBookAuthor = new JTextField();
		txtBookAuthor.setText("Book Author");
		txtBookAuthor.setColumns(20);
		txtBookAuthor.setBounds(10, 68, 157, 20);
		addAuthorPanel.add(txtBookAuthor);

		JPanel addLinkPanel = new JPanel();
		bookTabbedPane.addTab("Link", null, addLinkPanel, null);
		addLinkPanel.setLayout(null);

		JTextField txtLinkToBook = new JTextField();
		txtLinkToBook.setText("Link to Book");
		txtLinkToBook.setColumns(20);
		txtLinkToBook.setBounds(10, 68, 157, 20);
		addLinkPanel.add(txtLinkToBook);

		JPanel addGenrePanel = new JPanel();
		bookTabbedPane.addTab("Genre", null, addGenrePanel, null);
		addGenrePanel.setLayout(null);

		ButtonGroup bookGenreButtonGroup = new ButtonGroup();
		Box bookGenreBox = Box.createVerticalBox();
		ArrayList<JRadioButton> radioButtonList = new ArrayList<JRadioButton>();

		for(int i=0 ; i<CategoryManagement.getBookgenrematrix().length ; i++){
			JRadioButton radioButton = new JRadioButton(CategoryManagement.getBookgenrematrix()[i].toString());
			bookGenreButtonGroup.add(radioButton);
			radioButtonList.add(radioButton);
			bookGenreBox.add(radioButton);
		}

		JScrollPane bookGenreScrollPane = new JScrollPane(bookGenreBox);
		bookGenreScrollPane.setBounds(0, 0, 351, 191);
		addGenrePanel.add(bookGenreScrollPane);

		JLabel moodLabel = new JLabel("Choose Mood");
		moodLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		moodLabel.setBounds(375, 100, 109, 14);
		Books_add_p.add(moodLabel);

		JComboBox<String> moodComboBox = new JComboBox<String>();
		moodComboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		moodComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Lovestruck", "Happy", "Bored", "Sad", "Angry"}));
		moodComboBox.setToolTipText("");
		moodComboBox.setBounds(375, 125, 109, 28);
		moodComboBox.setSelectedIndex(2);
		Books_add_p.add(moodComboBox);


		/*
		 * Κουμπί "Save"
		 */
		JLabel save_books_add = new JLabel("");
		save_books_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_books_add.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				save_books_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				save_books_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_books_add.setIcon(IH);

				if( !(txtBookTitle.getText().equals("") || txtBookTitle.getText().equals("Book Title"))
						&& !(txtBookAuthor.getText().equals("") || txtBookAuthor.getText().equals("Book Author"))
						&& !(txtLinkToBook.getText().equals("") || txtLinkToBook.getText().equals("Link to Book"))
						&& !bookGenreButtonGroup.isSelected(null)) {

					ArrayList<String> genre = new ArrayList<String>();
					for(JRadioButton r : radioButtonList){
						if(r.isSelected()){
							genre.add(r.getText());
						}
					}
					ArrayList<String> mood = new ArrayList<String>();
					mood.add(moodComboBox.getSelectedItem().toString());
					
					boolean bookExists = false;
					
					for (Book bookTitle : CategoryManagement.getBookList()) {
						if (bookTitle.getTitle().equalsIgnoreCase(txtBookTitle.getText())) {
							JOptionPane.showMessageDialog(null, "This book already exists!");
							bookExists = true;
							break;
						}
					}
					
					if (!bookExists) {
						CategoryManagement.addNewBook(txtBookTitle.getText(), txtLinkToBook.getText(), txtBookAuthor.getText(), genre, mood);
						CategoryManagement.serialization();
						JOptionPane.showMessageDialog(null, "Book successfully added!");
						HomeScreen.cd.show(HomeScreen.container, "add");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill in all the necessary fields!");
				}
			}
		});
		save_books_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		save_books_add.setBounds(398, 300, 60, 25);
		Books_add_p.add(save_books_add);


		/*
		 * Κουμπί "Back"
		 */
		JLabel back_books_add = new JLabel("");
		back_books_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_books_add.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_books_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_books_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_books_add.setIcon(IH);
				HomeScreen.cd.show(HomeScreen.container, "add");
			}
		});
		back_books_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_books_add.setBounds(319, 290, 40, 40);
		Books_add_p.add(back_books_add);


		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_books_add = new JLabel("");
		Help_books_add.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_books_add.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_books_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_books_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_books_add.setIcon(IH);
				String Identifier = "books_a";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		Help_books_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_books_add.setBounds(459, 0, 25, 25);
		Books_add_p.add(Help_books_add);
	}

}
