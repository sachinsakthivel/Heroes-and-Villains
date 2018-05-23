import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JButton;

public class GuessTheNumberSCREEN {

	private JFrame frame;
	private GameEnvironment game;
	private Hero hero;
	private Villain villain;
	private JTextArea textArea;
	private JSlider slider;
	private guessTheNumber GuessGame;

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
		
		slider = new JSlider();
		slider.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMaximum(12);
		slider.setBounds(156, 445, 684, 44);
		frame.getContentPane().add(slider);
		
		JLabel lblGuessTheNumber = new JLabel("Guess the Number");
		lblGuessTheNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessTheNumber.setFont(new Font("Tw Cen MT", Font.PLAIN, 32));
		lblGuessTheNumber.setBounds(350, 52, 296, 59);
		frame.getContentPane().add(lblGuessTheNumber);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(143, 129, 711, 204);
		frame.getContentPane().add(textArea);
		
		JLabel lblLower = new JLabel("Lower");
		lblLower.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblLower.setHorizontalAlignment(SwingConstants.CENTER);
		lblLower.setBounds(279, 408, 106, 27);
		frame.getContentPane().add(lblLower);
		
		JLabel lblHigher = new JLabel("Higher");
		lblHigher.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblHigher.setHorizontalAlignment(SwingConstants.CENTER);
		lblHigher.setBounds(613, 408, 106, 27);
		frame.getContentPane().add(lblHigher);
		
		JButton btnIGuess = new JButton("Did you Guess ...");
		btnIGuess.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		btnIGuess.setBounds(381, 571, 235, 57);
		frame.getContentPane().add(btnIGuess);
		
		
	}
}
