package towerDefence;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		
		JLabel bbg=new JLabel(new ImageIcon(this.getClass().getResource("/bglevels.png")));
		bbg.setBounds(new Rectangle(-14, 11, 1124, 660));
		bbg.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(bbg);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource().equals(level1)){
			setVisible(false);
			JFrame topFrame = (JFrame) SwingUtilities.windowForComponent(this);
			
			try {
				gamewin frame =new gamewin();
				frame.setVisible(true);
				topFrame.setVisible(false);
				
				
			} catch (Exception e1) {
				System.out.println("exception");
				System.out.println(e1.getMessage());
			}
			
		}
			
		
	}

//}
