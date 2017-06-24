

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Game extends JPanel implements ActionListener , MouseListener,MouseMotionListener  {
	
	private JPanel buttonPane;
	private JButton startBtn;
	public Board game;
	public Cell[][] board;
	private Cell start;
	private Cell end;
	private BufferedImage[][] map;
	private Timer timer;
	public final static int size=25;
	public final static int gamespeed=1;
	public static final int delay=(1000/(size)/gamespeed);
	public static final int creepsize=Creep.size;
	private int creep;
	private int count;
	private LinkedList<Creep> wave;
	private LinkedList<Creep> creeps;
	private LinkedList<Tower> Towers;
	public JLabel life;
	public JFrame topFrame ;
	private Graphics g;
	private Point erea;
	public Image move;
	public Image overly;
	public static Tower settower;
	public static final int HIGH=size*28;
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Game(int level, JPanel buttonPane) throws IOException {
		super();
		this.buttonPane = buttonPane;
		this.g=super.getGraphics();
		setLayout(null);
		//setBounds(10, 10, 1700, 1300);
		overly = ImageIO.read(getClass().getResourceAsStream("/overly.png"));
		setPreferredSize( new Dimension( 800, 1600 ) );
		timer = new Timer(delay, this);
		startBtn = new JButton("start");
		buttonPane.add(startBtn);
		startBtn.setBounds(478, 428, 201, 59);
		
		startBtn.addActionListener(this);
		
		
	    //load level
		LevelLoader levelloader= new LevelLoader();
		levelloader.load("levels.txt");
		board= levelloader.get(level);
		game = new Board(board, size);
		for(int i=0; i<board.length; i++){
 			if(board[i][0].isRoad())
				start = board[i][0];
			if(board[i][board.length-1].isRoad())
				end = board[i][board.length-1];
		}
		
		life=new JLabel(("HP: "+game.life));
		life.setBounds(100, 100, 100, 100);
		buttonPane.add(life);
		//load pics
		map=new BufferedImage[board.length][board[0].length];
		//Cell prev=start;
		BufferedImage road=ImageIO.read(getClass().getResourceAsStream("/road.png"));
		//BufferedImage road1=ImageIO.read(getClass().getResourceAsStream("/road_r_d.png"));
		//BufferedImage road2=ImageIO.read(getClass().getResourceAsStream("/road_r_u.png"));
		//BufferedImage road3=ImageIO.read(getClass().getResourceAsStream("/road_d_r.png"));
		//BufferedImage road4=ImageIO.read(getClass().getResourceAsStream("/road_u_r.png"));
		BufferedImage grass=ImageIO.read(getClass().getResourceAsStream("/grass.png"));
		BufferedImage grass1=ImageIO.read(getClass().getResourceAsStream("/grass_o1.png"));
		for (int i=0; i<map.length; i++)
			for(int j=0; j<map[i].length; j++){
				if(board[i][j].isRoad()){
						map[i][j]=road;					
				}
				else {
					double x=Math.random();
					if(x>0.02)
						map[i][j]=grass;
					else map[i][j]=grass1;
				}
				
			}		
		
		
		wave = new LinkedList<Creep>();
		this.Towers=new LinkedList<>();
		creeps = game.wave(2);
		
	}
	
	public void paint(Graphics g){/////////////////////////////////////////////////
		super.paint(g);
		this.g=g;
		Image offIm = createImage(getSize().width, getSize().height);
		Graphics offGr = offIm.getGraphics();
		
		for (int i=0; i<map.length; i++){
			for(int j=0; j<map[i].length; j++){
						offGr.drawImage(map[i][j], j*size, i*size,size,size, null);
			}
		}
		int numOfCreeps = wave.size();
		while(creep<numOfCreeps){
			//System.out.println("creep: "+creep);
			Creep k = wave.get(creep);
			offGr.drawImage(k.im, k.y, k.x, creepsize, creepsize, this);					
			creep++;
		}
		creep = 0;
		
		int numOfTowers = Towers.size();
		for(int i=0;i<numOfTowers;i++){
			Tower t=Towers.get(i);
			//System.out.println("P x: "+t.x+" y: "+t.y);
			offGr.drawImage(t.im, t.y, t.x-Tower.size, Tower.size, Tower.size*2, this);
		}
			
									
			
			creep++;
		//erea paint
		
		
		
/// tower set
	if(erea!=null){
	offGr.drawImage(overly, erea.x, erea.y , size,size,this);
	}			
if(settower!=null){
		int locy=(erea.x*28)/HIGH;
		int locx=(erea.y*28)/HIGH;
		move=settower.im;
		if(settower.hitArea==1){///////
			
				
							
					if(locx+1<board.length & locy+1<board[0].length & locy-1>=0 & locx-1>=0){
						if(board[locx-1][locy].isRoad())
							offGr.drawImage(overly, erea.x, erea.y-size, size,size,this);
						if(board[locx+1][locy].isRoad())
							offGr.drawImage(overly, erea.x, erea.y+size, size,size,this);
						if(board[locx][locy+1].isRoad())
							offGr.drawImage(overly, erea.x+size, erea.y, size,size,this);
						if(board[locx][locy-1].isRoad())
							offGr.drawImage(overly, erea.x-size, erea.y, size,size,this);
						
					}
		}
					if(settower.hitArea==2){///////
						if(locx+1<board.length & locy+1<board[0].length & locy-1>=0 & locx-1>=0){
							if(board[locx-1][locy].isRoad())
								offGr.drawImage(overly, erea.x, erea.y-size, size,size,this);
							if(board[locx+1][locy+1].isRoad())
								offGr.drawImage(overly, erea.x+size, erea.y+size, size,size,this);
							if(board[locx-1][locy-1].isRoad())
								offGr.drawImage(overly, erea.x-size, erea.y-size, size,size,this);
							if(board[locx-1][locy+1].isRoad())
								offGr.drawImage(overly, erea.x+size, erea.y-size, size,size,this);
							if(board[locx+1][locy-1].isRoad())
								offGr.drawImage(overly, erea.x-size, erea.y+size, size,size,this);
							if(board[locx+1][locy].isRoad())
								offGr.drawImage(overly, erea.x, erea.y+size, size,size,this);
							if(board[locx][locy+1].isRoad())
								offGr.drawImage(overly, erea.x+size, erea.y, size,size,this);
							if(board[locx][locy-1].isRoad())
								offGr.drawImage(overly, erea.x-size, erea.y, size,size,this);
							
						}
							
		}
		
		offGr.drawImage(move, erea.x, erea.y-Tower.size ,Tower.size,Tower.size*2,this);
		


		

}


g.drawImage(offIm, 0, 0, this);
// grid

for(int i=0;i<Game.HIGH/size;i++){
		g.setColor(Color.BLACK);
		g.drawLine(i*size, 0, i*size,Game.HIGH);
		for(int j=0;j<Game.HIGH/size;j++){
			g.setColor(Color.BLACK);
			g.drawLine(0, j*size, Game.HIGH, j*size);
		}
}
		
	}
 public void addTower(Tower t){
	 Towers.add(t);
 } 
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource().equals(startBtn)){
				if(!creeps.isEmpty()){
				Creep c= creeps.get(0);
				creeps.removeFirst();
				wave.add(c);
				c.counter = 0;
				timer.start();
				count=1;
				creep=0;
				}
				
			}			
	
			if(e.getSource()==timer){
				int numOfCreeps = wave.size();
				for(int i=0; i<numOfCreeps; i++){
					Creep k = wave.get(i);
					//System.out.println(i);
					//System.out.println(k.x+"  "+k.y);
					k.tickHAppend(count);
					//System.out.println(k.x+"  "+k.y);
					if((k.location==end)){
						wave.remove(k);
						game.life--;
					}
					life.setText("HP: "+game.life);
					repaint();
				}
				for(int i=0; i<Towers.size(); i++){
					Tower t = Towers.get(i);
					//System.out.println(i);
					//System.out.println(k.x+"  "+k.y);
					t.tickHAppend(count);
				}
				count++;
				repaint();
				double entercreep=Math.random();
				if(entercreep<0.02){
					if(!creeps.isEmpty()){
						Creep c = creeps.get(0);
						creeps.removeFirst();
						wave.add(c);
						c.counter = 0;
					}					
				}
			}
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		topFrame = (JFrame) SwingUtilities.windowForComponent(this);
		int y=(erea.x*28)/HIGH;
		int x=(erea.y*28)/HIGH;
			if(settower==null){
			towerswin win=new towerswin(erea.y, erea.x,this);
			win.setVisible(true);
			this.validate();
			}
				if(settower!=null){
				if((x+1 <board.length & y+1<board[0].length ) && (!board[x][y].isRoad())){
				settower.setLocation(erea.y, erea.x);
				addTower(settower);
				settower=null;
				}
			}
				System.out.println("click  "+x+ "  y: "+y);
				System.out.println(("road: "+board[(x*28)/HIGH][(y*28)/HIGH].isRoad()));
			repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		int x = (e.getX()/size)*size;
		int y = (e.getY()/size)*size;
		this.erea=new Point(x, y);
		System.out.println("move  "+x+ "  y: "+y);
		System.out.println(board.length +"  "+board[0].length);
		
		
		
		repaint();
		
		
	}
}
