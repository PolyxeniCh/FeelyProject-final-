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

public class BookPreferences {

	JPanel Books = new JPanel();

	private ArrayList<JCheckBox> checkboxList = new ArrayList<JCheckBox>();
	private Box genre_books = Box.createVerticalBox();

	public BookPreferences(){
		Books.setBackground(new Color(255, 250, 205));

		Books.setLayout(null);
		JLabel Books2 = new JLabel("Books");
		Books2.setFont(new Font("Tahoma", Font.BOLD, 13));
		Books2.setBounds(10, 11, 98, 22);
		Books.add(Books2);

		
		/*
		 * Ενεργοποίηση των αντίστοιχων checkbox, ανάλογα με τις προτιμήσεις του χρήστη.
		 */
		for(int i=0;i<CategoryManagement.getBookgenrematrix().length;i++){

			JCheckBox j = new JCheckBox(CategoryManagement.getBookgenrematrix()[i]);
			checkboxList.add(j);   
			
			for(String s:UserManagement.getCurrentUser().getBookGenreList()) {
				if(s.equals(j.getText()))
					j.setSelected(true);
			}
			genre_books.add(j);
		}

		JScrollPane scrollPane_3 = new JScrollPane(genre_books);
		scrollPane_3.setBounds(20, 39, 213, 281);
		Books.add(scrollPane_3);


		/*
		 * Κουμπί "Back"
		 */
		JLabel back_books = new JLabel("");
		back_books.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_books.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_books.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_books.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_books.setIcon(IH);

				/*
				genre_books.removeAll();
				for(JCheckBox c : checkboxList){
					c.setSelected(false);
					for(String s:UserManagement.getCurrentUser().getBookGenreList()){
						if(s.equals(c.getText()))
							c.setSelected(true);
					}
					genre_books.add(c);
				}*/
				
				HomeScreen.cd.show(HomeScreen.container, "ep");
			}
		});
		
		back_books.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_books.setBounds(319, 290, 40, 40);
		Books.add(back_books);

		
		/*
		 * Κουμπί "Save"
		 */
		JLabel save_books = new JLabel("");
		save_books.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_books.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				save_books.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				save_books.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_books.setIcon(IH);

				ArrayList<String> books_genre = new ArrayList<String>();
				
				//books_genre.clear();
				for(JCheckBox c : checkboxList){
					if(c.isSelected()){
						books_genre.add(c.getText());
					}
				}

				UserManagement.getCurrentUser().setBookGenreList(books_genre);
				UserManagement.serialization();
				
				HomeScreen.cd.show(HomeScreen.container, "ep");
			}
		});
		
		save_books.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		save_books.setBounds(398, 300, 60, 25);
		Books.add(save_books);


		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_B_Pref = new JLabel("");
		Help_B_Pref.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_B_Pref.setIcon(IH);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_B_Pref.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_B_Pref.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_B_Pref.setIcon(IH);
				String Identifier = "Books";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		Help_B_Pref.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_B_Pref.setBounds(459, 0, 25, 25);
		Books.add(Help_B_Pref);

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
