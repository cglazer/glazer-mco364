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
	private ToolButton eraser;
	private JPanel northPanel;
	private JButton undo;
	private JButton redo;
	private JButton colors;
	private JLabel color;
	private Color newColor;
	private PaintProperties properties;
	private EraserTool eraserTool;
	private LineTool lineTool;
	private OvalTool ovalTool;
	private PencilTool pencilTool;
	private RectangleTool rectangleTool;
	private BucketTool bucketTool;

	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.container = getContentPane();
		this.container.setLayout(new BorderLayout());
		this.canvas = new Canvas();
		this.container.add(canvas, BorderLayout.CENTER);
		this.northPanel = new JPanel();
		this.container.add(northPanel, BorderLayout.NORTH);
		this.undo = new JButton();
		this.redo = new JButton();
		this.colors = new JButton();
		this.color = new JLabel("C");
		this.properties = new PaintProperties(800, 600);
		this.eraserTool = new EraserTool(this.properties);
		this.lineTool = new LineTool(this.properties);
		this.ovalTool = new OvalTool(this.properties);
		this.pencilTool = new PencilTool(this.properties);
		this.rectangleTool = new RectangleTool(this.properties);
		this.bucketTool = new BucketTool(this.properties);

		this.northPanel.add(this.undo);
		this.northPanel.add(this.redo);
		this.color.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.color.setSize(20, 60);
		this.color.setOpaque(true);
		setColor(Color.BLACK);
		this.northPanel.add(this.color);
		this.northPanel.add(this.colors);
		setIconImage(setImage("/paintIcon.jpg", 10, 10).getImage());
		this.redo.setIcon(setImage("/RedoIcon.jpg", 1, 1));
		this.undo.setIcon(setImage("/UndoIcon.jpg", 1, 1));
		this.colors.setIcon(setImage("/ColorsIcon.jpg", 4, 3));
		canvas.setTool(pencilTool);
		ToolButton buttons[] = new ToolButton[] { new ToolButton(bucketTool, "/BucketFillIcon.jpg"),
				new ToolButton(eraserTool, "/EraserIcon.png"), new ToolButton(lineTool, "/LineIcon.png"),
				new ToolButton(pencilTool, "/PencilIcon.jpg"), new ToolButton(rectangleTool, "/RectangleIcon.jpg"),
				new ToolButton(ovalTool, "/OvalIcon.png") };
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ToolButton button = (ToolButton) e.getSource();
				canvas.setTool(button.getTool());

			}
		};
		for (ToolButton button : buttons) {
			this.northPanel.add(button);
			button.addActionListener(listener);
		}
		this.colors.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// canvas.setColor(Color.RED);
				newColor = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
				if (newColor != null) {
					setColor(newColor);
					properties.setColor(newColor);
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
		Image img = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		icon.setImage(img);
		return icon;
	}

	public static void main(String[] args) {
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
	}
}
