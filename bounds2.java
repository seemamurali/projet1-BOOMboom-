import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
public class bounds2 extends JPanel implements ActionListener,KeyListener
{
	Timer t=new Timer(1,this);
	
	int x=405,y=10,velx=0,vely=0;  // for line 
	int lx=400,ly=10,vellx=2,velly=3;// for ball 1
	int lx2=900,ly2=110,vellx2=3,velly2=3; //for ball 2
	int lx3=600,ly3=60,vellx3=2,velly3=4; // for ball 3
	static int score=0; // score
	static int b1=0,b2=0,b3=255;	// ball colors.....
	static int bg1=211,bg2=211,bg3=211;	// bg colors.....
	int note=0,velnote=0;
 
	public static JLabel actiondis;
	public bounds2()
	{
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.red);
		g.fillRect(397,7,556,546);
		g.setColor(new Color(bg1,bg2,bg3));
		g.fillRect(400,10,550,540);
		
		g.setColor(new Color(b1,b2,b3));
		g.fillOval(lx,ly,50,50);
		g.fillOval(lx2,ly2,50,50);
		g.fillOval(lx3,ly3,50,50);			

		g.setColor(Color.black);
		g.fillRect(x,543,100,7);

		// player name...

		g.setColor(Color.RED);
		g.setFont(new Font("Monospaced",Font.BOLD,25));
		g.drawString("Player : "+boom.enteredplayername,0,30);
		
		// note text..
		
		g.setColor(Color.red);
		g.setFont(new Font("Monospaced",Font.BOLD,15));
		g.drawString("Note :	Don't turn off your screen while playing game.",note,690);
		
		//
	}
	
	public void actionPerformed(ActionEvent e)
	{

		note=note+2;
		if(note>1400)
		{
			note=-500;
		}
		
		// for line moving.

		if(x<405||x>845)
		{
			velx=-velx;
		}
		if(y<10||y>500)
		{
			vely=-vely;
			
		}
		x+=velx;
		y+=vely;

		// for ball boundsing........

		if(lx<400||lx>900)
		{
			vellx=-vellx;
		}
		if(ly<10||ly>490)
		{
			velly=-velly;
			if(ly>490)
			{
				score=score+2;
				if(lx+30<=x+100&&lx+20>=x)
				{
					t.stop();
					bounds1.stop();
				}
				else
				{
					
				}
			}
		}
		
		lx+=vellx;
		ly+=velly;

		// ball 2 bounsing.....

		if(lx2<400||lx2>900)
		{
			vellx2=-vellx2;
		}
		if(ly2<10||ly2>490)
		{
			velly2=-velly2;
			if(ly2>490)
			{	
				score=score+2;
				if(lx2+30<=x+100&&lx2+20>=x)
				{
					t.stop();
					bounds1.stop();
				}
				else
				{
					
				}
			}
		}
		lx2+=vellx2;
		ly2+=velly2;

		// ball 3 bounsing........

		if(lx3<400||lx3>900)
		{
			vellx3=-vellx3;
		}
		if(ly3<10||ly3>490)
		{
			velly3=-velly3;
			if(ly3>490)
			{
				score=score+2;
				if(lx3+30<=x+100&&lx3+20>=x)
				{
					t.stop();
					bounds1.stop();
				}
				else
				{
					
				}
			}
		}
		lx3+=vellx3;
		ly3+=velly3;

		repaint();

	}
	public void up()
	{
		vely=-2;
		velx=0;	
	}
	public void down()
	{
		vely=2;
		velx=0;
	}
	public void left()
	{
		velx=-5;
		vely=0;
	}
	public void right()
	{
		
		velx=5;
		vely=0;
	}
	public void keyPressed(KeyEvent e)
	{
		int code=e.getKeyCode();
		if(code==KeyEvent.VK_UP)
		{
			up();
		}
		if(code==KeyEvent.VK_DOWN)
		{
			down();
		}
		if(code==KeyEvent.VK_LEFT)
		{
			left();
		}
		if(code==KeyEvent.VK_RIGHT)
		{
			right();
		}
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
}