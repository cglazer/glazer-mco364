package glazer.paint;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PaintToolbar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EraserTool eraserTool;
	private LineTool lineTool;
	private OvalTool ovalTool;
	private PencilTool pencilTool;
	private RectangleTool rectangleTool;
	private BucketTool bucketTool;
	private JButton undo;
	private JButton redo;
	private JButton colors;
	private Color newColor;
	private JLabel color;	

	@Inject
	public PaintToolbar(final Canvas canvas, final PaintProperties properties) {
		setLayout(new FlowLayout());
		this.eraserTool = new EraserTool(properties);
		this.lineTool = new LineTool(properties);
		this.ovalTool = new OvalTool(properties);
		this.pencilTool = new PencilTool(properties);
		this.rectangleTool = new RectangleTool(properties);
		this.bucketTool = new BucketTool(properties);
		this.undo = new JButton();
		this.redo = new JButton();
		this.colors = new JButton();
		this.color = new JLabel("C");
		this.color.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.color.setSize(20, 60);
		this.color.setOpaque(true);
		ToolButton buttons[] = new ToolButton[] { new ToolButton(bucketTool, "/BucketFillIcon.jpg"),
				new ToolButton(eraserTool, "/EraserIcon.png"), new ToolButton(lineTool, "/LineIcon.png"),
				new ToolButton(pencilTool, "/PencilIcon.jpg"), new ToolButton(rectangleTool, "/RectangleIcon.jpg"),
				new ToolButton(ovalTool, "/OvalIcon.png") };
		this.redo.setIcon(setImage("/RedoIcon.jpg", 1, 1));
		this.undo.setIcon(setImage("/UndoIcon.jpg", 1, 1));
		this.colors.setIcon(setImage("/ColorsIcon.jpg", 4, 3));
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ToolButton button = (ToolButton) e.getSource();
				canvas.setTool(button.getTool());
			}
		};
		for (ToolButton button : buttons) {
			add(button);
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
		add(this.undo);
		add(this.redo);
		add(this.colors);
		add(this.color);
		
	}
	public ImageIcon setImage(String fileName, int width, int height) {
		width *= 20;
		height *= 20;
		ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
		Image img = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		icon.setImage(img);
		return icon;
	}
	private void setColor(Color c) {
		// TODO Auto-generated method stub
		this.color.setBackground(c);
		this.color.setForeground(c);
		repaint();
	}
}
