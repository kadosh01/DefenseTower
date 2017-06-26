package towerDefence;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Rectangle;

public class MainWin extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin frame = new MainWin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public MainWin() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 0, 1000, Game.HIGH+Game.size);
		contentPane = new JPanel();
		//setPreferredSize(new Dimension(1100, Game.HIGH));
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton newGame = new JButton("New Game");
		newGame.setHideActionText(true);
		contentPane.add(newGame);
		newGame.setIcon(new ImageIcon(getClass().getResource("/new_Game.png")));
		newGame.setBorderPainted(false);
		newGame.setContentAreaFilled(false);
		newGame.setMargin(new Insets(2, 14, 2, 0));
		newGame.setDoubleBuffered(true);
		newGame.setFocusPainted(false); 
		newGame.setOpaque(false);
		newGame.setAlignmentX(Component.RIGHT_ALIGNMENT);
		newGame.setBounds(583, 117, 285, 63);
		newGame.setBackground(null);
		
		JButton levels = new JButton("");
		levels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				Levels levelsPane= new Levels();
				setContentPane(levelsPane);
			}
		});
		levels.setBorderPainted(false);
		levels.setContentAreaFilled(false);
		levels.setFocusPainted(false);
		levels.setIconTextGap(0);
		levels.setBounds(574, 227, 309, 73);
		levels.setIcon(new ImageIcon(getClass().getResource("/Levels Select.png")));
		contentPane.add(levels);
		
		JButton button = new JButton("");
		button.setIconTextGap(0);
		button.setFocusPainted(false);
		button.setIcon(new ImageIcon(getClass().getResource("/Exit.png")));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(583, 337, 295, 63);
		contentPane.add(button);
		JLabel bbg=new JLabel(new ImageIcon(this.getClass().getResource("/bg.png")));
		bbg.setBounds(new Rectangle(-14, 11, 1124, 660));
		bbg.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(bbg);
		newGame.addActionListener(this);
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		contentPane.setVisible(false);
		Levels levelsPane= new Levels();
		setContentPane(levelsPane);
		
	}
}
