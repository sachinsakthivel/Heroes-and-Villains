import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PowerUpSCREEN {

	private JFrame frame;
	private GameEnvironment game;
	private JTextArea txtHeroDescription;
	private JTextArea txtItemDescription;
	private JTextArea txtoutputBox;
	private int itemIndex = -1;
	private int heroIndex = -1;
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
		
		JButton btnHero1 = new JButton("Hero: " + game.getParty().getTeam().get(0).getPersonName());
		btnHero1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heroIndex = 0;
				txtHeroDescription.setText(game.getParty().getTeam().get(0).toString());
			}
		});
		btnHero1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHero1.setBounds(20, 150, 206, 43);
		frame.getContentPane().add(btnHero1);
		
		if (game.getParty().getTeam().size()  >= 2) {
			JButton btnHero2 = new JButton("Hero: " + game.getParty().getTeam().get(1).getPersonName());
			btnHero2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					heroIndex = 1;
					txtHeroDescription.setText(game.getParty().getTeam().get(1).toString());
				}
			});
			btnHero2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnHero2.setBounds(20, 235, 206, 43);
			frame.getContentPane().add(btnHero2);
		}

		if (game.getParty().getTeam().size() == 3) {
			JButton btnHero3 = new JButton("Hero: " + game.getParty().getTeam().get(2).getPersonName());
			btnHero3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					heroIndex = 2;
					txtHeroDescription.setText(game.getParty().getTeam().get(2).toString());
				}
			});
			btnHero3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnHero3.setBounds(20, 312, 206, 43);
			frame.getContentPane().add(btnHero3);
		}
		
		JButton btnArmour = new JButton("Armour Pieces");
		btnArmour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				itemIndex = 4;
				txtItemDescription.setText(game.getParty().getInv().get(4).toString());
			}
		});
		btnArmour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnArmour.setBounds(682, 150, 206, 43);
		frame.getContentPane().add(btnArmour);
		
		JButton btnriggedDice = new JButton("Weighted Dice");
		btnriggedDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				itemIndex = 5;
				txtItemDescription.setText(game.getParty().getInv().get(5).toString());
			}
		});
		btnriggedDice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnriggedDice.setBounds(682, 204, 206, 43);
		frame.getContentPane().add(btnriggedDice);
		
		JButton btnMaxhealthup = new JButton("MaxHealthUp Potions");
		btnMaxhealthup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemIndex = 6;
				txtItemDescription.setText(game.getParty().getInv().get(6).toString());
			}
		});
		btnMaxhealthup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMaxhealthup.setBounds(682, 312, 206, 43);
		frame.getContentPane().add(btnMaxhealthup);
		
		JButton btnSkill = new JButton("Hypnotic Suggestion Skill");
		btnSkill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemIndex = 7;
				txtItemDescription.setText(game.getParty().getInv().get(7).toString());
			}
		});
		btnSkill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSkill.setBounds(682, 258, 206, 43);
		frame.getContentPane().add(btnSkill);
		
		JButton btnPowerUP = new JButton("Power Up Hero");
		btnPowerUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (heroIndex == -1) {
					txtoutputBox.setText("Please Select a Hero");
				} else if (itemIndex == -1) {
					txtoutputBox.setText("Please Select an Item");
				} else {
					Hero chosenHero = game.getParty().getTeam().get(heroIndex);
					Item chosenItem = game.getParty().getInv().get(itemIndex);
					txtoutputBox.setText(chosenItem.use(chosenHero));
					txtItemDescription.setText("Please Select an Item.");
					txtHeroDescription.setText("Please Select a Hero.");
					itemIndex = -1;
					heroIndex = -1;
				}
			}
		});
		btnPowerUP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPowerUP.setBounds(341, 386, 235, 57);
		frame.getContentPane().add(btnPowerUP);
		
		JButton btnTravelHome = new JButton("Travel Back To Home Base");
		btnTravelHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
			}
		});
		btnTravelHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTravelHome.setBounds(341, 485, 235, 57);
		frame.getContentPane().add(btnTravelHome);
		
		txtHeroDescription = new JTextArea();
		txtHeroDescription.setWrapStyleWord(true);
		txtHeroDescription.setEditable(false);
		txtHeroDescription.setLineWrap(true);
		txtHeroDescription.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtHeroDescription.setText("Please Select a Hero.");
		txtHeroDescription.setBounds(20, 366, 248, 206);
		frame.getContentPane().add(txtHeroDescription);
		
		txtItemDescription = new JTextArea();
		txtItemDescription.setWrapStyleWord(true);
		txtItemDescription.setEditable(false);
		txtItemDescription.setLineWrap(true);
		txtItemDescription.setText("Please Select an Item.");
		txtItemDescription.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtItemDescription.setBounds(640, 366, 245, 206);
		frame.getContentPane().add(txtItemDescription);
		
		txtoutputBox = new JTextArea();
		txtoutputBox.setWrapStyleWord(true);
		txtoutputBox.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtoutputBox.setLineWrap(true);
		txtoutputBox.setText("Howdy y'all, Welcome to Miky's Workshop and Upgrade Station!!\r\n\r\nPick the Hero that you would like to Power up by pressing the respective button in Hero Selection.\r\n\r\nPick the Item that you would like to use by pressing the respective button in Item Selection.");
		txtoutputBox.setBounds(236, 150, 436, 205);
		frame.getContentPane().add(txtoutputBox);
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closePowerUpSCREEN(game.getHomeBase(),this);
	}
	
	
}
