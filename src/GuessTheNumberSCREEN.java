import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessTheNumberSCREEN {

	private JFrame frame;
	private GameEnvironment game;
	private guessTheNumber GuessGame;
	private Hero hero;
	private Villain villain;
	private JTextArea textArea;
	private JSlider UGuessSlider;
	private JLabel lblLower;
	private JLabel lblHigher;
	private JButton Continue;
	private int UserGuess;
	private boolean gameWon = false;
	private boolean Higher;
	private int tryNo = 0;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuessTheNumberSCREEN window = new GuessTheNumberSCREEN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public GuessTheNumberSCREEN(GameEnvironment newGame, Hero chosenHero) {
		initialize();
		game = newGame;
		hero = chosenHero;
		villain = game.getCurrentCity().getVillainsLair().getVillain();
		textArea.setText(GuessGame.gameDescription());
		
		JButton button = new JButton("Did you Guess ...");
		button.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		button.setBounds(381, 571, 235, 57);
		frame.getContentPane().add(button);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		frame.setResizable(false);
		frame.setBounds(100, 100, 983, 787);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGuessTheNumber = new JLabel("Guess the Number");
		lblGuessTheNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessTheNumber.setFont(new Font("Tw Cen MT", Font.PLAIN, 32));
		lblGuessTheNumber.setBounds(350, 52, 296, 59);
		frame.getContentPane().add(lblGuessTheNumber);

		UGuessSlider = new JSlider();
		UGuessSlider.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		UGuessSlider.setPaintTicks(true);
		UGuessSlider.setPaintLabels(true);
		UGuessSlider.setMajorTickSpacing(1);
		UGuessSlider.setMaximum(12);
		UGuessSlider.setBounds(156, 445, 684, 44);
		frame.getContentPane().add(UGuessSlider);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(143, 129, 711, 204);
		frame.getContentPane().add(textArea);
		
		JButton btnIGuess = new JButton("Did you Guess ...");
		btnIGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserGuess = UGuessSlider.getValue();
				while(gameWon == false) {
					if (tryNo >= 2) {
						gameWon = false;
						break;
					}
					tryNo++;
					gameWon = GuessGame.play(hero, UserGuess);
					Higher = GuessGame.GetHighOrNot();
					if (gameWon == true) {
						textArea.setText("Pathetic, you need to guess Higher");

					}
					if (Higher == true) {
						lblHigher.setVisible(true);
						textArea.setText("Pathetic, you need to guess Higher");
					} else {
						lblLower.setVisible(false);
						textArea.setText("Too fast for you boi, guess Lower");
					}
				}
			}
		});
		btnIGuess.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnIGuess.setBounds(645, 571, 235, 57);
		frame.getContentPane().add(btnIGuess);
		
		lblLower = new JLabel("Lower");
		lblLower.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblLower.setHorizontalAlignment(SwingConstants.CENTER);
		lblLower.setBounds(279, 408, 106, 27);
		lblLower.setVisible(false);
		frame.getContentPane().add(lblLower);
		
		lblHigher = new JLabel("Higher");
		lblHigher.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblHigher.setHorizontalAlignment(SwingConstants.CENTER);
		lblHigher.setBounds(613, 408, 106, 27);
		lblHigher.setVisible(false);
		frame.getContentPane().add(lblHigher);
		
		Continue = new JButton("Return to Hero Selction");
		Continue.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		Continue.setBounds(645, 571, 235, 57);
		frame.getContentPane().add(Continue);
		
		
		
		
	}
}
