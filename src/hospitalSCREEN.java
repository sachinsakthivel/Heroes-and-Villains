import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hospitalSCREEN {

	private JFrame frame;
	private GameEnvironment game;
	private int itemIndex = -1;
	private int heroIndex = -1;
	private JTextArea txtheroStatus;
	private JTextArea txtItemStatus;
	private JTextArea txtrWelcomeToGeneral;
	private JButton btnHero1;
	private JButton btnHero2;
	private JButton btnHero3;

	/**
	 * Create the application.
	 */
	public hospitalSCREEN(GameEnvironment newGame) {
		game = newGame;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 902, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGeneralHospital = new JLabel("General Hospital");
		lblGeneralHospital.setBounds(306, 11, 248, 81);
		lblGeneralHospital.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		frame.getContentPane().add(lblGeneralHospital);
		
		JLabel label_1 = new JLabel("Hero Selection:");
		label_1.setBounds(10, 132, 214, 29);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		frame.getContentPane().add(label_1);
		
		JLabel lblHealingProcedure = new JLabel("Healing Procedure:");
		lblHealingProcedure.setBounds(10, 199, 214, 29);
		lblHealingProcedure.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealingProcedure.setFont(new Font("Dialog", Font.BOLD, 18));
		frame.getContentPane().add(lblHealingProcedure);
		
		txtheroStatus = new JTextArea();
		txtheroStatus.setBounds(18, 255, 206, 206);
		txtheroStatus.setWrapStyleWord(true);
		txtheroStatus.setText("Please Select a Hero.");
		txtheroStatus.setMargin(new Insets(10, 10, 10, 10));
		txtheroStatus.setLineWrap(true);
		txtheroStatus.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtheroStatus.setEditable(false);
		frame.getContentPane().add(txtheroStatus);
		
		txtItemStatus = new JTextArea();
		txtItemStatus.setBounds(666, 255, 203, 206);
		txtItemStatus.setWrapStyleWord(true);
		txtItemStatus.setText("Please Select a Healing Procedure");
		txtItemStatus.setMargin(new Insets(10, 10, 10, 10));
		txtItemStatus.setLineWrap(true);
		txtItemStatus.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtItemStatus.setEditable(false);
		frame.getContentPane().add(txtItemStatus);
		
		txtrWelcomeToGeneral = new JTextArea();
		txtrWelcomeToGeneral.setBounds(240, 255, 416, 206);
		txtrWelcomeToGeneral.setWrapStyleWord(true);
		txtrWelcomeToGeneral.setText("Welcome to General Hospital\r\n\r\nPick the Hero that you would like to Heal by pressing the respective button in Hero Selection.\r\n\r\nPick the Procedure that you would like to perform by pressing the respective button in Item Selection.");
		txtrWelcomeToGeneral.setMargin(new Insets(10, 10, 10, 10));
		txtrWelcomeToGeneral.setLineWrap(true);
		txtrWelcomeToGeneral.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		txtrWelcomeToGeneral.setEditable(false);
		frame.getContentPane().add(txtrWelcomeToGeneral);
		
		if (game.getParty().getTeam().size() >= 1) {
			btnHero1 = new JButton("Hero: "+game.getParty().getTeam().get(0).getPersonName());
			btnHero1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					heroIndex = 0;
					txtheroStatus.setText(game.getParty().getTeam().get(0).toString());
				}
			});
			btnHero1.setBounds(240, 126, 203, 43);
			btnHero1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(btnHero1);
		}
		
		if (game.getParty().getTeam().size() >= 2) {
			btnHero2 = new JButton("Hero: "+game.getParty().getTeam().get(1).getPersonName());
			btnHero2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					heroIndex = 1;
					txtheroStatus.setText(game.getParty().getTeam().get(1).toString());				}
			});
			btnHero2.setBounds(453, 126, 203, 43);
			btnHero2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(btnHero2);
		}
		if (game.getParty().getTeam().size() == 3) {
			btnHero3 = new JButton("Hero 3");
			btnHero3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					heroIndex = 2;
					txtheroStatus.setText(game.getParty().getTeam().get(2).toString());
				}
			});
			btnHero3.setBounds(666, 126, 203, 43);
			btnHero3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(btnHero3);
		}
		
		JButton btnHealHero = new JButton("Heal Hero");
		btnHealHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (heroIndex == -1) {
					txtrWelcomeToGeneral.setText("Please Select a Hero");
				} else if (itemIndex == -1) {
					txtrWelcomeToGeneral.setText("Please Select an Item");
				} else {
					HeroButtoninVisible(heroIndex);
					Hero chosenHero = game.getParty().getTeam().get(heroIndex);
					Item chosenItem = game.getParty().getInv().get(itemIndex);
					txtrWelcomeToGeneral.setText(game.getCurrentCity().getHospital().healingprocedure(game.getParty(), chosenHero, chosenItem));
					txtItemStatus.setText("Please Select an Item.");
					txtheroStatus.setText("Please Select a Hero.");
					itemIndex = -1;
					heroIndex = -1;
				}
			}
		});
		btnHealHero.setBounds(321, 472, 235, 57);
		btnHealHero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnHealHero);
		
		JButton btnlesser = new JButton("Lessser Heal Procedure");
		btnlesser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemIndex = 0;
				txtItemStatus.setText(game.getParty().getInv().get(0).toString());
			}
		});
		btnlesser.setBounds(240, 193, 203, 43);
		btnlesser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnlesser);
		
		JButton btnAverageHealProcedure = new JButton("Average Heal Procedure");
		btnAverageHealProcedure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemIndex = 1;
				txtItemStatus.setText(game.getParty().getInv().get(1).toString());
			}
		});
		btnAverageHealProcedure.setBounds(453, 193, 203, 43);
		btnAverageHealProcedure.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnAverageHealProcedure);
		
		JButton btnGreaterHealTicket = new JButton("Greater Heal Procedure");
		btnGreaterHealTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemIndex = 2;
				txtItemStatus.setText(game.getParty().getInv().get(2).toString());
			}
		});
		btnGreaterHealTicket.setBounds(666, 193, 203, 43);
		btnGreaterHealTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnGreaterHealTicket);
		
		
		JButton btnGoToWard = new JButton("Go to Ward\r\n");
		btnGoToWard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hurtHeroes = game.getCurrentCity().getHospital().visitWard(game.getParty().getWard());
				txtrWelcomeToGeneral.setText(hurtHeroes);
			}
		});
		btnGoToWard.setBounds(666, 472, 206, 57);
		btnGoToWard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnGoToWard);
		
		JButton btnReturnToHomebase = new JButton("Return to Homebase");
		btnReturnToHomebase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnReturnToHomebase.setBounds(18, 472, 206, 57);
		btnReturnToHomebase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnReturnToHomebase);
		

	}
	
	public void HeroButtoninVisible(int heroIndex) {
		if (heroIndex == 0) {
			btnHero1.setVisible(false);
		} else if (heroIndex == 1) {
			btnHero2.setVisible(false);
		} else {
			btnHero3.setVisible(false);
		}
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeHospitalSCREEN(game.getHomeBase(),this);
	}
	
}
