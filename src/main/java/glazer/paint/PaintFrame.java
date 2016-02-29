package glazer.paint;

//andrewoid/students-spring-2016-projects-1
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container;
	private Canvas canvas;

	private JButton eraser;
	private JButton line;
	private JButton pencil;
	private JButton rectangle;
	private JButton oval;
	private JPanel northPanel;
	private JButton BucketFill;
	private JButton undo;
	private JButton redo;
	private JButton colors;
	private JLabel color;
	private Color newColor;

	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.container = getContentPane();
		this.container.setLayout(new BorderLayout());
		this.canvas = new Canvas();
		this.BucketFill = new JButton();
		container.add(canvas, BorderLayout.CENTER);
		this.northPanel = new JPanel();
		this.eraser = new JButton();
		this.container.add(northPanel, BorderLayout.NORTH);
		this.northPanel.add(eraser);
		this.line = new JButton();
		this.pencil = new JButton();
		this.rectangle = new JButton();
		this.oval = new JButton();
		this.undo = new JButton();
		this.redo = new JButton();
		this.colors = new JButton();
		this.color = new JLabel("C");
		this.northPanel.add(line);
		this.northPanel.add(pencil);
		this.northPanel.add(this.rectangle);
		this.northPanel.add(this.oval);
		this.northPanel.add(this.BucketFill);
		this.northPanel.add(this.undo);
		this.northPanel.add(this.redo);
		this.color.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.color.setSize(20, 60);
		this.color.setOpaque(true);
		setColor(Color.BLACK);
		this.northPanel.add(this.color);
		this.northPanel.add(this.colors);
		setIconImage(setImage("./paintIcon.jpg", 10, 10).getImage());
		this.eraser.setIcon(setImage("./EraserIcon.png", 1, 1));
		this.line.setIcon(setImage("LineIcon.png", 1, 1));
		this.BucketFill.setIcon(setImage("BucketFillIcon.jpg", 1, 1));
		this.oval.setIcon(setImage("OvalIcon.png", 1, 1));
		this.pencil.setIcon(setImage("PencilIcon.jpg", 1, 1));
		this.rectangle.setIcon(setImage("RectangleIcon.jpg", 1, 1));
		this.redo.setIcon(setImage("RedoIcon.jpg", 1, 1));
		this.undo.setIcon(setImage("UndoIcon.jpg", 1, 1));
		this.colors.setIcon(setImage("ColorsIcon.jpg", 4, 3));

		this.eraser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canvas.setTool(new EraserTool());
				;
			}

		});
		this.line.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canvas.setTool(new LineTool());
			}

		});
		this.pencil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canvas.setTool(new PencilTool());
			}

		});
		this.rectangle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canvas.setTool(new RectangleTool());
			}

		});
		this.oval.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canvas.setTool(new OvalTool());
			}

		});
		this.BucketFill.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canvas.setTool(new BucketTool());
			}

		});
		this.colors.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// canvas.setColor(Color.RED);
				newColor = JColorChooser.showDialog(null, "Choose a color",
						Color.BLACK);
				if (newColor != null) {
					setColor(newColor);
					canvas.setColor(newColor);
				}
			}

		});

		this.undo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canvas.undo();
			}

		});
		this.redo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canvas.redo();
			}

		});

	}

	private void setColor(Color c) {
		// TODO Auto-generated method stub
		this.color.setBackground(c);
		this.color.setForeground(c);
		repaint();
	}

	public ImageIcon setImage(String fileName, int width, int height) {
		width *= 20;
		height *= 20;
		ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
		Image img = icon.getImage().getScaledInstance(width, height,
				java.awt.Image.SCALE_SMOOTH);
		icon.setImage(img);
		return icon;
	}

	public static void main(String[] args) {
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}
}
