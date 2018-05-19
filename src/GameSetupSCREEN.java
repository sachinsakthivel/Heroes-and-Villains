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

public class GameSetupSCREEN {
	
	private static String TeamName = "TestName";

	JFrame frame;
	private JTextField textField;
	private JLabel lblNoOfCities;
	


	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public GameSetupSCREEN() {
		initialize();
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
		slider.setBorder(new LineBorder(new Color(0, 0, 0)));
		slider.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(3);
		slider.setMaximum(6);
		slider.setBounds(504, 189, 288, 67);
		frame.getContentPane().add(slider);
		
		JLabel lblerror = new JLabel("Team name should be between 2-10");
		lblerror.setVisible(false);
		lblerror.setHorizontalTextPosition(SwingConstants.CENTER);
		lblerror.setForeground(Color.RED);
		lblerror.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblerror.setBounds(316, 404, 269, 40);
		frame.getContentPane().add(lblerror);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TeamName.length() < 2 || TeamName.length() > 10) {
					lblerror.setVisible(true);
				} else {
					GameEnvironment.launchHeroSetupSCREEN();
					closeSCREEN();
				}
				
			}
		});
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirm.setToolTipText("Confirm your selections");
		btnConfirm.setBackground(SystemColor.textHighlight);
		btnConfirm.setFont(new Font("Century Gothic", Font.BOLD, 22));
		btnConfirm.setBounds(396, 483, 175, 60);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblTeam = new JLabel("Team Name:");
		lblTeam.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblTeam.setBounds(349, 137, 145, 33);
		frame.getContentPane().add(lblTeam);
		
		JLabel lblNoOfHeroes = new JLabel("No. of heroes in your team:");
		lblNoOfHeroes.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNoOfHeroes.setBounds(204, 278, 294, 33);
		frame.getContentPane().add(lblNoOfHeroes);
		
		JSlider slider_1 = new JSlider();
		slider_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		slider_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinimum(1);
		slider_1.setMaximum(3);
		slider_1.setMajorTickSpacing(1);
		slider_1.setBounds(504, 267, 288, 68);
		frame.getContentPane().add(slider_1);
		
		lblNoOfCities = new JLabel("No of cities you would like to explore:");
		lblNoOfCities.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNoOfCities.setBounds(90, 205, 408, 33);
		frame.getContentPane().add(lblNoOfCities);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.LIGHT_GRAY);
		label.setOpaque(true);
		label.setToolTipText("2-10 characters long");
		label.setIcon(new ImageIcon(GameSetupSCREEN.class.getResource("/Images/stickBKG.jpg")));
		label.setBounds(0, 0, 968, 755);
		frame.getContentPane().add(label);
	}
	
	public static String getTeamName() {
		return TeamName;
	}
		
	public void closeSCREEN() {
		frame.dispose();
	}
}
