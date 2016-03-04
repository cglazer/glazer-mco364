package glazer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EraserTool extends Tool {

	public EraserTool(PaintProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	public void mousePressed(Graphics g, int x, int y,
			BufferedImage image) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 8, 8);
	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 8, 8);
	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

}
