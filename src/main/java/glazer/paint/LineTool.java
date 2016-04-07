package glazer.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class LineTool extends Tool {
	public LineTool(PaintProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public void mousePressed(Graphics2D g, int x, int y,
			BufferedImage image) {
		// TODO Auto-generated method stub

		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	public void mouseReleased(Graphics2D g, int x, int y) {
		// TODO Auto-generated method stub
		g.setColor(properties.getColor());
		g.drawLine(this.x1, this.y1, x, y);
	}

	public void mouseDragged(Graphics2D g, int x, int y) {
		// TODO Auto-generated method stub
		this.x2 = x;
		this.y2 = y;

	}

	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(properties.getColor());
		g.drawLine(this.x1, this.y1, x2, y2);
	}

}
