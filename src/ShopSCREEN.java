import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopSCREEN {

	private JFrame frame;
	
	private String DisplayText;
	private GameEnvironment game;


	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopSCREEN window = new ShopSCREEN();
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
	public ShopSCREEN(GameEnvironment newGame) {
		game = newGame;
		initialize();
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
		
		JTextArea outputBox = new JTextArea("Text display");
		outputBox.setWrapStyleWord(true);
		outputBox.setLineWrap(true);
		outputBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		outputBox.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		outputBox.setBounds(215, 493, 608, 246);
		frame.getContentPane().add(outputBox);
		
		
		//Buttons for Items in shop
		
		//LesserHeal Button
		JButton btnLesserHeal = new JButton("Lesser Heal");
		btnLesserHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getTeam().getInv().get(0).getItemDescription());
			}
		});
		btnLesserHeal.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnLesserHeal.setBounds(48, 29, 183, 48);
		frame.getContentPane().add(btnLesserHeal);
		
		//Average Heal Button
		JButton btnAverageHeal = new JButton("Average Heal");
		btnAverageHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getTeam().getInv().get(1).getItemDescription());
			}
		});
		btnAverageHeal.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnAverageHeal.setBounds(362, 29, 183, 48);
		frame.getContentPane().add(btnAverageHeal);
		
		//Greater Heal Button
		JButton btnGreaterHeal = new JButton("Greater Heal");
		btnGreaterHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getTeam().getInv().get(2).getItemDescription());
			}
		});
		btnGreaterHeal.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnGreaterHeal.setBounds(718, 29, 183, 48);
		frame.getContentPane().add(btnGreaterHeal);

		//Map Button
		JButton btnMaps = new JButton("Maps");
		btnMaps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getTeam().getInv().get(3).getItemDescription());
			}
		});
		btnMaps.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnMaps.setBounds(718, 330, 183, 48);
		frame.getContentPane().add(btnMaps);
		
		//Armour Button
		JButton btnArmour = new JButton("Armour");
		btnArmour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getTeam().getInv().get(4).getItemDescription());
			}
		});
		btnArmour.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnArmour.setBounds(48, 188, 183, 48);
		frame.getContentPane().add(btnArmour);
		
		//Dice Luck Button
		JButton btnDiceLuck = new JButton("Dice luck");
		btnDiceLuck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getTeam().getInv().get(5).getItemDescription());
			}
		});
		btnDiceLuck.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnDiceLuck.setBounds(362, 188, 183, 48);
		frame.getContentPane().add(btnDiceLuck);
		
		//Max Health Button
		JButton btnMaxHealth = new JButton("Max Health");
		btnMaxHealth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getTeam().getInv().get(6).getItemDescription());
			}
		});
		btnMaxHealth.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnMaxHealth.setBounds(718, 188, 183, 48);
		frame.getContentPane().add(btnMaxHealth);
		
		//Skill Button
		JButton btnSkill = new JButton("Skill");
		btnSkill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getTeam().getInv().get(7).getItemDescription());
			}
		});
		btnSkill.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnSkill.setBounds(48, 330, 183, 48);
		frame.getContentPane().add(btnSkill);
		
		//Return To HomeBase
		JButton btnReturnToHomebase = new JButton("Return to HomeBase");
		btnReturnToHomebase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
			}
		});
		btnReturnToHomebase.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnReturnToHomebase.setBounds(10, 708, 195, 31);
		frame.getContentPane().add(btnReturnToHomebase);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(ShopSCREEN.class.getResource("/Images/shop.JPG")));
		label.setBounds(0, 0, 968, 755);
		frame.getContentPane().add(label);
	}
	
	public String GetDisplayText() {
		return DisplayText;
	}
	
	public void SetDisplayText(String newText) {
		DisplayText = newText;
	}
	
	public void closeSCREEN() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeShopSCREEN(this);
	}
	
	
}
