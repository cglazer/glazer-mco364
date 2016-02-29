package glazer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EraserTool implements Tool {

	public void mousePressed(Graphics g, int x, int y, Color color,
			BufferedImage image) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 8, 8);
	}

	public void mouseReleased(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 8, 8);
	}

	public void drawPreview(Graphics g, Color color) {
		// TODO Auto-generated method stub

	}

}
