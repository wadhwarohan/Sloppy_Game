package SloppyBirdPac;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class WallImage {
private Random r=new Random();
public int X;
public int Y=r.nextInt(GamePanel.HEIGHT-400)+200;
private int width_Wall=45;
private int height=GamePanel.HEIGHT-Y;
private int gap=200;
public static int speed=-6;
private BufferedImage img=null;
public WallImage(int X) {
	this.X=X;
	LoadImage();
	
}
private void LoadImage() {
	try {
		img=ImageIO.read(new File("D://DIT//Sloppy Game//SloppyBird//Images//wall.jpg"));
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
	
}
public void drawWall(Graphics g)
{
	g.drawImage(img, X, Y,null); //bottom wall
	g.drawImage(img, X, (-GamePanel.HEIGHT)+(Y-gap),null); //upper Wall
}
public void wallMovement()
{
	X+=speed;
	if(X<=width_Wall)
	{
		X=GamePanel.WIDTH;
		Y=r.nextInt(GamePanel.HEIGHT-400)+200;
	    height=GamePanel.HEIGHT-Y;
	}
	Rectangle lowRect=new Rectangle(X,Y,width_Wall,height);
	Rectangle upperRect=new Rectangle(X,0,width_Wall,GamePanel.HEIGHT-(height+gap));
	if(lowRect.intersects(BirdImage.getBirdRect())||upperRect.intersects(BirdImage.getBirdRect())) {
		boolean option=GamePanel.popUpMessage();
		if(option)
		{
		try {
			Thread.sleep(500);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		BirdImage.reset();
		wall_Reset();
	}
	else
	{
		MainBird.timer.stop();//close the entire window if donot rest
	}
	}
}
private void wall_Reset() {
	// TODO Auto-generated method stub
	Y=r.nextInt(GamePanel.HEIGHT-400)+200;
	height=GamePanel.HEIGHT-Y;
	GamePanel.GameOver=true;
	
}
}
