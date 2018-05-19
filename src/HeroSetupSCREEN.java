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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;

public class HeroSetupSCREEN {
	
	private String heroName = "";

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
	 * Getter for frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	 
	/**
	 * setter for frame
	 * @param newframe
	 */
	public void setFrame(JFrame newframe)  {
		frame = newframe;
		
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
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				heroName = textField.getText();
			}
		});
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setDisabledTextColor(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setToolTipText("Enter a team name");
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		textField.setBackground(new Color(245, 245, 245));
		textField.setBounds(302, 207, 388, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblType = new JLabel("Class:");
		lblType.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblType.setBounds(287, 311, 79, 33);
		frame.getContentPane().add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tank", "Necromancer", "Healer", "Gambler", "Guardian", "Ninja"}));
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		comboBox.setToolTipText("Select a hero type");
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setBounds(364, 308, 288, 42);
		frame.getContentPane().add(comboBox);
		
		JLabel lblTeam = new JLabel("Hero Name:");
		lblTeam.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblTeam.setBounds(170, 215, 136, 33);
		frame.getContentPane().add(lblTeam);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirm.setToolTipText("Confirm your selections");
		btnConfirm.setBackground(SystemColor.textHighlight);
		btnConfirm.setFont(new Font("Century Gothic", Font.BOLD, 22));
		btnConfirm.setBounds(396, 679, 175, 60);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblHeroCreation = new JLabel("Create Your Hero");
		lblHeroCreation.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblHeroCreation.setBounds(364, 50, 243, 85);
		frame.getContentPane().add(lblHeroCreation);
		
		JTextArea textArea = new JTextArea(Tank.background() + "\n\n" + Tank.getStats());
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(173, 414, 651, 233);
		frame.getContentPane().add(textArea);
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
}
