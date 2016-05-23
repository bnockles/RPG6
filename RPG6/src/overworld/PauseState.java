package overworld;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;




public class PauseState extends State {
	private int width, height;
	public PauseState(Handler handler, int width, int height){
		super(handler);
		this.width=width;
		this.height=height;
	}
	public void drawScreen(Graphics g) {
		State.getGameState().render(g);
		g.setColor(new Color(.3f, .3f, .3f, .3f));
		g.drawRect (0, 0, width, height);    
		g.fillRect (0, 0, width, height);
	    g.setColor(Color.black);
	    g.setFont(new Font("Aharoni", Font.BOLD, 100));
	    g.drawString("PAUSED", 320, 380);
	    g.setFont(new Font("Aharoni", Font.BOLD, 30));
	    g.drawString("Press 'R' to resume", 370, 440);
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		drawScreen(g);
	}
}
