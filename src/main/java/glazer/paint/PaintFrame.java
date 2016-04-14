package glazer.paint;

//andrewoid/students-spring-2016-projects-1
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container;
	

	@Inject
	public PaintFrame(Canvas canvas, PaintToolbar toolbar) {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.container = getContentPane();
		this.container.setLayout(new BorderLayout());
		this.container.add(canvas, BorderLayout.CENTER);
		this.container.add(toolbar, BorderLayout.NORTH);
		setIconImage(setImage("/paintIcon.jpg", 10, 10).getImage());
	}

	public ImageIcon setImage(String fileName, int width, int height) {
		width *= 20;
		height *= 20;
		ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
		Image img = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		icon.setImage(img);
		return icon;
	}

	public static void main(String[] args) throws SecurityException, IOException {
		Logger logger= Logger.getLogger("glazer.paint");
		logger.setLevel(Level.FINE);
		Handler handler= new FileHandler("log");
		handler.setLevel(Level.FINE);
		handler.setFormatter(new SimpleFormatter());
		logger.addHandler(handler);
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class);
		frame.setVisible(true);
	}
}
