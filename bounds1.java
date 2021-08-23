import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.List;
import java.util.*;
public class bounds1 implements ActionListener
{
	static Properties p;
	static bounds2 b;
	static JFrame f;
	static JWindow playerswind,gameoverwind,playaginwind,menulistwind,helpwind,settingswind,exitwind,developerwind;
	static JLabel scorenum;
	JButton replay,cancelsettings,apply,yesexit,noexit,canceladmin;
	Choice bchoice,bgchoice;
	 //buttons for menulistwind
	 JButton pause,countinue,restart,highscore,settings,developer,help,exit;

	List playerslist;

	//   constructor
	
	public bounds1()
	{

		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setTitle("BOOMboom");


		b=new bounds2();
		f.add(b);

		// jwind for game over

		gameoverwind=new JWindow();
		gameoverwind.setBounds(400,33,550,540);
		gameoverwind.setLayout(null);
		gameoverwind.getContentPane().setBackground(Color.white);

		JLabel boomimg=new JLabel(new ImageIcon("boom2.jpg"));
		boomimg.setBounds(0,100,550,280);
		gameoverwind.add(boomimg);

		
		JLabel end=new JLabel("G A M E   O V E R",JLabel.CENTER);
		end.setFont(new Font("Monospaced",Font.BOLD,47));
		end.setBounds(0,320,550,150);
		end.setForeground(Color.red);
		gameoverwind.add(end);

		// jwind for playagin and score

		playaginwind=new JWindow();
		playaginwind.setBounds(397,576,556,80);
		playaginwind.setLayout(null);
		playaginwind.getContentPane().setBackground(Color.LIGHT_GRAY);	

		
		replay=new JButton(" P L A Y    A G A I N ");
		replay.setFont(new Font("Serif",Font.BOLD,20));
		replay.setBounds(0,0,556,40);
		replay.setForeground(Color.black);
		replay.setBackground(Color.cyan);
		replay.addActionListener(this);
		playaginwind.add(replay);

		JLabel scoretext=new JLabel("S C O R E : ");
		scoretext.setBounds(200,40,556,35);
		scoretext.setFont(new Font("Serif",Font.BOLD,20));
		scoretext.setForeground(Color.black);
		playaginwind.add(scoretext);
				
		scorenum=new JLabel("");
		scorenum.setFont(new Font("Serif",Font.BOLD,20));
		scorenum.setBounds(310,40,556,35);
		scorenum.setForeground(Color.BLACK);
		playaginwind.add(scorenum);

		//  jwind for menu items......
		
		menulistwind=new JWindow();
		menulistwind.setBounds(953,30,300,626);
		menulistwind.getContentPane().setBackground(Color.LIGHT_GRAY);
		menulistwind.setLayout(null);

		pause = new JButton("Pause");
		pause.setFont(new Font("Monospaced",Font.BOLD,20));
		pause.setBorder(BorderFactory.createLineBorder(Color.black));
		pause.setBackground(Color.white);
		pause.setForeground(Color.black);
		pause.setBounds(75,50,150,30);
		pause.addActionListener(this);
		menulistwind.add(pause);

		countinue = new JButton("Countinue");
		countinue.setFont(new Font("Monospaced",Font.BOLD,20));
		countinue.setBorder(BorderFactory.createLineBorder(Color.black));
		countinue.setBackground(Color.white);
		countinue.setForeground(Color.black);
		countinue.setBounds(75,100,150,30);
		countinue.addActionListener(this);
		menulistwind.add(countinue);

		restart = new JButton("Restart");
		restart.setFont(new Font("Monospaced",Font.BOLD,20));
		restart.setBorder(BorderFactory.createLineBorder(Color.black));
		restart.setBackground(Color.white);
		restart.setForeground(Color.black);
		restart.setBounds(75,150,150,30);
		restart.addActionListener(this);
		menulistwind.add(restart);

		
		highscore = new JButton("High-Score");
		highscore.setFont(new Font("Monospaced",Font.BOLD,20));
		highscore.setBorder(BorderFactory.createLineBorder(Color.black));
		highscore.setBackground(Color.white);
		highscore.setForeground(Color.black);
		highscore.setBounds(75,200,150,30);
		highscore.addActionListener(this);
		menulistwind.add(highscore);

		settings = new JButton("Settings");
		settings.setFont(new Font("Monospaced",Font.BOLD,20));
		settings.setBorder(BorderFactory.createLineBorder(Color.black));
		settings.setBackground(Color.white);
		settings.setForeground(Color.black);
		settings.setBounds(75,250,150,30);
		settings.addActionListener(this);
		menulistwind.add(settings);

		developer = new JButton("Developer");
		developer.setFont(new Font("Monospaced",Font.BOLD,20));
		developer.setBorder(BorderFactory.createLineBorder(Color.black));
		developer.setBackground(Color.white);
		developer.setForeground(Color.black);
		developer.setBounds(75,300,150,30);
		developer.addActionListener(this);
		menulistwind.add(developer);

		help = new JButton("Help");
		help.setFont(new Font("Monospaced",Font.BOLD,20));
		help.setBorder(BorderFactory.createLineBorder(Color.black));
		help.setBackground(Color.white);
		help.setForeground(Color.black);
		help.setBounds(75,350,150,30);
		help.addActionListener(this);
		menulistwind.add(help);

		exit = new JButton("Exit");
		exit.setFont(new Font("Monospaced",Font.BOLD,20));
		exit.setBorder(BorderFactory.createLineBorder(Color.black));
		exit.setBackground(Color.white);
		exit.setForeground(Color.black);
		exit.setBounds(75,400,150,30);
		exit.addActionListener(this);
		menulistwind.add(exit);

		//settings wind...........

		settingswind=new JWindow();
		settingswind.setBounds(350,200,650,300);
		settingswind.getContentPane().setBackground(Color.cyan);
		settingswind.setLayout(null);

		JLabel blabel=new JLabel("Balls color :");           
		blabel.setFont(new Font("Monospaced",Font.BOLD,20));
		blabel.setForeground(Color.black);
		blabel.setBounds(170,20,170,30);
		settingswind.add(blabel);

		bchoice=new Choice();
		bchoice.setFont(new Font("Monospaced",Font.BOLD,18));
		bchoice.setBounds(350,20,150,30);
		bchoice.add("blue");
		bchoice.add("black");
		bchoice.add("red");
		bchoice.add("cyan");
		settingswind.add(bchoice);

		JLabel bglabel=new JLabel("Background color :");           
		bglabel.setFont(new Font("Monospaced",Font.BOLD,20));
		bglabel.setBounds(110,70,220,30);
		bglabel.setForeground(Color.black);
		settingswind.add(bglabel);

		bgchoice=new Choice();
		bgchoice.setFont(new Font("Monospaced",Font.BOLD,18));
		bgchoice.setBounds(350,70,150,30);
		bgchoice.add("light_gray");
		bgchoice.add("pink");
		bgchoice.add("yellow");

		settingswind.add(bgchoice);

		apply=new JButton("Apply");
		apply.setFont(new Font("Monospaced",Font.BOLD,20));
		apply.setBorder(BorderFactory.createLineBorder(Color.black));
		apply.setBackground(Color.white);
		apply.setForeground(Color.black);
		apply.setBounds(200,250,100,30);
		apply.addActionListener(this);
		settingswind.add(apply);

		cancelsettings=new JButton("Cancel");
		cancelsettings.setFont(new Font("Monospaced",Font.BOLD,20));
		cancelsettings.setBorder(BorderFactory.createLineBorder(Color.black));
		cancelsettings.setBackground(Color.white);
		cancelsettings.setForeground(Color.black);
		cancelsettings.setBounds(350,250,100,30);
		cancelsettings.addActionListener(this);
		settingswind.add(cancelsettings);

		// developer wind......

		developerwind=new JWindow();
		developerwind.setBounds(350,100,650,400);
		developerwind.getContentPane().setBackground(Color.cyan);
		developerwind.setLayout(null);

		JLabel adminimg=new JLabel(new ImageIcon("admin.jpg"));
		adminimg.setBounds(275,10,125,160);
		adminimg.setBorder(BorderFactory.createLineBorder(Color.black));
		developerwind.add(adminimg);
		
		JLabel adminname=new JLabel("S E E M A   M U R A L I");
		adminname.setFont(new Font("Monospaced",Font.BOLD,25));
		adminname.setBounds(150,190,400,30);
		adminname.setForeground(Color.red);
		developerwind.add(adminname);

		canceladmin=new JButton("Cancel");
		canceladmin.setFont(new Font("BorderFactory",Font.BOLD,18));
		canceladmin.setBorder(BorderFactory.createLineBorder(Color.black));
		canceladmin.setBackground(Color.white);
		canceladmin.setForeground(Color.black);
		canceladmin.setBounds(500,360,80,25);
		canceladmin.addActionListener(this);
		developerwind.add(canceladmin);

		JTextArea multi = new JTextArea("The developer for this BOOMboom application is Mr.seema murali. He used pure java language(front-end: awt & graphics, back-end: java, database: file IO) to develop this application. For more information contact 9908681605 or seemamurali45@gmail.com.");
		multi.setFont(new Font("Monospaced",Font.BOLD,18));
		multi.setForeground(Color.black);
		multi.setBounds(10,250,650,200);
		multi.setWrapStyleWord(true);
		multi.setLineWrap(true);
		multi.setBackground(Color.cyan);
		developerwind.add(multi);

		// exit wind.....

		exitwind=new JWindow();
		exitwind.setBounds(350,200,650,200);
		exitwind.getContentPane().setBackground(Color.cyan);
		exitwind.setLayout(null);

		JLabel exitlabel=new JLabel("Are you sure to exit?");           
		exitlabel.setFont(new Font("Monospaced",Font.BOLD,20));
		exitlabel.setBounds(200,40,300,30);
		exitlabel.setForeground(Color.black);
		exitwind.add(exitlabel);

		yesexit=new JButton("Yes");
		yesexit.setFont(new Font("Monospaced",Font.BOLD,20));
		yesexit.setBorder(BorderFactory.createLineBorder(Color.black));
		yesexit.setBackground(Color.white);
		yesexit.setForeground(Color.black);
		yesexit.setBounds(200,140,100,30);
		yesexit.addActionListener(this);
		exitwind.add(yesexit);

		noexit=new JButton("Cancel");
		noexit.setFont(new Font("Monospaced",Font.BOLD,20));
		noexit.setBorder(BorderFactory.createLineBorder(Color.black));
		noexit.setBackground(Color.white);
		noexit.setForeground(Color.black);
		noexit.setBounds(350,140,100,30);
		noexit.addActionListener(this);
		exitwind.add(noexit);

		// help wind.....

		helpwind=new JWindow();
		helpwind.setBounds(0,380,397,326);
		helpwind.getContentPane().setBackground(Color.LIGHT_GRAY);
		helpwind.setLayout(null);
		
		JTextArea helptext=new JTextArea("Rules to play::							When we start's a game all balls are going to be started automatically. If any ball touched(more then 50%) to the under black bar, then game over. Each ball bring 2 points if it bounds without touching balck bar.");
		helptext.setFont(new Font("Monospaced",Font.BOLD,15));
		helptext.setForeground(Color.black);
		helptext.setBackground(Color.LIGHT_GRAY);
		helptext.setBounds(0,0,397,150);
		helptext.setWrapStyleWord(true);
		helptext.setLineWrap(true);
		helpwind.add(helptext);

		JTextArea helptext1=new JTextArea("how to move black bar::									front move : right_arrow			back move  : left_arrow				stop move  : up/down_arrow");
		helptext1.setFont(new Font("Monospaced",Font.BOLD,15));
		helptext1.setForeground(Color.black);
		helptext1.setBackground(Color.LIGHT_GRAY);
		helptext1.setBounds(0,151,397,125);
		helptext1.setWrapStyleWord(true);
		helptext1.setLineWrap(true);
		helpwind.add(helptext1);

		// adding list for players score...
		 
		playerswind=new JWindow();
		playerswind.setBounds(0,113,397,273);
		playerswind.getContentPane().setBackground(Color.LIGHT_GRAY);
		playerswind.setLayout(null);

		JLabel highscorelabel=new JLabel("Hight-score");
		highscorelabel.setBounds(100,0,250,30);
		highscorelabel.setFont(new Font("Monospaced",Font.BOLD,20));
		highscorelabel.setBackground(Color.red);
		playerswind.add(highscorelabel);

				playerslist=new List();
				playerslist.setFont(new Font("Monospaced",Font.BOLD,18));
				playerslist.setBounds(0,30,397,235);
				
				//

				File playernamefile=new File("PlayersScore.txt");
				try
				{
					playernamefile.createNewFile();
					PrintWriter pw2=new PrintWriter(new FileWriter(playernamefile,true));
					p=new Properties();
					FileInputStream fis=new FileInputStream(playernamefile);
					p.load(fis);
					FileOutputStream fos=new FileOutputStream(playernamefile);
					p.store(fos,"updated by murali_seema");
					pw2.close();
				}
				catch(Exception e){}
				
				//
				
				String str;
				Set set=p.keySet();
				Iterator itr=set.iterator();	
				
				while(itr.hasNext())
				{
					str=(String)itr.next();
					String fullplayer=str+"-----------"+p.getProperty(str);
					playerslist.add(fullplayer);
				}
				playerswind.add(playerslist);
				//
		
		f.setVisible(true);
		
		try
		{
			Thread.sleep(1);
		}
		catch (Exception e)
		{
		}
		menulistwind.setVisible(true);
		b.t.start();
	}

