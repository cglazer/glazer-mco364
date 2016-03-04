package glazer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Tool {

	protected PaintProperties properties;

	// by definition, all methods of an interface are public
	public Tool(PaintProperties properties) {
		this.properties = properties;
	}

	abstract void mousePressed(Graphics g, int x, int y, BufferedImage image);

	abstract void mouseReleased(Graphics g, int x, int y);

	abstract void mouseDragged(Graphics g, int x, int y);

	abstract void drawPreview(Graphics g);
}
