package glazer.paint;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PencilTool extends Tool {
	public PencilTool(PaintProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	private int x;
	private int y;

	public void mousePressed(Graphics g, int x, int y,
			BufferedImage image) {
		// TODO Auto-generated method stub
		g.setColor(properties.getColor());
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		// TODO Auto-generated method stub
		g.drawLine(x, y, this.x, this.y);
		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
