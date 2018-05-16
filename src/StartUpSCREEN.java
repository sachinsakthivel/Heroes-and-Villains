import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class StartUpSCREEN {

	private JFrame frmStartuptest;
	private MainGUIManager manager;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUpSCREEN window = new StartUpSCREEN();
					window.frmStartuptest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartUpSCREEN(MainGUIManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmStartuptest.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStartuptest = new JFrame();
		frmStartuptest.setResizable(false);
		frmStartuptest.setTitle("StartUpTest");
		frmStartuptest.setBounds(100, 100, 1039, 791);
		frmStartuptest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStartuptest.getContentPane().setLayout(null);
		
		JButton btnNewGame = new JButton("NEW GAME");
		btnNewGame.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnNewGame.setBounds(440, 391, 151, 38);
		frmStartuptest.getContentPane().add(btnNewGame);
		
		JButton btnNewButton = new JButton("QUIT GAME");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnNewButton.setBounds(440, 473, 151, 38);
		frmStartuptest.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StartUpSCREEN.class.getResource("/Images/chargeEdit.jpg")));
		label.setBounds(0, 0, 964, 720);
		frmStartuptest.getContentPane().add(label);
	}
	
	public void closeSCREEN() {
		frmStartuptest.dispose();
	}
	
	public void FinishedSCREEN() {
		manager.closeStartUpSCREEN(this);
	}
}
