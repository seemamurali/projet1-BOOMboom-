import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class boom extends JFrame implements ActionListener
{
	ArrayList l;
	static String enteredplayername;
	static Properties p;
	FileOutputStream fos;
	//FileInputStream fis;
	JWindow startwind;
	JTextField playername1;
	JButton enter;
	JLabel errorname,start;
	JWindow pbw;
	JProgressBar pb;
	int ii=0;
	boom()
	{
		setTitle("BOOMboom");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//title desing

		JLabel bmtitle=new JLabel(new ImageIcon("boom.jpg"));
		bmtitle.setForeground(Color.blue);
		bmtitle.setBounds(460,30,450,450);
		
		add(bmtitle);
	
		pbw=new JWindow();

		JPanel pbpanel=new JPanel();
		pbpanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		pbpanel.setBackground(Color.WHITE);
		pbw.setSize(800,30);
		pbw.setLocation(270,555);
		pbw.add(pbpanel);
		
		pb=new JProgressBar(0,2000);
		pb.setBounds(40,40,500,80);  
		pb.setForeground(Color.red);
		pb.setBackground(Color.white);
		pb.setValue(0);
		pb.setFont(new Font("Monospaced",Font.BOLD,25));
		pb.setString("L o a d i n g . . .");
		pb.setStringPainted(true);    
		pbw.add(pb);
		//

		JLabel playername=new JLabel("Enter your name :");
		playername.setFont(new Font("Monospaced",Font.BOLD,25));
		playername.setBounds(377,525,280,30);
		add(playername);

		errorname=new JLabel("");
		errorname.setFont(new Font("Monospaced",Font.BOLD,18));
		errorname.setForeground(Color.red);
		errorname.setBounds(550,565,380,30);
		add(errorname);

		playername1=new JTextField();
		playername1.setFont(new Font("Monospaced",Font.BOLD,18));
		playername1.setBounds(650,533,150,25);
		add(playername1);

		enter=new JButton("Submit");
		enter.setFont(new Font("Monospaced",Font.BOLD,18));
		enter.setForeground(Color.black);
		enter.setBackground(Color.green);
		enter.setBounds(820,533,100,25);
		enter.addActionListener(this);
		add(enter);

		//
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		pbw.setVisible(true);

		//      progressbar......
			
		while(ii<=2000)
		{    
			pb.setValue(ii);    
			ii=ii+20;    
			try{
				Thread.sleep(200);
				}
				catch(Exception re){}    
		} 
		
		startwind=new JWindow();
		startwind.setBounds(270,520,800,100);
		startwind.getContentPane().setBackground(Color.white);

		start=new JLabel("",JLabel.CENTER);
		start.setFont(new Font("Monospaced",Font.BOLD,60));
		//start.setBorder(BorderFactory.createLineBorder(Color.black));
		start.setForeground(Color.black);
		startwind.add(start);

		// entering player name.....................

		startwind.setVisible(true);
		//

		String ready[]={". . 3 . .",". . 2 . .",". . 1 . .",". . s t a r t . ."};
		for(String r:ready)
		{
			try
			{
				Thread.sleep(600);
				pbw.dispose();  // to close the progress bar.......
				start.setText(r);
				Thread.sleep(600);
				start.setText("");
			}
			catch (Exception e){}
		}
		startwind.dispose();
	}

	// action listener...........

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==enter)
		{
			String name1="";
			enteredplayername=playername1.getText();
			
			if(name1.equals(enteredplayername))
			{
				errorname.setText("* Please enter your name.");
			}
			else if(enteredplayername.length()>17)
			{
				errorname.setText("* Name allow's 17 characters only.");
			}
			else
			{
				errorname.setText("");
				
				// saving player name in database.....

				File playernamefile=new File("PlayersScore.txt");
				try
				{
					playernamefile.createNewFile();

					PrintWriter pw2=new PrintWriter(new FileWriter(playernamefile,true));
				
					p=new Properties();
					FileInputStream fis=new FileInputStream(playernamefile);
					p.load(fis);
				String str;
				Set set=p.keySet();
				Iterator itr=set.iterator();	
				l=new ArrayList();
				while(itr.hasNext())
				{
					str=(String)itr.next();
					l.add(str);
				}
				if(l.contains(enteredplayername))
					{
					
					}
					else
					{
						
						p.setProperty(enteredplayername,"0");  // for new playerss
					}
					fos=new FileOutputStream(playernamefile);
					p.store(fos,"updated by murali_seema");
				pw2.close();
				}
				catch (Exception e)
				{
				}
				// opening game....
				new bounds1();
				dispose();		
			}
		}
	}

	//......main mmmmmmmmm

	public static void main(String args[])
	{
		new boom();
	}
}