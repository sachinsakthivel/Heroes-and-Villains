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
import javax.swing.JButton;

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
		
		JButton btnNorth = new JButton("Travel North");
		btnNorth.setBounds(403, 270, 119, 38);
		frame.getContentPane().add(btnNorth);
		
		JLabel lblhomeBase = new JLabel("Home Base");
		lblhomeBase.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblhomeBase.setBounds(382, 11, 164, 102);
		frame.getContentPane().add(lblhomeBase);
		
		JButton btnTravelSouth = new JButton("Destination: ");
		btnTravelSouth.setBounds(403, 611, 119, 38);
		frame.getContentPane().add(btnTravelSouth);
	}
}
