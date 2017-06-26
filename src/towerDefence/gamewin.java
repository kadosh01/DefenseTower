package towerDefence;

import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;

public class gamewin extends JFrame {
	public gamewin() throws IOException {
		JPanel buttonPane = new JPanel();
		JPanel mainPane= new JPanel();
		mainPane.setVisible(true);
		mainPane.setOpaque(false);
		Game board= new Game(0, buttonPane);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(250, 0, 1000, 800);
		mainPane.setLayout(null);
		mainPane.setBounds(0, 0, 1000,Game.HIGH+Game.size);
		this.setContentPane(mainPane);
		mainPane.add(board);
		board.setBounds(mainPane.getWidth()/7, 0, Game.HIGH, Game.HIGH);
		mainPane.add(buttonPane);
		buttonPane.setBounds(850, 100, 113, 227);
		//board.setPreferredSize( new Dimension( 800, 1600 ) );
		//mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.X_AXIS));
		//mainPane.setForeground(null);
		
		board.setLayout(null);
		
		
		
		board.setOpaque(false);
		//buttonPane.setBounds(0, 0, 200,200);
		
		//board.setBounds(100, 0, 639,675);
		buttonPane.setOpaque(false);
		//mainPane.add(game);
		//buttonPane.add(game);
		
		
		
		board.addMouseListener(board);
		board.addMouseMotionListener(board);
		JLabel game= new JLabel();
		game.setSize(this.getWidth(),this.getHeight());
		game.setAlignmentX(Component.CENTER_ALIGNMENT);
		game.setIcon(new ImageIcon(this.getClass().getResource("/game.png")));
		getContentPane().add(game);
	}
	
	
	

}