	// action performing.........

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==replay)
		{
			bounds2.score=-5;
			gameoverwind.dispose();
			playaginwind.dispose();
			playerswind.dispose();
			helpwind.dispose();
			
			f.dispose();
			new bounds1();	
		}
		if(ae.getSource()==restart)
		{
			b.t.stop();	
			bounds2.score=-5;
			gameoverwind.dispose();
			playaginwind.dispose();
			playerswind.dispose();
			helpwind.dispose();

			f.dispose();
			new bounds1();
		}
		if(ae.getSource()==pause)
		{
			b.t.stop();	
		}
		if(ae.getSource()==countinue)
		{
			b.t.start();	
		}
		if(ae.getSource()==highscore)
		{
				playerswind.setVisible(true);
		}
		
		if(ae.getSource()==settings)
		{
			b.t.stop();
			//
			exitwind.dispose();
			developerwind.dispose();
			settingswind.setVisible(true);
			//
		}
		if(ae.getSource()==apply)
		{

			// changing ball color...

			String ballcolor=bchoice.getItem(bchoice.getSelectedIndex());
			if(ballcolor.equals("blue"))
			{
				b.b1=0;
				b.b2=0;
				b.b3=255;
			}
			else if(ballcolor.equals("black"))
			{
				b.b1=0;
				b.b2=0;
				b.b3=0;
			}
			else if(ballcolor.equals("red"))
			{
				b.b1=255;
				b.b2=0;
				b.b3=0;
			}
			else if(ballcolor.equals("cyan"))
			{
				b.b1=0;
				b.b2=255;
				b.b3=255;
			}

			// changing bg colors.......

			String bgcolor=bgchoice.getItem(bgchoice.getSelectedIndex());
			if(bgcolor.equals("light_gray"))
			{
				b.bg1=211;
				b.bg2=211;
				b.bg3=211;
			}
			else if(bgcolor.equals("pink"))
			{
				b.bg1=255;
				b.bg2=192;
				b.bg3=203;
			}
			else if(bgcolor.equals("yellow"))
			{
				b.bg1=255;
				b.bg2=255;
				b.bg3=0;
			}
			b.t.start();
			settingswind.dispose();
		}
		if(ae.getSource()==cancelsettings)
		{
			b.t.start();
			//
			exitwind.dispose();
			settingswind.dispose();
			//
		}
		if(ae.getSource()==developer)
		{
			b.t.stop();
			exitwind.dispose();
			settingswind.dispose();
			developerwind.setVisible(true);
		}
		if(ae.getSource()==canceladmin)
		{
			b.t.start();
			
			developerwind.dispose();
		}
		if(ae.getSource()==help)
		{
			helpwind.setVisible(true);
			
		}
		if(ae.getSource()==exit)
		{
			b.t.stop();
			//
			developerwind.dispose();
			settingswind.dispose();
			exitwind.setVisible(true);
			//
		}
		if(ae.getSource()==yesexit)
		{
			//menulistwind.dispose();
			b.t.stop();
			//
			playerswind.dispose();
			menulistwind.dispose();
			exitwind.dispose();
			helpwind.dispose();
			gameoverwind.dispose();
			playaginwind.dispose();
			menulistwind.dispose();
			f.dispose();
			menulistwind.dispose();
			//
		}
		if(ae.getSource()==noexit)
		{
			b.t.start();
			exitwind.dispose();
		}
	}

	// stop() to stop game

	public static void stop()
	{
		String sc=Integer.toString(bounds2.score);
				
		if(bounds2.score<0)
		{
			scorenum.setText("0");
		}
		else
		{
		scorenum.setText(sc);
		}

		int oldscore=Integer.parseInt(p.getProperty(boom.enteredplayername));
		int newscore=Integer.parseInt(scorenum.getText());

		if(oldscore<newscore)
		{
			File playernamefile=new File("PlayersScore.txt");
				try
				{
					playernamefile.createNewFile();
					PrintWriter pw2=new PrintWriter(new FileWriter(playernamefile,true));
					p=new Properties();
					FileInputStream fis=new FileInputStream(playernamefile);
					p.load(fis);
					p.setProperty(boom.enteredplayername,scorenum.getText());
					FileOutputStream fos=new FileOutputStream(playernamefile);
					p.store(fos,"updated by murali_seema");
					pw2.close();
				}
				catch(Exception e){}
		}
		//
		gameoverwind.setVisible(true);
		playaginwind.setVisible(true);
	}
	public static void main(String args[])
	{
		new bounds1();
	}
}