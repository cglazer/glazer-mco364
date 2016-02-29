package glazer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class OvalTool implements Tool {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int width;
	private int height;
	private int startX;
	private int startY;

	public void mousePressed(Graphics g, int x, int y, Color color,
			BufferedImage image) {
		// TODO Auto-generated method stub
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	public void setStartX() {
		if (x1 < x2) {
			this.startX = x1;
			this.width = x2 - x1;
		} else {
			this.startX = x2;
			this.width = x1 - x2;
		}

	}

	public void setStartY() {
		if (y1 < y2) {
			this.startY = y1;
			this.height = y2 - y1;
		} else {
			this.startY = y2;
			this.height = y1 - y2;
		}
	}

	public void mouseReleased(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub
		this.x2 = x;
		this.y2 = y;
		setStartX();
		setStartY();
		g.setColor(color);
		g.drawOval(this.startX, this.startY, width, height);

	}

	public void mouseDragged(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub
		this.x2 = x;
		this.y2 = y;
	}

	public void drawPreview(Graphics g, Color color) {
		// TODO Auto-generated method stub
		setStartX();
		setStartY();
		g.setColor(color);
		g.drawOval(this.startX, this.startY, width, height);
	}

}
