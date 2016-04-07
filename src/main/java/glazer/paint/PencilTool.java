package glazer.paint;


import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class PencilTool extends Tool {
	public PencilTool(PaintProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	private int x;
	private int y;

	public void mousePressed(Graphics2D g, int x, int y,
			BufferedImage image) {
		// TODO Auto-generated method stub
		g.setColor(properties.getColor());
		g.setStroke(properties.getStroke());
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics2D g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		// TODO Auto-generated method stub
		g.setStroke(properties.getStroke());
		g.drawLine(x, y, this.x, this.y);
		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
