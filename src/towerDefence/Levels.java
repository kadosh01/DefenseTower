package towerDefence;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Levels extends JPanel implements ActionListener{
	JButton level1;
	JButton level2;
	JButton level3;

	/**
	 * Create the panel.
	 */
	public Levels() {
		setLayout(null);
		
		level1 = new JButton("level 1");
		level1.setBounds(103, 222, 210, 178);
		add(level1);
		level1.addActionListener(this);
		
		level2 = new JButton("level 2");
		level2.setBounds(493, 222, 210, 178);
		add(level2);
		
		level3 = new JButton("level 3");
		level3.setBounds(889, 222, 210, 178);
		add(level3);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource().equals(level1)){
			setVisible(false);
			JFrame topFrame = (JFrame) SwingUtilities.windowForComponent(this);
			Game board;
			try {
				
				JPanel mainPane= new JPanel();
				JPanel buttonPane = new JPanel();
				board = new Game(0, buttonPane);
				mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.X_AXIS));
				mainPane.add(board);
				mainPane.add(buttonPane);
				board.setPreferredSize(new Dimension(Game.HIGH,Game.HIGH));
				//board.setBounds(40, 40, 200,200 );
				
				//topFrame.addMouseListener(board);
				//topFrame.addMouseMotionListener(board);
				board.addMouseListener(board);
				board.addMouseMotionListener(board);
				topFrame.setContentPane(mainPane);
				
				
			} catch (Exception e1) {
				System.out.println("exception");
				System.out.println(e1.getMessage());
			}
			
		}
			
		
	}

//}
