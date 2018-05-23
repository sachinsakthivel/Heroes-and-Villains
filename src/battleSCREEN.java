import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class battleSCREEN {

	private JFrame frame;
	private GameEnvironment game;
	private VillainsLair villainsLair;
	private JTextArea txtrVillain;
	private JTextArea txtrHeroDescription;
	private JTextArea txtrVillainDescription;
	private int HeroIndex = -1;
	private int gameChoice;
	private JLabel lblerror;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					battleSCREEN window = new battleSCREEN();
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
	public battleSCREEN(GameEnvironment newGame) {
		game = newGame;
		villainsLair = game.getCurrentCity().getVillainsLair();
		gameChoice = 1; /*villainsLair.getVillain().gamePreference();*/
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 895, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("DEATH BATTLE!");
		titleLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		titleLabel.setBounds(340, 11, 220, 84);
		frame.getContentPane().add(titleLabel);
		
		txtrVillain = new JTextArea();
		txtrVillain.setLineWrap(true);
		txtrVillain.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtrVillain.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		txtrVillain.setEditable(false);
		txtrVillain.setWrapStyleWord(true);
		txtrVillain.setText(villainsLair.getVillain().toString());
		txtrVillain.setBounds(106, 91, 681, 108);
		frame.getContentPane().add(txtrVillain);
		
		JLabel label = new JLabel("Hero Selection:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(20, 210, 214, 29);
		frame.getContentPane().add(label);
		
		if (game.getParty().getTeam().size()  >= 1) {
			JButton button = new JButton("Hero: " + game.getParty().getTeam().get(0).getPersonName());
			button.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HeroIndex = 0;
					txtrHeroDescription.setText(game.getParty().getTeam().get(0).toString());	
				}
			});
			button.setFont(new Font("Tahoma", Font.PLAIN, 14));
			button.setBounds(20, 250, 206, 43);
			frame.getContentPane().add(button);
			
		}
		
		if (game.getParty().getTeam().size()  >= 2) {
			JButton button_1 = new JButton("Hero: " + game.getParty().getTeam().get(1).getPersonName());
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HeroIndex = 1;
					txtrHeroDescription.setText(game.getParty().getTeam().get(1).toString());
					
				}
			});
			button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			button_1.setBounds(20, 324, 206, 43);
			frame.getContentPane().add(button_1);
		}
		
		if (game.getParty().getTeam().size()  == 3) {
			JButton button_2 = new JButton("Hero: "+ game.getParty().getTeam().get(2).getPersonName());
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HeroIndex = 2;
					txtrHeroDescription.setText(game.getParty().getTeam().get(2).toString());
				}
			});
			button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			button_2.setBounds(20, 398, 206, 43);
			frame.getContentPane().add(button_2);
		}
		
		JButton btnReturnToLair = new JButton("Return to Lair Entrance");
		btnReturnToLair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnReturnToLair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReturnToLair.setBounds(20, 528, 235, 57);
		frame.getContentPane().add(btnReturnToLair);
		
		JButton btnFightVillain = new JButton("Fight Villain\r\n");
		btnFightVillain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				battle(HeroIndex, gameChoice, game);
				}
		});
		btnFightVillain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFightVillain.setBounds(619, 528, 235, 57);
		frame.getContentPane().add(btnFightVillain);
		
		txtrHeroDescription = new JTextArea();
		txtrHeroDescription.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtrHeroDescription.setText("Select a Hero");
		txtrHeroDescription.setBounds(270, 250, 214, 191);
		frame.getContentPane().add(txtrHeroDescription);
		
		txtrVillainDescription = new JTextArea();
		txtrVillainDescription.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtrVillainDescription.setText(villainsLair.villainInsight() + "\nChosen Game to Play: " +villainsLair.getGames().get(gameChoice).getGameName());
		txtrVillainDescription.setBounds(517, 250, 337, 191);
		frame.getContentPane().add(txtrVillainDescription);
		
		JLabel lblVillaindescription = new JLabel("Knowledge About Villain:\r\n");
		lblVillaindescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillaindescription.setFont(new Font("Dialog", Font.BOLD, 18));
		lblVillaindescription.setBounds(575, 210, 235, 29);
		frame.getContentPane().add(lblVillaindescription);
		
		JLabel label_1 = new JLabel("Hero Selection:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		label_1.setBounds(270, 210, 214, 29);
		frame.getContentPane().add(label_1);
		
		lblerror = new JLabel("Please Select a Hero");
		lblerror.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblerror.setForeground(Color.RED);
		lblerror.setBounds(654, 489, 255, 29);
		lblerror.setVisible(false);
		frame.getContentPane().add(lblerror);
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeBattleSCREEN(this);
	}
	
	public void battle(int heroIndex, int gameChoice, GameEnvironment game) {
		if (heroIndex == -1) {
			lblerror.setVisible(true);
		} else {
			Hero chosenHero = game.getParty().getTeam().get(HeroIndex);
			if (gameChoice == 0) {
				game.launchDiceRollsSCREEN(chosenHero);
			} else if (gameChoice == 1) {
				game.launchRockPaperSCREEN(chosenHero);
			} else {
				
				txtrVillainDescription.setText("guess not implemented yet");
			}
			closeSCREEN();
		}
	}
}
