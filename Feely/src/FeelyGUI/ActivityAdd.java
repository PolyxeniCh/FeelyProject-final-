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

public class ActivityAdd {
	
	JPanel Activities_add_p = new JPanel();
	
	public ActivityAdd(){
		Activities_add_p.setBackground(new Color(255, 250, 205));
		
		Activities_add_p.setLayout(null);
		
		JLabel lblAddingStuffToActivities = new JLabel("Adding Stuff to: Activities");
		lblAddingStuffToActivities.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddingStuffToActivities.setBounds(10, 0, 194, 22);
		Activities_add_p.add(lblAddingStuffToActivities);
		
		JTabbedPane activityTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		activityTabbedPane.setBounds(10, 44, 356, 219);
		Activities_add_p.add(activityTabbedPane);
		
		JPanel addTitlePanel = new JPanel();
		activityTabbedPane.addTab("Title", null, addTitlePanel, null);
		addTitlePanel.setLayout(null);
		
		JTextField txtActivityTitle = new JTextField();
		txtActivityTitle.setText("Activity Title");
		txtActivityTitle.setColumns(20);
		txtActivityTitle.setBounds(10, 68, 157, 20);
		addTitlePanel.add(txtActivityTitle);
		
		JPanel addLinkPanel = new JPanel();
		activityTabbedPane.addTab("Link", null, addLinkPanel, null);
		addLinkPanel.setLayout(null);
		
		JTextField txtLinkToActivity = new JTextField();
		txtLinkToActivity.setText("Link to Activity");
		txtLinkToActivity.setColumns(20);
		txtLinkToActivity.setBounds(10, 68, 157, 20);
		addLinkPanel.add(txtLinkToActivity);
		
		JPanel addIntensityPanel = new JPanel();
		activityTabbedPane.addTab("Intensity", null, addIntensityPanel, null);
		addIntensityPanel.setLayout(null);
		
		ButtonGroup activityIntensityButtonGroup = new ButtonGroup();
		Box activityIntensityBox = Box.createVerticalBox();
		ArrayList<JRadioButton> radioButtonList = new ArrayList<JRadioButton>();
		
		for(int i=0 ; i<CategoryManagement.getActivityintensitymatrix().length ; i++){
			JRadioButton radioButton = new JRadioButton(CategoryManagement.getActivityintensitymatrix()[i].toString());
			activityIntensityButtonGroup.add(radioButton);
			radioButtonList.add(radioButton);
			activityIntensityBox.add(radioButton);
		}
		
		JScrollPane activityIntensityScrollPane = new JScrollPane(activityIntensityBox);
		activityIntensityScrollPane.setBounds(0, 0, 351, 191);
		addIntensityPanel.add(activityIntensityScrollPane);
		
		JLabel moodLabel = new JLabel("Choose Mood");
		moodLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		moodLabel.setBounds(375, 100, 109, 14);
		Activities_add_p.add(moodLabel);
		
		JComboBox<String> moodComboBox = new JComboBox<String>();
		moodComboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		moodComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Lovestruck", "Happy", "Bored", "Sad", "Angry"}));
		moodComboBox.setToolTipText("");
		moodComboBox.setBounds(375, 125, 109, 28);
		moodComboBox.setSelectedIndex(2);
		Activities_add_p.add(moodComboBox);
		
		
		/*
		 * Κουμπί "Save"
		 */
		JLabel save_act_add = new JLabel("");
		save_act_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_act_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Default.png"));
				save_act_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Pressed.png"));
				save_act_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Save_Hover.png"));
				save_act_add.setIcon(IH);
				
				if( !(txtActivityTitle.getText().equals("") || txtActivityTitle.getText().equals("Activity Title"))
					&& !(txtLinkToActivity.getText().equals("") || txtLinkToActivity.getText().equals("Link to Activity"))
					&& !activityIntensityButtonGroup.isSelected(null)) {
					
					String intensity = "";
					for(JRadioButton r : radioButtonList){
						if(r.isSelected()){
							intensity = r.getText();
						}
					}
					ArrayList<String> mood = new ArrayList<String>();
					mood.add(moodComboBox.getSelectedItem().toString());
					
					boolean activityExists = false;
					
					for (Activity activityTitle : CategoryManagement.getActivityList()) {
						if (activityTitle.getTitle().equalsIgnoreCase(txtActivityTitle.getText())) {
							JOptionPane.showMessageDialog(null, "This activity already exists!");
							activityExists = true;
							break;
						}
					}
					
					if (!activityExists) {
						CategoryManagement.addNewActivity(txtActivityTitle.getText(), txtLinkToActivity.getText(), intensity, mood);
						CategoryManagement.serialization();
						JOptionPane.showMessageDialog(null, "Activity successfully added!");
						HomeScreen.cd.show(HomeScreen.container, "add");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill in all the necessary fields!");
				}
				
			}
		});
		save_act_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Save_Default.png")));
		save_act_add.setBounds(398, 300, 60, 25);
		Activities_add_p.add(save_act_add);
		
		
		/*
		 * Κουμπί "Back"
		 */
		JLabel back_act_add = new JLabel("");
		back_act_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_act_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Default.png"));
				back_act_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Pressed.png"));
				back_act_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Back_Hover.png"));
				back_act_add.setIcon(IH);
				HomeScreen.cd.show(HomeScreen.container, "add");
			}
		});
		back_act_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Back_Default.png")));
		back_act_add.setBounds(319, 290, 40, 40);
		Activities_add_p.add(back_act_add);
		
		
		/*
		 * Κουμπί "Help"
		 */
		JLabel Help_act_add = new JLabel("");
		Help_act_add.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_act_add.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Default.png"));
				Help_act_add.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Pressed.png"));
				Help_act_add.setIcon(IH);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Help_Hover.png"));
				Help_act_add.setIcon(IH);
				String Identifier = "act_a";
				HomeScreen.container.add(new Help(Identifier).Help2,"Help");
				HomeScreen.cd.show(HomeScreen.container, "Help");
			}
		});
		Help_act_add.setIcon(new ImageIcon(Main.class.getResource("/Images/Help_Default.png")));
		Help_act_add.setBounds(459, 0, 25, 25);
		Activities_add_p.add(Help_act_add);
		
	}

}
