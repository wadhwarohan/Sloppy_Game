package SloppyBirdPac;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
private static final long serialVersionUID = 1L;
public static boolean GameOver=false;
public static boolean starting=false;
public static final int WIDTH=600;
public static final int HEIGHT=800;
private int xCoor=0;
public static int score=0;
public static int proceed=-1;
private BufferedImage img;
BirdImage bi=new BirdImage();
WallImage wi=new WallImage(GamePanel.WIDTH);
WallImage wi2=new WallImage(GamePanel.WIDTH+(GamePanel.WIDTH/2));
public GamePanel()
{
	LoadImage();
	//mouse press event
	this.addMouseListener(new MouseAdapter()
			{
		public void mousePressed(MouseEvent e)
		{
			super.mousePressed(e);
			bi.goUpwards();
		}
			});
}
private void LoadImage() {
	// TODO Auto-generated method stub
	try
	{
		img=ImageIO.read(new File("D://DIT//Sloppy Game//SloppyBird//Images//gamepanel.png"));
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(img,xCoor,0,null);
		g.drawImage(img,xCoor+2400,0,null);// It will not print blank background
		bi.drawBird(g);
		wi.drawWall(g);
		wi2.drawWall(g);
		
		g.setFont(new Font("Tahoma",Font.BOLD,40));
		g.drawString("Score :"+ score, WIDTH/2, 100);
		if(starting) {
			g.setFont(new Font("Tahoma",Font.BOLD,150));
			g.drawString(Integer.toString(proceed), WIDTH/2-75,250);
		}
	}
public void move()
{
	bi.birdMovement();
	wi.wallMovement();
	wi2.wallMovement();
	if(GameOver) {
		wi.X=GamePanel.WIDTH;
		wi2.X=GamePanel.WIDTH+(GamePanel.WIDTH/2);
		GamePanel.GameOver=false;
	}
	xCoor+=WallImage.speed;
	if(xCoor==-2400)
		xCoor=0;
	if(wi.X==BirdImage.x||wi2.X==BirdImage.x)
	{
		score+=1;
	}
}
public static boolean popUpMessage()
{
	int result=JOptionPane.showConfirmDialog(null, "Game Over, Your Score is "+score+"\n Do you want to restart","Game Over",JOptionPane.YES_NO_OPTION);
	if(result==JOptionPane.YES_OPTION)
	{
		return true;
	}
	else
		return false;
}
}
