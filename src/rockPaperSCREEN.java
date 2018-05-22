import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rockPaperSCREEN {

	private JFrame frame;
	private GameEnvironment game;
	private Hero hero;
	private Villain villain;
	private JTextArea textArea;
	private rockPaperScissors RPS;
	private JButton btnReturnToHero;
	private JButton btnScissors;
	private JButton btnPaper;
	private JButton btnRock;
	private int userPick;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rockPaperSCREEN window = new rockPaperSCREEN();
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
	public rockPaperSCREEN(GameEnvironment newGame, Hero chosenHero) {
		initialize();
		game = newGame;
		hero = chosenHero;
		villain = game.getCurrentCity().getVillainsLair().getVillain();
		RPS = new rockPaperScissors();
		textArea.setText(RPS.gameDescription());
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 866, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRockPaperScissors = new JLabel("Rock Paper Scissors");
		lblRockPaperScissors.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblRockPaperScissors.setBounds(294, 11, 296, 59);
		frame.getContentPane().add(lblRockPaperScissors);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(69, 81, 711, 182);
		frame.getContentPane().add(textArea);
		
		btnRock = new JButton("Rock");
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userPick = 3;
				boolean gameWon = RPS.play(hero, userPick);
				game.getCurrentCity().getVillainsLair().gameResults(gameWon, hero, villain, game);
				textArea.setText(RPS.results());
				visibleButtons();
			}
		});
		btnRock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRock.setBounds(23, 332, 235, 57);
		frame.getContentPane().add(btnRock);
		
		btnPaper = new JButton("Paper");
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userPick = 1;
				boolean gameWon = RPS.play(hero, userPick);
				game.getCurrentCity().getVillainsLair().gameResults(gameWon, hero, villain, game);
				textArea.setText(RPS.results());
				visibleButtons();
			}
		});
		btnPaper.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPaper.setBounds(317, 332, 235, 57);
		frame.getContentPane().add(btnPaper);
		
		btnScissors = new JButton("Scissors");
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userPick = 2;
				boolean gameWon = RPS.play(hero, userPick);
				game.getCurrentCity().getVillainsLair().gameResults(gameWon, hero, villain, game);
				textArea.setText(RPS.results());
				visibleButtons();
			}
		});
		btnScissors.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnScissors.setBounds(595, 332, 235, 57);
		frame.getContentPane().add(btnScissors);
		
		btnReturnToHero = new JButton("Return to Hero Select");
		btnReturnToHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
				game.getParty().checkDead(game);
				if (villain.checkdeath(game)) {
					closeSCREEN();
					game.getHomeBase().runAgain();
				}
			}
		});
		btnReturnToHero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReturnToHero.setBounds(317, 332, 235, 57);
		frame.getContentPane().add(btnReturnToHero);
		btnReturnToHero.setVisible(false);
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeDiceRollsSCREEN(this);
	}
	
	public void visibleButtons() {
		btnRock.setVisible(false);
		btnPaper.setVisible(false);
		btnScissors.setVisible(false);
		btnReturnToHero.setVisible(true);
	}
}
