package glazer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {
	private Queue<Point> queue;

	public BucketTool() {
		queue = new LinkedList<Point>();
	}

	public void mousePressed(Graphics g, int x, int y, Color color,
			BufferedImage image) {
		loopFill(x, y, image.getRGB(x, y), color, image);

	}

	public void loopFill(int x, int y, int oldRGB, Color color,
			BufferedImage image) {
		queue.add(new Point(x, y));
		int newX = x;
		int newY = y;

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			newX = p.getX();
			newY = p.getY();
			if (newX > 0 && newX < image.getWidth() && newY > 0
					&& newY < image.getHeight()
					&& oldRGB == image.getRGB(newX, newY)) {
				image.setRGB(newX, newY, color.getRGB());
				queue.add(new Point(newX + 1, newY));
				queue.add(new Point(newX - 1, newY));
				queue.add(new Point(newX, newY - 1));
				queue.add(new Point(newX, newY + 1));
			}
		}
	}

	public void mouseReleased(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y, Color color) {
		// TODO Auto-generated method stub

	}

	public void drawPreview(Graphics g, Color color) {
		// TODO Auto-generated method stub

	}

}
