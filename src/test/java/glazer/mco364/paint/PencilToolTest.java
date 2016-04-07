package glazer.mco364.paint;

import glazer.paint.PaintProperties;
import glazer.paint.PencilTool;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.mockito.Mockito;

public class PencilToolTest {
	@Test
	public void testMouseReleased() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		PencilTool tool = new PencilTool(properties);
		Graphics2D g = Mockito.mock(Graphics2D.class);
		BufferedImage image = Mockito.mock(BufferedImage.class);
		Mockito.when(image.getGraphics()).thenReturn(g);
		tool.mousePressed(g, 5, 5, image);
		Mockito.verify(g).fillOval(5, 5, 1, 1);
	}

	@Test
	public void testMouseDragged() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		PencilTool tool = new PencilTool(properties);
		Graphics2D g = Mockito.mock(Graphics2D.class);
		BufferedImage image = Mockito.mock(BufferedImage.class);
		Mockito.when(image.getGraphics()).thenReturn(g);
		tool.mousePressed(g, 5, 5, image);
		tool.mouseDragged(g, 6, 6);
		Mockito.verify(g).drawLine(6, 6, 5, 5);
	}
}
