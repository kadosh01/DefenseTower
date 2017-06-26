package towerDefence;

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
import java.time.Year;
import java.util.LinkedList;

import javax.swing.Timer;
import javax.xml.ws.Holder;
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
	public static Cell[][] board;
	private Cell start;
	private Cell end;
	private BufferedImage[][] map;
	private Timer timer;
	public final static int size=25;
	public static int gamespeed=1;
	public static int delay=(40);
	public static final int creepsize=Creep.size;
	private int creep;
	private int count;
	private LinkedList<Tickable> wave; // creeps on board
	private LinkedList<Tickable> creeps; // 
	private LinkedList<Tickable> Towers;
	public JLabel life;
	public JFrame topFrame ;
	private Graphics g;
	private Point erea;
	public Image move;
	public Image overly;
	private boolean gamestart=false;
	public static Tower settower;
	public static final int HIGH=size*28;
	private JButton Bgamespeed;
	private JButton play;
	int sec=0;
	int min=0;
	private JLabel time;
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Game(int level, JPanel buttonPane) throws IOException {
		super();
		this.buttonPane = buttonPane;
		this.g=super.getGraphics();
		buttonPane.setOpaque(false);
		//setBounds(0, 0, 100, 100);
		overly = ImageIO.read(getClass().getResourceAsStream("/overly.png"));
		//setPreferredSize( new Dimension( 800, 1600 ) );
		timer = new Timer(delay, this);
		startBtn = new JButton("start");
		this.Bgamespeed = new JButton("Fastforwad");
		this.play = new JButton("Play");
		Bgamespeed.setVisible(true);
		buttonPane.add(startBtn);
		buttonPane.add(Bgamespeed);
		buttonPane.add(play);
		play.setVisible(false);
		startBtn.setBounds(478, 528, 301, 59);
		time=new JLabel("min:"+min+" sec :"+sec);
		buttonPane.setBounds(0, 200, 200, 600);
		Bgamespeed.addActionListener(this);
		play.addActionListener(this);
		startBtn.addActionListener(this);
		time.setVisible(true);
		this.buttonPane.add(time);


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
		life.setBounds(100, 100, 100, 200);
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


		wave = new LinkedList<Tickable>();
		this.Towers=new LinkedList<>();
		creeps = game.wave(3);

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
			Creep k = (Creep) wave.get(creep);
			offGr.drawImage(k.im, k.y, k.x, creepsize, creepsize, this);					
			creep++;
		}
		creep = 0;

		int numOfTowers = Towers.size();
		for(int i=0;i<numOfTowers;i++){
			Tower t=(Tower) Towers.get(i);
			//System.out.println("P x: "+t.x+" y: "+t.y);
			offGr.drawImage(t.im, t.y, t.x-t.size, t.size, t.Hsize, this);
		}
		/// tower set
		if(erea!=null){
			offGr.drawImage(overly, erea.x, erea.y, size,size,this);
		}			
		if(settower!=null){
			int locy=(erea.x*28)/HIGH;
			int locx=(erea.y*28)/HIGH;
			move=settower.im;
			if(locx+settower.hitArea<board.length & locy+settower.hitArea<board[0].length & locy-settower.hitArea>=0 & locx-settower.hitArea>=0){
				for(int i=0;i<=settower.hitArea;i++)
					for(int j=0;j<=settower.hitArea;j++){
						if(board[locx-i][locy-j].isRoad())
							offGr.drawImage(overly, erea.x-j*size, erea.y-i*size, size,size,this);
						if(board[locx+i][locy+j].isRoad())
							offGr.drawImage(overly, erea.x+j*size, erea.y+i*size, size,size,this);
						if(board[locx-i][locy+j].isRoad())
							offGr.drawImage(overly, erea.x+j*size, erea.y-i*size, size,size,this);
						if(board[locx+i][locy-j].isRoad())
							offGr.drawImage(overly, erea.x-j*size, erea.y+i*size, size,size,this);
					}
			}
			offGr.drawImage(move, erea.x, erea.y-settower.size ,settower.size,settower.Hsize,this);
		}
		/*
		//pointers 
	//start pointer
		try {
			BufferedImage[] E={ImageIO.read(getClass().getResourceAsStream("/Enter/Layer 1.png")),ImageIO.read(getClass().getResourceAsStream("/Enter/Layer 2.png"))};
			BufferedImage Ex1[]={ImageIO.read(getClass().getResourceAsStream("/Exit/Layer 1.png")),ImageIO.read(getClass().getResourceAsStream("/Exit/Layer 2.png"))};
			//if(count%6==0){
				offGr.drawImage(E[count%E.length], start._y*size, start._x*(size-1),28,47,null);
				offGr.drawImage(Ex1[count%Ex1.length], end._y, end._x,28,47,null);
			//}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
	// grid
	if(gamestart==false){
	for(int i=0;i<Game.HIGH/size;i++){
		offGr.setColor(Color.BLACK);
		offGr.drawLine(i*size, 0, i*size,Game.HIGH);
		for(int j=0;j<Game.HIGH/size;j++){
			offGr.setColor(Color.BLACK);
			offGr.drawLine(0, j*size, Game.HIGH, j*size);
		}
	}
	}
	if(time!=null)
	g.drawImage(offIm, 0, 0, this);
}
public void addTower(Tower t){
	Towers.add(t);
} 

@Override
public void actionPerformed(ActionEvent e) {
	try{
		if(e.getSource().equals(Bgamespeed)){
			Game.gamespeed+=2;
			Game.delay=Game.delay/Game.gamespeed;
			this.timer.setDelay(delay);
			System.out.println(delay);
			System.out.println("AS");
			Bgamespeed.setVisible(false);
			play.setVisible(true);
		}
		if(e.getSource().equals(play)){
			Game.delay=Game.delay*Game.gamespeed;
			Game.gamespeed-=2;
			this.timer.setDelay(delay);
			Bgamespeed.setVisible(true);
			play.setVisible(false);
		}
		if(e.getSource().equals(startBtn)){
			if(!creeps.isEmpty()){
				Creep c= (Creep) creeps.get(0);
				creeps.removeFirst();
				wave.add(c);
				c.counter = 0;
				timer.start();
				count=1;
				creep=0;
				gamestart=true;
			}

		}			

		if(e.getSource()==timer){
			count++;
			timeupdate();
			for(int i=0; i<wave.size(); i++){
				Creep k = (Creep) wave.get(i);
				if(k.life<=0)
					wave.remove(k);
				for(int j=1;j<=k.speed;j++)
					k.tickHAppend(null);
				if(k.speed<1){
					if(count%2==1){						
						k.tickHAppend(null);
					}
				}
				if((k.location==end)){
					wave.remove(k);
					game.life--;
				}
				
				}
			for(int j=0; j<Towers.size(); j++){
				Tower t = (Tower) Towers.get(j);
				System.out.println(t);
				for(int l=0; l<t.speed; l++){
					
					t.tickHAppend(wave);
				}
				
				life.setText("HP: "+game.life);
				repaint();
			}			
			count++;
			repaint();
			if(!creeps.isEmpty()){
				double entercreep=Math.random();
				if(entercreep<0.02){					
					Creep c = (Creep) creeps.get(0);
					creeps.removeFirst();
					wave.add(c);
					c.counter = 0;
				}					
			}
			if(wave.isEmpty()){
				startBtn.setText("Next Wave");
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
	repaint();


}
public void timeupdate(){
	if(count%(1000/delay)==0){
	if(sec!=59)
		sec++;
	else {min++;sec=0;}
	time.setText("min:"+min+" sec :"+sec);
	}
}
}
