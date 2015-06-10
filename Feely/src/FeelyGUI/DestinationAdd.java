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

public class DestinationAdd {
	
	JPanel Destinations_add_p = new JPanel();
	
	public DestinationAdd(){
		Destinations_add_p.setBackground(new Color(255, 250, 205));
		
		Destinations_add_p.setLayout(null);
		
		JLabel lblAddingStuffToDestinations = new JLabel("Adding Stuff to: Destinations");
		lblAddingStuffToDestinations.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddingStuffToDestinations.setBounds(10, 0, 194, 22);
		Destinations_add_p.add(lblAddingStuffToDestinations);
		
		JTabbedPane destinationabbedPane = new JTabbedPane(JTabbedPane.TOP);
		destinationabbedPane.setBounds(10, 44, 356, 219);
		Destinations_add_p.add(destinationabbedPane);
		
		JPanel addTitlePanel = new JPanel();
		destinationabbedPane.addTab("Name", null, addTitlePanel, null);
		addTitlePanel.setLayout(null);
		
		JTextField txtNameOfDestination = new JTextField();
		txtNameOfDestination.setText("Name of destination");
		txtNameOfDestination.setColumns(20);
		txtNameOfDestination.setBounds(10, 68, 157, 20);
		addTitlePanel.add(txtNameOfDestination);
		
		JPanel addLinkPanel = new JPanel();
		destinationabbedPane.addTab("Link", null, addLinkPanel, null);
		addLinkPanel.setLayout(null);
		
		JTextField txtDestinationLink = new JTextField();
		txtDestinationLink.setText("Link to Google Maps");
		txtDestinationLink.setColumns(20);
		txtDestinationLink.setBounds(10, 68, 157, 20);
		addLinkPanel.add(txtDestinationLink);
		
		JPanel addCategoryPanel = new JPanel();
		destinationabbedPane.addTab("Category", null, addCategoryPanel, null);
		addCategoryPanel.setLayout(null);
		
		ButtonGroup destinationCategoryButtonGroup = new ButtonGroup();
		Box destinationCategoryBox = Box.createVerticalBox();
		ArrayList<JRadioButton> radioButtonList = new ArrayList<JRadioButton>();
		
		for(int i=0 ; i<CategoryManagement.getDestinationcategorymatrix().length ; i++){
			JRadioButton radioButton = new JRadioButton(CategoryManagement.getDestinationcategorymatrix()[i].toString());
			destinationCategoryButtonGroup.add(radioButton);
			radioButtonList.add(radioButton);
			destinationCategoryBox.add(radioButton);
		}
		
		JScrollPane destinationCategoryScrollPane = new JScrollPane(destinationCategoryBox);
		destinationCategoryScrollPane.setBounds(0, 0, 351, 191);
		addCategoryPanel.add(destinationCategoryScrollPane);
		
		JLabel moodLabel = new JLabel("Choose Mood");
		moodLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		moodLabel.setBounds(375, 100, 109, 14);
		Destinations_add_p.add(moodLabel);
		
		JComboBox<String> moodComboBox = new JComboBox<String>();
		moodComboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		moodComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Lovestruck", "Happy", "Bored", "Sad", "Angry"}));
		moodComboBox.setToolTipText("");
		moodComboBox.setBounds(375, 125, 109, 28);
		moodComboBox.setSelectedIndex(2);
		Destinations_add_p.add(moodComboBox);
		
		
		/*
		 * Κουμπί "Save"
		 */
		JLabel save_dest_add = new JLabel("");
		save_dest_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_dest_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				save_dest_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				save_dest_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_dest_add.setIcon(IH);
				
				if( !(txtNameOfDestination.getText().equals("") || txtNameOfDestination.getText().equals("Name of destination"))
						&& !(txtDestinationLink.getText().equals("") || txtDestinationLink.getText().equals("Link to Google Maps"))
						&& !destinationCategoryButtonGroup.isSelected(null)) {

					String category = "";
					for(JRadioButton r : radioButtonList){
						if(r.isSelected()){
							category = r.getText();
						}
					}
					ArrayList<String> mood = new ArrayList<String>();
					mood.add(moodComboBox.getSelectedItem().toString());
					
					boolean destinationExists = false;
					
					for (Destination destinationTitle : CategoryManagement.getDestinationList()) {
						if (destinationTitle.getTitle().equalsIgnoreCase(txtNameOfDestination.getText())) {
							JOptionPane.showMessageDialog(null, "This destination already exists!");
							destinationExists = true;
							break;
						}
					}
					
					if (!destinationExists) {
						CategoryManagement.addNewDestination(txtNameOfDestination.getText(), txtDestinationLink.getText(), category, mood);
						CategoryManagement.serialization();
						JOptionPane.showMessageDialog(null, "Destination successfully added!");
						HomeScreen.cd.show(HomeScreen.container, "add");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill in all the necessary fields!");
				}
				
			}
		});
		save_dest_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		save_dest_add.setBounds(398, 300, 60, 25);
		Destinations_add_p.add(save_dest_add);
		
		
		/*
		 * Κουμπί "Back"
		 */
		JLabel back_dest_add = new JLabel("");
		back_dest_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_dest_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_dest_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_dest_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_dest_add.setIcon(IH);
				HomeScreen.cd.show(HomeScreen.container, "add");
			}
		});
		back_dest_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_dest_add.setBounds(319, 290, 40, 40);
		Destinations_add_p.add(back_dest_add);
		
		
		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_dest_add = new JLabel("");
		Help_dest_add.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_dest_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_dest_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_dest_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_dest_add.setIcon(IH);
				String Identifier = "dest_a";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		Help_dest_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_dest_add.setBounds(459, 0, 25, 25);
		Destinations_add_p.add(Help_dest_add);
		
	}

}
