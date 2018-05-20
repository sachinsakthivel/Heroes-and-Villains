import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;

import java.util.concurrent.TimeUnit;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
<<<<<<< HEAD
import javax.swing.JButton;
=======
import javax.swing.JScrollBar;
>>>>>>> branch 'master' of https://eng-git.canterbury.ac.nz/ssa237/heroes-and-villians.git

public class HomeBaseSCREEN {

	private JFrame frame;
<<<<<<< HEAD
=======
	private JTextField txtInputTheNumber;
	
	private static String DisplayText;
>>>>>>> branch 'master' of https://eng-git.canterbury.ac.nz/ssa237/heroes-and-villians.git

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeBaseSCREEN window = new HomeBaseSCREEN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeBaseSCREEN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 983, 787);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
<<<<<<< HEAD
		JButton btnNorth = new JButton("Travel North");
		btnNorth.setBounds(403, 270, 119, 38);
		frame.getContentPane().add(btnNorth);
=======
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(826, 273, 17, 319);
		frame.getContentPane().add(scrollBar);
>>>>>>> branch 'master' of https://eng-git.canterbury.ac.nz/ssa237/heroes-and-villians.git
		
<<<<<<< HEAD
		JLabel lblhomeBase = new JLabel("Home Base");
		lblhomeBase.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblhomeBase.setBounds(382, 11, 164, 102);
		frame.getContentPane().add(lblhomeBase);
=======
		
		JTextArea txtDisplay = new JTextArea("What would you like to do?\r\n0 - Quit Game\r\n1 - Travel North - Destination: Unknown\r\n2 - Travel East - Destination: Unknown\r\n3 - Travel West - Destination: Unknown\r\n4 - Travel South - Destination: Unknown\r\n5 - Use a Map\r\n6 - Look at Team Status and Item Descriptions");
		txtDisplay.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDisplay.setBackground(Color.WHITE);
		txtDisplay.setWrapStyleWord(true);
		txtDisplay.setLineWrap(true);
		txtDisplay.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		txtDisplay.setEditable(false);
		txtDisplay.setBounds(161, 273, 682, 319);
		frame.getContentPane().add(txtDisplay);
>>>>>>> branch 'master' of https://eng-git.canterbury.ac.nz/ssa237/heroes-and-villians.git
		
<<<<<<< HEAD
		JButton btnTravelSouth = new JButton("Destination: ");
		btnTravelSouth.setBounds(403, 611, 119, 38);
		frame.getContentPane().add(btnTravelSouth);
=======
		txtInputTheNumber = new JTextField();
		txtInputTheNumber.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		txtInputTheNumber.setText("Input the Number that Corresponds with your Choice.");
		txtInputTheNumber.setBounds(267, 603, 460, 30);
		frame.getContentPane().add(txtInputTheNumber);
		txtInputTheNumber.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StartUpSCREEN.class.getResource("/Images/stickBKG.jpg")));
		label.setBounds(0, 0, 968, 755);
		frame.getContentPane().add(label);
>>>>>>> branch 'master' of https://eng-git.canterbury.ac.nz/ssa237/heroes-and-villians.git
	}
	                                                                                                                                                                                                                                                                                                                                                                                                                          
	public String getDisplayText(){
		return DisplayText;
	}
	
	public static void setDisplayText(String NewDisplayText) {
		DisplayText = NewDisplayText; 
	}
}
