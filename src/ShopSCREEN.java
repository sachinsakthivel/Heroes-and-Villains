import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopSCREEN {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public ShopSCREEN() {
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
		
		JLabel lblTextDisplay = new JLabel("Text Display");
		lblTextDisplay.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblTextDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextDisplay.setBounds(205, 487, 614, 252);
		frame.getContentPane().add(lblTextDisplay);
		
		JButton btnNewButton = new JButton("Lesser Heal");
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnNewButton.setBounds(48, 29, 183, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAverageHeal = new JButton("Average Heal");
		btnAverageHeal.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnAverageHeal.setBounds(361, 29, 183, 48);
		frame.getContentPane().add(btnAverageHeal);
		
		JButton btnGreaterHeal = new JButton("Greater Heal");
		btnGreaterHeal.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnGreaterHeal.setBounds(680, 29, 183, 48);
		frame.getContentPane().add(btnGreaterHeal);
		
		JButton btnArmour = new JButton("Armour");
		btnArmour.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnArmour.setBounds(48, 188, 183, 48);
		frame.getContentPane().add(btnArmour);
		
		JButton btnDiceLuck = new JButton("Dice luck");
		btnDiceLuck.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnDiceLuck.setBounds(341, 188, 183, 48);
		frame.getContentPane().add(btnDiceLuck);
		
		JButton btnMaxHealth = new JButton("Max Health");
		btnMaxHealth.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnMaxHealth.setBounds(661, 188, 183, 48);
		frame.getContentPane().add(btnMaxHealth);
		
		JButton btnSkill = new JButton("Skill");
		btnSkill.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnSkill.setBounds(35, 330, 183, 48);
		frame.getContentPane().add(btnSkill);
		
		JButton btnMaps = new JButton("Maps");
		btnMaps.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnMaps.setBounds(636, 330, 183, 48);
		frame.getContentPane().add(btnMaps);
		
		JButton btnReturnToHomebase = new JButton("Return to HomeBase");
		btnReturnToHomebase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			
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
}
