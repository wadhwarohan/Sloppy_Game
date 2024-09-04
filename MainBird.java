package SloppyBirdPac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
public class MainBird{
     //window
	//1st window
	//2nd window
	private JFrame window;
	public static Timer timer,timer2;
	private int proceed=4;
	public MainBird()
	{
		window=new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //To Terminate the window
		window.setSize(GamePanel.WIDTH,GamePanel.HEIGHT);
		window.setLocationRelativeTo(null); //Display Window on center
		window.setResizable(false);
		window.setTitle("Sloppy Bird");
		
	}
	private void rendering()
	{
	    MenuPanel mp=new MenuPanel();
	    GamePanel gp=new GamePanel(); 
	   
	      timer=new Timer(20,new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		gp.repaint();
	    		gp.move();
	    	}
	    	});
	    	 
		window.add(mp);
		window.setVisible(true);
		while(mp.StartingPoint==false)
		{
			try {
				Thread.sleep(10);
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		window.remove(mp); //when we clicked menupanel removed and gamepanel displayed
		window.add(gp); //when we clicked menupanel removed and gamepanel displayed
		gp.setVisible(true);
		window.revalidate();
		//Start timer
		//timer.start();
		timer2=new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				proceed--;
				GamePanel.proceed=proceed;
				GamePanel.starting=true;
				gp.repaint();
				if(proceed==0)
				{
					timer2.stop();
					timer.start();
					GamePanel.starting=false;
				}
			}
		});
		timer2.start();
	}
	public static void main(String[] args) {
		MainBird mb=new MainBird();
		mb.rendering();

	}

}
