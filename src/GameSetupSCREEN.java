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
	private int NoCities = -1;
	private int NoHeroes = -1;

	JFrame frame;
	private JTextField textField;
	private GameEnvironment game;
	


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
				TeamName = textField.getText();
			}
		});
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setDisabledTextColor(Color.LIGHT_GRAY);
		textField.setForeground(Color.BLACK);
		textField.setToolTipText("Enter a team name");
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		textField.setBackground(new Color(245, 245, 245));
		textField.setBounds(504, 127, 288, 53);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				NoCities = slider.getValue();
			}
		});
		slider.setBorder(new LineBorder(new Color(0, 0, 0)));
		slider.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(3);
		slider.setMaximum(6);
		slider.setBounds(504, 189, 288, 67);
		frame.getContentPane().add(slider);
		
		JLabel lblerror = new JLabel("Team name should be between 2-10 Characters and please Press Enter");
		lblerror.setVisible(false);
		lblerror.setHorizontalTextPosition(SwingConstants.CENTER);
		lblerror.setForeground(Color.RED);
		lblerror.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblerror.setBounds(204, 433, 595, 40);
		frame.getContentPane().add(lblerror);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TeamName.length() < 2 || TeamName.length() > 10) {
					lblerror.setVisible(true);
				}else {
					createTeam();
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
		
		JSlider slider_1 = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				NoHeroes = slider.getValue();
			}
		});
		slider_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		slider_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinimum(1);
		slider_1.setMaximum(3);
		slider_1.setMajorTickSpacing(1);
		slider_1.setBounds(504, 267, 288, 68);
		frame.getContentPane().add(slider_1);
		
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
	
	public void createTeam() {
		game.setCityNum(NoCities);
		Team team = new Team(TeamName, NoHeroes);
		game.setTeam(team);
	}
	
	
}
