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
	private JLabel lblGold;
	
	private String DisplayText;
	private GameEnvironment game;
	private int InvIndex = -1;
	private int[] StockList;


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
		StockList = game.getCurrentCity().getShop().getShopList();
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
		
		JLabel screenTitle = new JLabel("Wanderer's Shop");
		screenTitle.setHorizontalAlignment(SwingConstants.CENTER);
		screenTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		screenTitle.setBounds(323, 10, 248, 70);
		frame.getContentPane().add(screenTitle);
		
		// Main Text Output
		JTextArea outputBox = new JTextArea("What would you like to buy? ");
		outputBox.setWrapStyleWord(true);
		outputBox.setLineWrap(true);
		outputBox.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		outputBox.setFont(new Font("Cambria Math", Font.PLAIN, 17));
		outputBox.setBounds(327, 493, 574, 246);
		frame.getContentPane().add(outputBox);
		
		
		//Buttons for Items in shop
		
		//LesserHeal Button
		JButton btnLesserHeal = new JButton("Lesser Heal");
		btnLesserHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getParty().getInv().get(0).getItemName() + 
						"\nStock: " + StockList[0] + "                                 Price: " +
						game.getParty().getInv().get(0).getItemPrice() + "\n" +
						game.getParty().getInv().get(0).getItemDescription() + "\n" + 
						game.getParty().getInv().get(0).getItemStock() + " in Inventory.");
				InvIndex = 0;
			}
		});
		btnLesserHeal.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnLesserHeal.setBounds(48, 112, 183, 48);
		frame.getContentPane().add(btnLesserHeal);
		
		//Average Heal Button
		JButton btnAverageHeal = new JButton("Average Heal");
		btnAverageHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getParty().getInv().get(1).getItemName() + 
						"\nStock: " + StockList[1] + "                                 Price: " +
						game.getParty().getInv().get(1).getItemPrice() + "\n" +
						game.getParty().getInv().get(1).getItemDescription() + "\n" + 
						game.getParty().getInv().get(1).getItemStock() + " in Inventory.");
				InvIndex = 1;
			}
		});
		btnAverageHeal.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnAverageHeal.setBounds(362, 112, 183, 48);
		frame.getContentPane().add(btnAverageHeal);
		
		//Greater Heal Button
		JButton btnGreaterHeal = new JButton("Greater Heal");
		btnGreaterHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getParty().getInv().get(2).getItemName() + 
						"\nStock: " + StockList[2] + "                                 Price: " +
						game.getParty().getInv().get(2).getItemPrice() + "\n" +
						game.getParty().getInv().get(2).getItemDescription() + "\n" + 
						game.getParty().getInv().get(2).getItemStock() + " in Inventory.");
				InvIndex = 2;
			}
		});
		btnGreaterHeal.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnGreaterHeal.setBounds(718, 112, 183, 48);
		frame.getContentPane().add(btnGreaterHeal);

		//Map Button
		JButton btnMaps = new JButton("Maps");
		btnMaps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getParty().getInv().get(3).getItemName() + 
						"\nStock: " + StockList[3] + "                                 Price: " +
						game.getParty().getInv().get(3).getItemPrice() + "\n" +
						game.getParty().getInv().get(3).getItemDescription() + "\n" + 
						game.getParty().getInv().get(3).getItemStock() + " in Inventory.");
				InvIndex = 3;
			}
		});
		btnMaps.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnMaps.setBounds(718, 263, 183, 48);
		frame.getContentPane().add(btnMaps);
		
		//Armour Button
		JButton btnArmour = new JButton("Armour");
		btnArmour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getParty().getInv().get(4).getItemName() + 
						"\nStock: " + StockList[4] + "                                 Price: " +
						game.getParty().getInv().get(4).getItemPrice() + "\n" +
						game.getParty().getInv().get(4).getItemDescription() + "\n" + 
						game.getParty().getInv().get(4).getItemStock() + " in Inventory.");
				InvIndex = 4;
			}
		});
		btnArmour.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnArmour.setBounds(48, 188, 183, 48);
		frame.getContentPane().add(btnArmour);
		
		//Dice Luck Button
		JButton btnDiceLuck = new JButton("Dice luck");
		btnDiceLuck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getParty().getInv().get(5).getItemName() + 
						"\nStock: " + StockList[5] + "                                 Price: " +
						game.getParty().getInv().get(5).getItemPrice() + "\n" +
						game.getParty().getInv().get(5).getItemDescription() + "\n" + 
						game.getParty().getInv().get(5).getItemStock() + " in Inventory.");
				InvIndex = 5;
			}
		});
		btnDiceLuck.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnDiceLuck.setBounds(362, 188, 183, 48);
		frame.getContentPane().add(btnDiceLuck);
		
		//Max Health Button
		JButton btnMaxHealth = new JButton("Max Health");
		btnMaxHealth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getParty().getInv().get(6).getItemName() + 
						"\nStock: " + StockList[6] + "                                 Price: " +
						game.getParty().getInv().get(6).getItemPrice() + "\n" +
						game.getParty().getInv().get(6).getItemDescription() + "\n" + 
						game.getParty().getInv().get(6).getItemStock() + " in Inventory.");
				InvIndex = 6;
			}
		});
		btnMaxHealth.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnMaxHealth.setBounds(718, 188, 183, 48);
		frame.getContentPane().add(btnMaxHealth);
		
		//Skill Button
		JButton btnSkill = new JButton("Skill");
		btnSkill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputBox.setText(game.getParty().getInv().get(7).getItemName() + 
						"\nStock: " + StockList[7] + "                                 Price: " +
						game.getParty().getInv().get(7).getItemPrice() + "\n" +
						game.getParty().getInv().get(7).getItemDescription() + "\n" + 
						game.getParty().getInv().get(7).getItemStock() + " in Inventory.");
				InvIndex = 7;
			}
		});
		btnSkill.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnSkill.setBounds(48, 263, 183, 48);
		frame.getContentPane().add(btnSkill);
		
		//Return To HomeBase
		JButton btnTravelHome = new JButton("Return to HomeBase");
		btnTravelHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
			}
		});
		btnTravelHome.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnTravelHome.setBounds(48, 682, 235, 57);
		frame.getContentPane().add(btnTravelHome);
		
		
		//Buying an Item
		JButton btnBuyItem = new JButton("Buy Item");
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (InvIndex == -1) {
					outputBox.setText("Stranger, you please select an Item");
				} else if (StockList[InvIndex] < 1){
					outputBox.setText("Sorry Stranger, Out of Stock");
				} else if (game.getParty().getCoins() < game.getParty().getInv().get(InvIndex).getItemPrice()) {
					outputBox.setText("Not enough coins, Stranger");
				} else {
					StockList[InvIndex] = StockList[InvIndex] -1;
					game.getCurrentCity().getShop().setShopList(StockList);
					int UpdatedGold = game.getParty().getCoins() - game.getParty().getInv().get(InvIndex).getItemPrice();
					game.getParty().setCoins(UpdatedGold);
					int UpdatedItemInv = game.getParty().getInv().get(InvIndex).getItemStock() + 1;
					game.getParty().getInv().get(InvIndex).setItemStock(UpdatedItemInv);
					outputBox.setText(game.getParty().getInv().get(InvIndex).getItemName() + " Bought.\n\nAnything Else, Stranger?" + "\n");
					lblGold.setText("Gold: " + game.getParty().getCoins());
				}
			}
		});
		btnBuyItem.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnBuyItem.setBounds(48, 493, 235, 57);
		frame.getContentPane().add(btnBuyItem);
		
		lblGold = new JLabel("Gold: " + game.getParty().getCoins());
		lblGold.setHorizontalAlignment(SwingConstants.CENTER);
		lblGold.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblGold.setBounds(48, 586, 235, 57);
		frame.getContentPane().add(lblGold);
		
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
		game.closeShopSCREEN(game.getHomeBase(),this);
	}
}
