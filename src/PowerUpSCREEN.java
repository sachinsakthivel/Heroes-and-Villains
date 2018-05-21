import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PowerUpSCREEN {

	private JFrame frame;
	private GameEnvironment game;
	private JButton btnHero1;
	private JButton btnHero2;
	private JButton btnHero3;
	JTextArea txtHeroDescription;

	

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PowerUpSCREEN window = new PowerUpSCREEN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 */
	public PowerUpSCREEN(GameEnvironment newGame) {
		game = newGame;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 923, 629);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel screenTitle = new JLabel("Mikey's Workshop");
		screenTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		screenTitle.setBounds(341, 11, 248, 102);
		frame.getContentPane().add(screenTitle);
		
		JLabel lblHeroSelection = new JLabel("Hero Selection:");
		lblHeroSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeroSelection.setFont(new Font("Dialog", Font.BOLD, 18));
		lblHeroSelection.setBounds(20, 110, 214, 29);
		frame.getContentPane().add(lblHeroSelection);

		
		JLabel lbItemSelection = new JLabel("Item Selection:");
		lbItemSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lbItemSelection.setFont(new Font("Dialog", Font.BOLD, 18));
		lbItemSelection.setBounds(640, 110, 214, 29);
		frame.getContentPane().add(lbItemSelection);
		
		btnHero1 = new JButton("Hero NO.1");
		btnHero1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHero1.setBounds(20, 150, 206, 43);
		frame.getContentPane().add(btnHero1);
		
		btnHero2 = new JButton("Hero NO.2");
		btnHero2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHero2.setBounds(20, 235, 206, 43);
		frame.getContentPane().add(btnHero2);
		
		btnHero3 = new JButton("Hero NO.3");
		btnHero3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHero3.setBounds(20, 312, 206, 43);
		frame.getContentPane().add(btnHero3);
		
		JButton btnArmour = new JButton("Armour");
		btnArmour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnArmour.setBounds(682, 150, 206, 43);
		frame.getContentPane().add(btnArmour);
		
		JButton btnriggedDice = new JButton("Weighted Dice");
		btnriggedDice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnriggedDice.setBounds(682, 204, 206, 43);
		frame.getContentPane().add(btnriggedDice);
		
		JButton btnMaxhealthup = new JButton("MaxHealthUp Potions");
		btnMaxhealthup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMaxhealthup.setBounds(682, 312, 206, 43);
		frame.getContentPane().add(btnMaxhealthup);
		
		JButton btnSkill = new JButton("Hypnotic Suggestion Skill");
		btnSkill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSkill.setBounds(682, 258, 206, 43);
		frame.getContentPane().add(btnSkill);
		
		JButton btnPowerUP = new JButton("Power Up Hero");
		btnPowerUP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPowerUP.setBounds(341, 386, 235, 57);
		frame.getContentPane().add(btnPowerUP);
		
		JButton btnTravelHome = new JButton("Travel Back To Home Base");
		btnTravelHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTravelHome.setBounds(341, 485, 235, 57);
		frame.getContentPane().add(btnTravelHome);
		
		JTextArea txtHeroDescription = new JTextArea();
		txtHeroDescription.setEditable(false);
		txtHeroDescription.setLineWrap(true);
		txtHeroDescription.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtHeroDescription.setText("Please Select a Hero");
		txtHeroDescription.setBounds(20, 366, 203, 206);
		frame.getContentPane().add(txtHeroDescription);
		
		JTextArea txtItemDescription = new JTextArea();
		txtItemDescription.setEditable(false);
		txtItemDescription.setLineWrap(true);
		txtItemDescription.setText("Please Select an Item");
		txtItemDescription.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtItemDescription.setBounds(682, 366, 203, 206);
		frame.getContentPane().add(txtItemDescription);
		
		JTextArea txtrHowdyYallWelcome = new JTextArea();
		txtrHowdyYallWelcome.setWrapStyleWord(true);
		txtrHowdyYallWelcome.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtrHowdyYallWelcome.setLineWrap(true);
		txtrHowdyYallWelcome.setText("Howdy y'all, Welcome to Miky's Workshop and Upgrade Station!!\r\n\r\nPick the Hero that you would like to Power up by pressing the respective button in Hero Selection.\r\n\r\nPick the Item that you would like to use by pressing the respective button in Item Selection.");
		txtrHowdyYallWelcome.setBounds(236, 150, 436, 205);
		frame.getContentPane().add(txtrHowdyYallWelcome);
	}
}
