package FeelyGUI;

import Feely.*;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.awt.*;


public class HomeScreen {

	private JPasswordField password_L;
	private JTextField username_L;
	private JTextField username_S;
	private JPasswordField password_S;
	private JPasswordField password_S1;
    JFrame frame = new JFrame();
    protected static JPanel container = new JPanel();
    protected static CardLayout cd = new CardLayout(0,0);
    
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public HomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Images/Feely_Icon.png")));
		frame.setTitle("Feely");
		frame.setBounds(100, 100, 513, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.getContentPane().add(container);
		container.setLayout(cd);
		
		
		
		JPanel LogIn_SignUp = new JPanel();
		LogIn_SignUp.setBackground(new Color(255, 250, 205));
		LogIn_SignUp.setLayout(null);
		container.add(LogIn_SignUp, "ls");
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setBounds(100, 11, 73, 26);
		LogIn_SignUp.add(lblNewLabel);
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setBounds(300, 11, 73, 26);
		LogIn_SignUp.add(lblSignUp);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 67, 73, 26);
		LogIn_SignUp.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 137, 73, 26);
		LogIn_SignUp.add(lblPassword);
		
		password_L = new JPasswordField();
		password_L.setBounds(84, 140, 100, 20);
		LogIn_SignUp.add(password_L);
		
		JLabel label = new JLabel("Username");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(216, 67, 73, 26);
		LogIn_SignUp.add(label);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword_1.setBounds(216, 137, 73, 26);
		LogIn_SignUp.add(lblPassword_1);
		
		username_L = new JTextField();
		username_L.setBounds(84, 70, 100, 20);
		LogIn_SignUp.add(username_L);
		username_L.setColumns(10);
		
		username_S = new JTextField();
		username_S.setColumns(10);
		username_S.setBounds(340, 70, 100, 20);
		LogIn_SignUp.add(username_S);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRepeatPassword.setBounds(216, 207, 123, 26);
		LogIn_SignUp.add(lblRepeatPassword);
		
		password_S = new JPasswordField();
		password_S.setBounds(340, 140, 100, 20);
		LogIn_SignUp.add(password_S);
		
		password_S1 = new JPasswordField();
		password_S1.setBounds(340, 210, 100, 20);
		LogIn_SignUp.add(password_S1);
		
		
		/*
		 * Κουμπί "Log In"
		 */
		JLabel Log_In = new JLabel("");
		Log_In.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_In_Hover.png"));
				Log_In.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_In_Default.png"));
				Log_In.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_In_Pressed.png"));
				Log_In.setIcon(IH);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Log_In_Hover.png"));
				Log_In.setIcon(IH);
				
				int a;
				a = UserManagement.logInVerification(username_L.getText().trim(), password_L.getText());
				if(a==0){
					JOptionPane.showMessageDialog(null, "You logged in as " + username_L.getText());
					UserManagement.setCurrentUsername(username_L.getText());
					container.add(new EditPreferences().Edit_Pref,"ep");
					cd.show(container, "ep");
				}
				else if(a==1) JOptionPane.showMessageDialog(null, "Wrong username!");
				else if(a==2) JOptionPane.showMessageDialog(null, "Wrong password!");
				else JOptionPane.showMessageDialog(null, "Fill in all the fields!");
				username_L.setText(null);
				password_L.setText(null);
			}
		});
		Log_In.setIcon(new ImageIcon(Main.class.getResource("/Images/Log_In_Default.png")));
		Log_In.setBounds(90, 282, 48, 48);
		LogIn_SignUp.add(Log_In);
		
		
		/*
		 * Κουμπί "Sign Up"
		 */
		JLabel Sign_Up = new JLabel("");
		Sign_Up.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Sign_Up_Hover.png"));
				Sign_Up.setIcon(IH);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Sign_Up_Default.png"));
				Sign_Up.setIcon(IH);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Sign_Up_Pressed.png"));
				Sign_Up.setIcon(IH);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon IH = new ImageIcon(getClass().getResource("/images/Sign_Up_Hover.png"));
				Sign_Up.setIcon(IH);
				int a;
				a = UserManagement.signUpVerification(username_S.getText().trim(), password_S.getText(), password_S1.getText()); 
				if(a==0) {
					JOptionPane.showMessageDialog(null, "You logged in as " + username_S.getText());
					UserManagement.setCurrentUsername(username_S.getText());
					container.add(new EditPreferences().Edit_Pref,"ep");
					cd.show(container, "ep");
				}
				else if(a==1) JOptionPane.showMessageDialog(null, "This username already exists!");
				else if(a==2) JOptionPane.showMessageDialog(null, "The passwords are different!");	
				else if(a==3) JOptionPane.showMessageDialog(null, "You can't use your username as your password!");
				else JOptionPane.showMessageDialog(null, "Fill in all the fields!");
				username_S.setText(null);
				password_S.setText(null);
				password_S1.setText(null);
			}
		});
		Sign_Up.setIcon(new ImageIcon(Main.class.getResource("/Images/Sign_Up_Default.png")));
		Sign_Up.setBounds(282, 310, 70, 20);
		LogIn_SignUp.add(Sign_Up);
		
	}
}

