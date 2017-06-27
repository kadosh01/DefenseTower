package towerDefence;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;

public class Levels extends JPanel implements ActionListener{
	JButton level1;
	JButton level2;
	JButton level3;
	private gamewin frame;
	
	/**
	 * Create the panel.
	 */
	public Levels() {
		setLayout(null);
		level1 = new JButton("");
		
		level1.setBorderPainted(false);
		level1.setBounds(350, 55, 289, 59);
		add(level1);
		level1.setIcon(new ImageIcon(this.getClass().getResource("/level1.png")));
		level1.setContentAreaFilled(false);
		level1.addActionListener(this);
		
		level2 = new JButton("");
		level2.setBounds(350, 155, 289, 65);
		level2.setIcon(new ImageIcon(this.getClass().getResource("/level2.png")));
		level2.setContentAreaFilled(false);
		level2.addActionListener(this);
		add(level2);
		
		level3 = new JButton("");
		level3.setIcon(new ImageIcon(this.getClass().getResource("/level3.png")));
		level3.setBounds(350, 255, 289, 65);
		level3.setContentAreaFilled(false);
		level3.addActionListener(this);
		add(level3);
		
		JLabel bbg=new JLabel(new ImageIcon(this.getClass().getResource("/bglevels.png")));
		bbg.setBounds(new Rectangle(-14, 11, 1124, 660));
		bbg.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(bbg);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
			JFrame topFrame = (JFrame) SwingUtilities.windowForComponent(this);
			
			try {
				if(e.getSource().equals(level1)){
				frame =new gamewin(0);
				}
				if(e.getSource().equals(level2)){
					frame =new gamewin(1);
					System.out.println("asd");
					}
				if(e.getSource().equals(level3)){
					frame =new gamewin(2);
					}
				setVisible(false);
				frame.setVisible(true);
				topFrame.setVisible(false);
				
				
			} catch (Exception e1) {
				System.out.println("exception");
				System.out.println(e1.getMessage());
			}
			
		}
			
		
	}



