package towerDefence;

import java.awt.CardLayout;
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
import javax.swing.ScrollPaneLayout;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
public class towerswin extends JFrame{
	private int x;
	private int y;
	private JFrame a=(JFrame)SwingUtilities.windowForComponent(this);
	private final int imghigh=105;
	private final int imgwidh=50;
	private final int width=imgwidh*8;
	private final int high=imghigh*3;
	public static JLabel Arrowlabel;
	public JLabel Poisonlabel;
	public JLabel MagmaLabel;
	public JLabel SamLabel;
	public JLabel DinoLabel;
	public JLabel GokuLabel;
	public JLabel MagicLabel;
	
	public towerswin(int x,int y,Game parent){
		getContentPane().setLayout(new ScrollPaneLayout());	
		JPanel m=new JPanel(null);
		setContentPane(m);
		this.x=x;
		this.y=y;
		//GridLayout(2, 4)
		getContentPane().setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		setBounds(y+100, x,436, 389);
		System.out.println("x: "+x+" y: "+y);
		//this.setType(getType().UTILITY);
		JButton arrow=new JButton("");
		arrow.setBackground(null);
		arrow.setBounds(10, 10, 86, 117);
		
		
		arrow.setIcon(new ImageIcon(this.getClass().getResource("/tower1.png")));
		arrow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Game.settower=new ArrowTower(0,0);
					Arrowlabel.setText("2");
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
		posion.setBounds(113, 10, 86, 117);
		
		
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
		Magic.setBounds(313, 10, 86, 115);
		
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
		Magma.setBounds(209, 10, 86, 117);
		
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
		
		JButton Sam=new JButton("");
		Sam.setBackground(null);
		Sam.setBounds(276, 173, 86, 117);
		
		Sam.setIcon(new ImageIcon(this.getClass().getResource("/tower5.png")));
		Sam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Game.settower=new SamTower(0,0);
					//parent.addTower(new PosionTower(x-Tower.size-10,y));
					//System.out.println("x: "+x+" y: "+y);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				
				
			}
		});
		m.add(Sam);
		Sam.setVisible(true);
		
		JButton Goko=new JButton("");
		Goko.setBackground(null);
		Goko.setBounds(161, 173, 86, 117);
		
		Goko.setIcon(new ImageIcon(this.getClass().getResource("/tower6.png")));
		Goko.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Game.settower=new GokoTower(0,0);
					//parent.addTower(new PosionTower(x-Tower.size-10,y));
					//System.out.println("x: "+x+" y: "+y);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				
				
			}
		});
		m.add(Goko);
		Goko.setVisible(true);
		
		JButton Dino=new JButton("");
		Dino.setBackground(null);
		Dino.setBounds(44, 173, 86, 117);
		
		Dino.setIcon(new ImageIcon(this.getClass().getResource("/tower7.png")));
		Dino.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Game.settower=new DinoTower(0,0);
					//parent.addTower(new PosionTower(x-Tower.size-10,y));
					//System.out.println("x: "+x+" y: "+y);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				
				
			}
		});
		m.add(Dino);
		
		JScrollPane scrollPane = new JScrollPane();
		m.add(scrollPane);
		
		Arrowlabel = new JLabel("3");
		Arrowlabel.setBounds(75, 131, 21, 26);
		m.add(Arrowlabel);
		
		JLabel lblArrow = new JLabel("Arrow");
		lblArrow.setBounds(10, 132, 50, 26);
		m.add(lblArrow);
		
		JLabel lblPoison = new JLabel("Poison");
		lblPoison.setBounds(118, 132, 50, 26);
		m.add(lblPoison);
		
		Poisonlabel = new JLabel("3");
		Poisonlabel.setBounds(178, 131, 21, 26);
		m.add(Poisonlabel);
		
		MagmaLabel = new JLabel("3");
		MagmaLabel.setBounds(274, 131, 21, 26);
		m.add(MagmaLabel);
		
		JLabel lblLava = new JLabel("Lava");
		lblLava.setBounds(219, 132, 50, 26);
		m.add(lblLava);
		
		SamLabel = new JLabel("1");
		SamLabel.setBounds(341, 294, 21, 26);
		m.add(SamLabel);
		
		JLabel lblSam = new JLabel("Sam");
		lblSam.setBounds(276, 294, 39, 26);
		m.add(lblSam);
		
		JLabel lblDino = new JLabel("Dino");
		lblDino.setBounds(44, 294, 50, 26);
		m.add(lblDino);
		
		DinoLabel = new JLabel("1");
		DinoLabel.setBounds(109, 294, 21, 26);
		m.add(DinoLabel);
		
		JLabel lblGoku = new JLabel("Goku");
		lblGoku.setBounds(161, 297, 50, 26);
		m.add(lblGoku);
		
		GokuLabel = new JLabel("1");
		GokuLabel.setBounds(226, 297, 21, 26);
		m.add(GokuLabel);
		
		JLabel lblMagic = new JLabel("Magic");
		lblMagic.setBounds(312, 131, 50, 26);
		m.add(lblMagic);
		
		MagicLabel = new JLabel("3");
		MagicLabel.setBounds(378, 131, 21, 26);
		m.add(MagicLabel);
		Dino.setVisible(true);
	
	
	}
}
