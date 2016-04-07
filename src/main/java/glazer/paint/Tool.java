package glazer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Tool {

	protected PaintProperties properties;

	// by definition, all methods of an interface are public
	public Tool(PaintProperties properties) {
		this.properties = properties;
	}

	abstract void mousePressed(Graphics2D g, int x, int y, BufferedImage image);

	abstract void mouseReleased(Graphics2D g, int x, int y);

	abstract void mouseDragged(Graphics2D g, int x, int y);

	abstract  void drawPreview(Graphics2D g);
		// TODO Auto-generated method stub
		
	

}
