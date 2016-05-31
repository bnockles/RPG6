package menus;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import directors.Game;
import directors.Screen;

public class MenuScreen extends Screen implements KeyListener{
    
    MenuItem current;
    int index = 0;
    
    MenuItem action = new MenuItem(null);
    MenuItem attack = new MenuItem("magicAttack");
    MenuItem run = new MenuItem("magicRun");

    MenuItem attackattack = new MenuItem("magicAttack");
    MenuItem attackspell = new MenuItem("magic");
    
    public MenuScreen(Game game) {
        super(game);
        
        ArrayList<MenuItem> list = new ArrayList<MenuItem>();
        list.add(new MenuItem(null));
        list.add(new MenuItem("magicAttack"));
        list.add(new MenuItem("magicRun"));
        list.add(new MenuItem("magic"));

        for(int i = 0; i < list.size(); i++){
        	addNode(list.get(i));
        }
        current = list.get(0);
    }

    @Override
    public void paintScreen(Graphics2D g2) {
    	
        g2.fillPolygon(new int[] {190, 205, 190}, new int[] {140+(index*50), 150+(index*50), 160+(index*50)}, 3);
        
        if(current.getParent() != null)
        g2.drawImage(current.getParent().getImage(), 100, 125, null);
        g2.drawImage(current.getImage(), 150, 125, null);
        for(int i = 0; i < current.getChildren().size(); i++)
        g2.drawImage(current.getChildren().get(i).getImage(), 200, 125+(i*50), null);
        
    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && !current.getChildren().isEmpty()){
            current = current.getChildren().get(index); index = 0;}
        if(e.getKeyCode() == KeyEvent.VK_LEFT && current.getParent() != null)
            current = current.getParent();
        if(e.getKeyCode() == KeyEvent.VK_UP)
        	if(index > 0)
        		index--;
        	else
        		index = current.getChildren().size()-1;
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        	if(index < current.getChildren().size()-1)
        		index++;
        	else
        		index = 0;
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
    }
    
    public void addNode(MenuItem item) {
        if(current == null)
        	current = item;
        else{
        	current.addChild(item);
        	item.setParent(current);
        }
    }
    
    public void createChildren(ArrayList<MenuItem> list){
        for(MenuItem parent : list)
		    for(MenuItem child : list)
		    	if(child.getParent() == parent)
		    		parent.addChild(child);
    }
}

	public BufferedImage getImage() {
		return image;
	}
}
