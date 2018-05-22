import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class diceRollsSCREEN {

	private JFrame frame;
	private GameEnvironment game;
	private Hero hero;
	private Villain villain;
	private JTextArea textArea;
	private diceRolls dice;
	private JButton btnHeroSelect;
	private JButton btnRoll;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					diceRollsSCREEN window = new diceRollsSCREEN();
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
	public diceRollsSCREEN(GameEnvironment newGame, Hero chosenHero) {
		initialize();
		game = newGame;
		hero = chosenHero;
		villain = game.getCurrentCity().getVillainsLair().getVillain();
		dice = new diceRolls();
		textArea.setText(dice.gameDescription());
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 916, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbltitle = new JLabel("Dice Rolls");
		lbltitle.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lbltitle.setBounds(368, 22, 191, 59);
		frame.getContentPane().add(lbltitle);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		textArea.setBounds(108, 97, 711, 182);
		frame.getContentPane().add(textArea);
		
		btnRoll = new JButton("Roll Dices!!");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean gameWon = dice.play(hero);
				game.getCurrentCity().getVillainsLair().gameResults(gameWon, hero, villain, game);
				textArea.setText(dice.results());
				btnHeroSelect.setVisible(true);
				btnRoll.setVisible(false);
				
			}
		});
		btnRoll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRoll.setBounds(340, 325, 235, 57);
		frame.getContentPane().add(btnRoll);
		
		btnHeroSelect = new JButton("Return to Hero Select");
		btnHeroSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
				game.getParty().checkDead(game);
				if (villain.checkdeath(game)) {
					closeSCREEN();
					game.getHomeBase().runAgain();
				}
			}
		});
		btnHeroSelect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHeroSelect.setBounds(340, 325, 235, 57);
		frame.getContentPane().add(btnHeroSelect);
		btnHeroSelect.setVisible(false);
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeDiceRollsSCREEN(this);
	}
	
	
}
