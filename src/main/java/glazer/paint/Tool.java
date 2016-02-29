package glazer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public interface Tool {
	// by definition, all methods of an interface are public
	void mousePressed(Graphics g, int x, int y, Color color, BufferedImage image);

	void mouseReleased(Graphics g, int x, int y, Color color);

	void mouseDragged(Graphics g, int x, int y, Color color);

	void drawPreview(Graphics g, Color color);
}
