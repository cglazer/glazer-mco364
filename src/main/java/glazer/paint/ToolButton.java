package glazer.paint;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tool tool;

	public ToolButton(Tool tool, String iconName) {
		this.tool = tool;
		this.setImageI(iconName);

	}

	public Tool getTool() {
		return tool;
	}

	public void setImageI(String fileName) {

		ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
		Image img = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon.setImage(img);
		setIcon(icon);
	}
}
