package FeelyGUI;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class Help {
	
	JPanel Help2 = new JPanel();
	
	public Help(String Identifier){
		Help2.setBackground(new Color(255, 250, 205));
		Help2.setLayout(null);
		JLabel close = new JLabel("");
		File file = null;
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Close_Hover.png"));
				close.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Close_Default.png"));
				close.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Close_Pressed.png"));
				close.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Close_Hover.png"));
				close.setIcon(IH);
				if(Identifier.equals("ep"))
					HomeScreen.cd.show(HomeScreen.container, "ep");
				else if (Identifier.equals("Tv"))
					HomeScreen.cd.show(HomeScreen.container, "tv");
				else if (Identifier.equals("Music"))
					HomeScreen.cd.show(HomeScreen.container, "music");
				else if (Identifier.equals("Movies"))
					HomeScreen.cd.show(HomeScreen.container, "mov");
				else if (Identifier.equals("Books"))
					HomeScreen.cd.show(HomeScreen.container, "books");
				else if (Identifier.equals("Activities"))
					HomeScreen.cd.show(HomeScreen.container, "act");
				else if (Identifier.equals("Destinations"))
					HomeScreen.cd.show(HomeScreen.container, "dest");
				else if (Identifier.equals("m"))
					HomeScreen.cd.show(HomeScreen.container, "m");
				else if (Identifier.equals("o"))
					HomeScreen.cd.show(HomeScreen.container,"o");
				else if (Identifier.equals("add"))
					HomeScreen.cd.show(HomeScreen.container, "add");
				else if (Identifier.equals("tv_a"))
					HomeScreen.cd.show(HomeScreen.container, "tv_a");
				else if (Identifier.equals("music_a"))
					HomeScreen.cd.show(HomeScreen.container, "music_a");
				else if (Identifier.equals("books_a"))
					HomeScreen.cd.show(HomeScreen.container, "books_a");
				else if (Identifier.equals("dest_a"))
					HomeScreen.cd.show(HomeScreen.container, "dest_a");
				else if (Identifier.equals("mov_a"))
					HomeScreen.cd.show(HomeScreen.container,"mov_a");
				else if (Identifier.equals("act_a"))
					HomeScreen.cd.show(HomeScreen.container,"act_a");
			}
		});
		close.setIcon(new ImageIcon(Main.class.getResource("/Images/Close_Default.png")));
		close.setBounds(409, 303, 65, 25);
		Help2.add(close);
		
		JTextArea helpTextArea = new JTextArea();
		
		if(Identifier.equals("ep")){
			file = new File("Help/Edit_Preferences_Help.txt");
		}
		else if (Identifier.equals("Tv")){
			file = new File("Help/Tv_Series_Preferences_Help.txt");
		}
		else if (Identifier.equals("Music")){
			file = new File("Help/Music_Preferences_Help.txt");
		}
		else if (Identifier.equals("Movies")){
			file = new File("Help/Movie_Preferences_Help.txt");
		}
		else if (Identifier.equals("Books")){
			file = new File("Help/Book_Preferences_Help.txt");
		}
		else if (Identifier.equals("Activities")){
			file = new File("Help/Activity_Preferences_Help.txt");
		}
		else if (Identifier.equals("Destinations")){
			file = new File("Help/Destination_Preferences_Help.txt");
		}
		else if (Identifier.equals("m")){
			file = new File("Help/Mood_Selection_Help.txt");
		}
		else if (Identifier.equals("o")){
			file = new File("Help/Suggestions_Help.txt");
		}
		else if (Identifier.equals("add")){
			file = new File("Help/Add_Stuff_To_Category_Help.txt");
		}
		else if (Identifier.equals("tv_a")){
			file = new File("Help/Tv_Series_Add_Stuff_Help.txt");
		}
		else if (Identifier.equals("music_a")){
			file = new File("Help/Music_Add_Stuff_Help.txt");
		}	
		else if (Identifier.equals("books_a")){
			file = new File("Help/Book_Add_Stuff_Help.txt");
		}
		else if (Identifier.equals("dest_a")){
			file = new File("Help/Destination_Add_Stuff_Help.txt");
		}
		else if (Identifier.equals("mov_a")){
			file = new File("Help/Movie_Add_Stuff_Help.txt");
		}
		else if (Identifier.equals("act_a")){
			file = new File("Help/Activity_Add_Stuff_Help.txt");
		}
		
		try
        {
            FileReader reader = new FileReader( file );
            BufferedReader br = new BufferedReader(reader);
            helpTextArea.read( br, null );
            br.close();
            helpTextArea.requestFocus();
        }
        catch(Exception e2) { System.out.println(e2); }
		
		helpTextArea.setEditable(false);
		JScrollPane scrollPane_6 = new JScrollPane(helpTextArea);
		scrollPane_6.setBounds(20, 39, 213, 281);
		Help2.add(scrollPane_6);
		
		JLabel lblHelp = new JLabel("Help");
		lblHelp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHelp.setBounds(10, 11, 98, 22);
		Help2.add(lblHelp);
		
	}

}
