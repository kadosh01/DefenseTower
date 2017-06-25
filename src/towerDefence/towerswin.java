package towerDefence;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;




public class towerswin extends JFrame{
	private int x;
	private int y;
	private JFrame a=(JFrame)SwingUtilities.windowForComponent(this);
	private final int imghigh=85;
	private final int imgwidh=43;
	private final int width=imgwidh*3;
	private final int high=imghigh*3;
	
	public towerswin(int x,int y,Game parent){
		GridLayout grid=new GridLayout(5, 3);		
		JPanel m=new JPanel(grid);
		setContentPane(m);
		this.x=x;
		this.y=y;
		setLayout(new GridLayout(2, 3));
		setBackground(Color.DARK_GRAY);
	
		
		setBounds(y+100, x,width, high);
		System.out.println("x: "+x+" y: "+y);
		//this.setType(getType().UTILITY);
		JButton arrow=new JButton("");
		arrow.setBackground(null);
		arrow.setBounds(10, 10, imgwidh, imghigh);
		
		
		arrow.setIcon(new ImageIcon(this.getClass().getResource("/tower1.png")));
		arrow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Game.settower=new ArrowTower(0,0);
					//parent.addTower(new ArrowTower(x-Tower.size-10,y));
					//System.out.println("x: "+x+" y: "+y);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				
				
			}
		});
		m.add(arrow);
		//arrow.setContentAreaFilled(false);
		arrow.setVisible(true);
		
		JButton posion=new JButton("");
		posion.setBackground(null);
		posion.setBounds(20+imgwidh, 10, imgwidh, imghigh);
		
		
		posion.setIcon(new ImageIcon(this.getClass().getResource("/tower2.png")));
		posion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Game.settower=new PosionTower(0,0);
					//parent.addTower(new PosionTower(x-Tower.size-10,y));
					//System.out.println("x: "+x+" y: "+y);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				
				
			}
		});
		m.add(posion);
		posion.setVisible(true);
		
		JButton Magic=new JButton("");
		Magic.setBackground(null);
		Magic.setBounds(20+imgwidh, 105, imgwidh, imghigh);
		
		Magic.setIcon(new ImageIcon(this.getClass().getResource("/tower3.png")));
		Magic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Game.settower=new MagicTower(0,0);
					//parent.addTower(new PosionTower(x-Tower.size-10,y));
					//System.out.println("x: "+x+" y: "+y);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				
				
			}
		});
		
		m.add(Magic);
		Magic.setVisible(true);
		
		JButton Magma=new JButton("");
		Magma.setBackground(null);
		Magma.setBounds(20+imgwidh, 105, imgwidh, imghigh);
		
		Magma.setIcon(new ImageIcon(this.getClass().getResource("/tower4.png")));
		Magma.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Game.settower=new MagmaTower(0,0);
					//parent.addTower(new PosionTower(x-Tower.size-10,y));
					//System.out.println("x: "+x+" y: "+y);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				
				
			}
		});
		m.add(Magma);
		Magma.setVisible(true);
	
	}
	
	

}
