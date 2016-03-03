package glazer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;
	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private BufferedImage buffer;
	private Tool tool;
	private Color color;

	public Canvas() {
		setBackground(Color.WHITE);
		setCursor();
		this.tool = new PencilTool();
		this.buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		this.color = Color.BLACK;

		this.undo = new Stack<BufferedImage>();
		this.redo = new Stack<BufferedImage>();
		undo.add(copyImage(buffer));
		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				undo.add(copyImage(buffer));
				tool.mousePressed(buffer.getGraphics(), e.getX(), e.getY(),
						color, buffer);
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

				tool.mouseReleased(buffer.getGraphics(), e.getX(), e.getY(),
						color);
				repaint();

			}

		});
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				tool.mouseDragged(buffer.getGraphics(), e.getX(), e.getY(),
						color);
				repaint();
			}

			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g, color);
	}

	public void setTool(Tool tool) {
		// TODO Auto-generated method stub
		this.tool = tool;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void undo() {
		if (!undo.isEmpty()) {
			redo.add(copyImage(buffer));
			BufferedImage b = undo.pop();
			buffer = b;

		}
		repaint();
	}

	public void redo() {
		if (!redo.isEmpty()) {
			buffer = redo.pop();

		}
		repaint();
	}

	public BufferedImage copyImage(BufferedImage source) {
		BufferedImage b = new BufferedImage(source.getWidth(),
				source.getHeight(), source.getType());
		Graphics g = b.getGraphics();
		g.drawImage(source, 0, 0, null);
		g.dispose();
		return b;
	}

	public void setCursor() {
		ImageIcon icon = new ImageIcon(getClass().getResource("PencilIcon.jpg"));
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				icon.getImage(), new Point(0, 30), " "));
	}
}
