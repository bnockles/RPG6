package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import directors.Game;
import directors.Screen;

public class BattleScreen extends Screen {
	Screen battleScreen;
	public BattleScreen(Game game) {
		super(game);
		battleScreen = new BattleScreen(game);
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		Color c = new Color(0, 102, 51, 200);
		g2.setColor(c);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}

}
