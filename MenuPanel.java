package SloppyBirdPac;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.File;

public class MenuPanel extends JPanel {
//private static final long serialVersionUID=1L;
private BufferedImage img=null;
public boolean StartingPoint=false;
public MenuPanel() {
	LoadImage();
	//handle mouseclick event
	this.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			StartingPoint=true; // When we clicked on screen it becomes true
		}
	});
}
private void LoadImage()
{
	try {
		img=ImageIO.read(new File("D://DIT//Sloppy Game//SloppyBird//Images//menupanel.jpg"));
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
}
public void paint(Graphics g)
{
	super.paint(g);
	g.drawImage(img,0,0,GamePanel.WIDTH,GamePanel.HEIGHT,null);
}

}
