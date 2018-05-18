import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class HeroSetupSCREEN {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeroSetupSCREEN window = new HeroSetupSCREEN();
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
	public HeroSetupSCREEN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.setResizable(false);
		frame.setBounds(100, 100, 983, 787);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setDisabledTextColor(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setToolTipText("Enter a team name");
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		textField.setBackground(new Color(245, 245, 245));
		textField.setBounds(382, 57, 288, 42);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblType.setBounds(318, 118, 66, 33);
		frame.getContentPane().add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		comboBox.setToolTipText("Select a hero type");
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setBounds(382, 117, 288, 42);
		frame.getContentPane().add(comboBox);
		
		JLabel lblHeroNo = new JLabel("Hero No.");
		lblHeroNo.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblHeroNo.setBounds(775, 75, 95, 33);
		frame.getContentPane().add(lblHeroNo);
		
		JLabel lblTeam = new JLabel("Hero Name:");
		lblTeam.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblTeam.setBounds(245, 61, 136, 33);
		frame.getContentPane().add(lblTeam);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirm.setToolTipText("Confirm your selections");
		btnConfirm.setBackground(SystemColor.textHighlight);
		btnConfirm.setFont(new Font("Century Gothic", Font.BOLD, 22));
		btnConfirm.setBounds(396, 679, 175, 60);
		frame.getContentPane().add(btnConfirm);
		
		JTextArea txtrHeroNo = new JTextArea();
		txtrHeroNo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtrHeroNo.setText("1");
		txtrHeroNo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		txtrHeroNo.setBounds(814, 109, 23, 27);
		frame.getContentPane().add(txtrHeroNo);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(133, 232, 506, 338);
		frame.getContentPane().add(tabbedPane);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_2, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_3, null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_1, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(814, 562, 93, 89);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.LIGHT_GRAY);
		label.setOpaque(true);
		label.setToolTipText("2-10 characters long");
		label.setIcon(new ImageIcon(HeroSetupSCREEN.class.getResource("/Images/stickBKG.jpg")));
		label.setBounds(0, 0, 968, 755);
		frame.getContentPane().add(label);
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
}
