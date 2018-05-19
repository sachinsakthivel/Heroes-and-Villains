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
import java.awt.Component;
import java.awt.Point;

public class HeroSetupSCREEN {
	
	private String heroName = "";
	private int typePick = -1;

	JFrame frame;
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
				setHeroName(textField.getText());
			}
		});
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setDisabledTextColor(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setToolTipText("Enter a team name");
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		textField.setBackground(new Color(245, 245, 245));
		textField.setBounds(299, 133, 388, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblType = new JLabel("Hero Types");
		lblType.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblType.setBounds(406, 226, 132, 33);
		frame.getContentPane().add(lblType);
		
		JLabel lblTeam = new JLabel("Hero Name:");
		lblTeam.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblTeam.setBounds(173, 141, 136, 33);
		frame.getContentPane().add(lblTeam);
		
		JLabel lblerror = new JLabel("Incorrect Input, Please Select A Hero Type");
		lblerror.setVisible(false);
		lblerror.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblerror.setBounds(585, 691, 375, 40);
		frame.getContentPane().add(lblerror);
		
		JLabel lblerror1 = new JLabel("Incorrect Input, Please Type in A Hero Name");
		lblerror.setVisible(false);
		lblerror.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblerror.setBounds(585, 691, 375, 40);
		frame.getContentPane().add(lblerror);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (heroName == "") {
					lblerror.setVisible(false);
					lblerror1.setVisible(true);
				} else if (typePick == -1) {
					lblerror1.setVisible(false);
					lblerror.setVisible(true);
				}
			}
		});
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirm.setToolTipText("Confirm your selections");
		btnConfirm.setBackground(SystemColor.textHighlight);
		btnConfirm.setFont(new Font("Century Gothic", Font.BOLD, 22));
		btnConfirm.setBounds(396, 679, 175, 60);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblHeroCreation = new JLabel("Create Your Hero");
		lblHeroCreation.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblHeroCreation.setBounds(364, 22, 243, 85);
		frame.getContentPane().add(lblHeroCreation);
		
		JTextArea textArea = new JTextArea("Select a Hero Class");
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(160, 475, 651, 181);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Guardian");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Guardian.background() + "\n\n" + Guardian.getStats());
				typePick = 1;
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(225, 374, 149, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnKnight = new JButton("Knight");
		btnKnight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Knight.background() + "\n\n" + Knight.getStats());
				typePick = 2;
			}
		});
		btnKnight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKnight.setBounds(225, 277, 149, 60);
		frame.getContentPane().add(btnKnight);
		
		JButton btnJester = new JButton("Trickster");
		btnJester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Trickster.background() + "\n\n" + Trickster.getStats());
				typePick = 3;
			}
		});
		btnJester.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnJester.setBounds(396, 277, 149, 60);
		frame.getContentPane().add(btnJester);
		
		JButton btnWatchdog = new JButton("Watch Dog");
		btnWatchdog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(watchDog.background() + "\n\n" + watchDog.getStats());
				typePick = 4;
			}
		});
		btnWatchdog.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnWatchdog.setBounds(575, 277, 149, 60);
		frame.getContentPane().add(btnWatchdog);
		
		JButton btnNecromancer = new JButton("Necromancer");
		btnNecromancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Necromancer.background() + "\n\n" + Necromancer.getStats());
				typePick = 5;
			}
		});
		btnNecromancer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNecromancer.setBounds(575, 374, 149, 60);
		frame.getContentPane().add(btnNecromancer);
		
		JButton btnHealer = new JButton("Oracle");
		btnHealer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(Oracle.background() + "\n\n" + Oracle.getStats());
				typePick = 6;
				
			}
		});
		btnHealer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHealer.setBounds(396, 374, 149, 60);
		frame.getContentPane().add(btnHealer);
		

	}
	
	
	public void closeSCREEN() {
		frame.dispose();
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
}
