package glazer.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool extends Tool {
	private Queue<Points> queue;
	
	public BucketTool(PaintProperties properties) {
		super(properties);
		queue = new LinkedList<Points>();
	}

	public void mousePressed(Graphics2D g, int x, int y, BufferedImage image) {
		loopFill(x, y, image.getRGB(x, y), super.properties.getColor(), image);

	}

	public void loopFill(int x, int y, int oldRGB, Color color, BufferedImage image) {
		if (image.getRGB(x, y) != color.getRGB()) {
			queue.add(new Points(x, y));
			int newX = x;
			int newY = y;

			while (!queue.isEmpty()) {
				Points p = queue.remove();
				newX = p.getX();
				newY = p.getY();
				if (newX <= 0 || newY <= 0 || newX >= image.getWidth() || newY >= image.getHeight()) {
					continue;
				}
				if (oldRGB == image.getRGB(newX, newY)) {
					image.setRGB(newX, newY, color.getRGB());
					queue.add(new Points(newX + 1, newY));
					queue.add(new Points(newX - 1, newY));
					queue.add(new Points(newX, newY - 1));
					queue.add(new Points(newX, newY + 1));
				}
			}
		}
	}

	public void mouseReleased(Graphics2D g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics2D g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
