import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Scanner;

import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class GameSetupSCREEN {

	private String TeamName = "";
	private int NoCities = -5;
	private int NoHeroes = -1;

	JFrame frame;
	private JTextField textField;
	private GameEnvironment game;
	private JSlider citySlide;
	private JSlider heroSlide;
	


	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameSetupSCREEN window = new GameSetupSCREEN();
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
	public GameSetupSCREEN(GameEnvironment newGame) {
		initialize();
		game = newGame;
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 983, 787);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TeamName = textField.getText();
			}
		});
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setDisabledTextColor(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setToolTipText("Enter a team name between 2-10 characters.");
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		textField.setBackground(new Color(245, 245, 245));
		textField.setBounds(504, 127, 288, 53);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		citySlide = new JSlider();
		citySlide.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		citySlide.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				NoCities = citySlide.getValue();
			}
		});
		citySlide.setBorder(new LineBorder(new Color(0, 0, 0)));
		citySlide.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		citySlide.setPaintLabels(true);
		citySlide.setPaintTicks(true);
		citySlide.setMajorTickSpacing(1);
		citySlide.setMinimum(3);
		citySlide.setMaximum(6);
		citySlide.setBounds(504, 189, 288, 67);
		frame.getContentPane().add(citySlide);
		
		JLabel lblerror = new JLabel("Team name should be between 2-10 Characters ");
		lblerror.setHorizontalAlignment(SwingConstants.CENTER);
		lblerror.setVisible(false);
		lblerror.setHorizontalTextPosition(SwingConstants.CENTER);
		lblerror.setForeground(Color.RED);
		lblerror.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblerror.setBounds(204, 433, 595, 40);
		frame.getContentPane().add(lblerror);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TeamName = textField.getText();
				if (TeamName.length() < 2 || TeamName.length() > 10) {
					lblerror.setVisible(true);
				}else {
					finishedWindow();
				}
				
				
			}
		});
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirm.setToolTipText("Confirm your selections");
		btnConfirm.setBackground(Color.LIGHT_GRAY);
		btnConfirm.setFont(new Font("Century Gothic", Font.BOLD, 22));
		btnConfirm.setBounds(396, 483, 175, 60);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblTeam = new JLabel("Team Name:");
		lblTeam.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblTeam.setBounds(349, 137, 145, 33);
		frame.getContentPane().add(lblTeam);
		
		JLabel lblNoOfHeroes = new JLabel("Number of Heroes in your Team:");
		lblNoOfHeroes.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNoOfHeroes.setBounds(140, 278, 358, 33);
		frame.getContentPane().add(lblNoOfHeroes);
		
		heroSlide = new JSlider();
		heroSlide.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				NoHeroes = heroSlide.getValue();
			}
		});
		heroSlide.setBorder(new LineBorder(new Color(0, 0, 0)));
		heroSlide.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		heroSlide.setPaintTicks(true);
		heroSlide.setPaintLabels(true);
		heroSlide.setValue(1);
		heroSlide.setMinimum(1);
		heroSlide.setMaximum(3);
		heroSlide.setMajorTickSpacing(1);
		heroSlide.setBounds(504, 267, 288, 68);
		frame.getContentPane().add(heroSlide);
		
		JLabel lblNoOfCities = new JLabel("Number of Cities you would like to explore:");
		lblNoOfCities.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNoOfCities.setBounds(39, 205, 459, 33);
		frame.getContentPane().add(lblNoOfCities);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.LIGHT_GRAY);
		label.setOpaque(true);
		label.setToolTipText("2-10 characters long");
		label.setIcon(new ImageIcon(GameSetupSCREEN.class.getResource("/Images/stickBKG.jpg")));
		label.setBounds(0, 0, 968, 755);
		frame.getContentPane().add(label);
	}
	
	public void setTeamName(String TeamName) {
		this.TeamName = TeamName;
	}
	
	public String getTeamName() {
		return TeamName;
	}
	
	public int getNoCities() {
		return NoCities;
	}
	
	public int getNoHeroes() {
		return NoHeroes;
	}
		
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeSetupScreen(this);
	}
	
	
}
