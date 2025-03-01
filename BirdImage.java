package SloppyBirdPac;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class BirdImage {
private BufferedImage img=null;
private static int bird_dia=36; //diameter of bird
public static int x=(GamePanel.WIDTH/2)-bird_dia/2;
private static int y=(GamePanel.HEIGHT/2);

private static int speed=2;
private int acce=1;


public BirdImage()
{
	LoadImage();
}

private void LoadImage() {
	try
	{
		img=ImageIO.read(new File("D://DIT//Sloppy Game//SloppyBird//Images//bird.png"));
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
	
}
public void drawBird(Graphics g)
{
	g.drawImage(img, x, y, null);
}
public void birdMovement()
{
	if(y>=0&&y<=GamePanel.HEIGHT)
	{
		speed+=acce;//2,3,4,5
		y+=speed;//400+2,400+2+3,400+2+3+4,400+2+3+4+5
	}else
	{
		boolean option=GamePanel.popUpMessage();
		if(option)
		{
		try {
			Thread.sleep(500);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		reset();
	}
	else
	{
	MainBird.timer.stop();	//close the entire window if do not rest
	}
		
	}
}
public void goUpwards()
{
	speed=-17;
}
public static void reset() {
	speed=2;
	y=GamePanel.HEIGHT/2;
	GamePanel.GameOver=true;// the wall resets also if bird touches the up and down window
	GamePanel.score=0;
}
public static Rectangle getBirdRect()
{
	Rectangle birdRect=new Rectangle(x,y,bird_dia,35);//size of image=35
	return birdRect;
}
}
