import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;

import java.util.concurrent.TimeUnit;

public class HomeBaseSCREEN {

	private JFrame frame;

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
		
		
		JTextArea txtDisplay = new JTextArea("What would you like to do? (Input the Number that Corresponds with your Choice)\n" + 
				"0 - Quit Game\n1 - Travel North - Destination: Unknown\n" + 
				"1 - Travel North - Destination: Unknown\n" +
				"2 - Travel East - Destination: Unknown\n" + 
				"3 - Travel West - Destination: Unknown\n" + 
				"4 - Travel South - Destination: Unknown\n" + 
				"5 - Use a Map\n" + 
				"6 - Look at Team Status and Item Descriptions");
		txtDisplay.setBackground(Color.WHITE);
		txtDisplay.setWrapStyleWord(true);
		txtDisplay.setLineWrap(true);
		txtDisplay.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		txtDisplay.setEditable(false);
		txtDisplay.setBounds(160, 320, 682, 319);
		frame.getContentPane().add(txtDisplay);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StartUpSCREEN.class.getResource("/Images/stickBKG.jpg")));
		label.setBounds(0, 0, 968, 755);
		frame.getContentPane().add(label);
	}
	
	
	
	/*
	   try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 */

}
