package glazer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class LineTool implements Tool {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public void mousePressed(Graphics g, int x, int y, Color color,
			BufferedImage image) {
		// TODO Auto-generated method stub

		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	public void mouseReleased(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.drawLine(this.x1, this.y1, x, y);
	}

	public void mouseDragged(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub
		this.x2 = x;
		this.y2 = y;

	}

	public void drawPreview(Graphics g, Color color) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.drawLine(this.x1, this.y1, x2, y2);
	}

}
