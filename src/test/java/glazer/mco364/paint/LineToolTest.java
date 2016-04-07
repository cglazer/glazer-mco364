package glazer.mco364.paint;

import glazer.paint.LineTool;
import glazer.paint.PaintProperties;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.mockito.Mockito;

public class LineToolTest {

	@Test
	public void testMouseReleased() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		LineTool tool = new LineTool(properties);
		Graphics2D g = Mockito.mock(Graphics2D.class);
		BufferedImage image = Mockito.mock(BufferedImage.class);
		Mockito.when(image.getGraphics()).thenReturn(g);
		tool.mousePressed(g, 5, 6, image);
		tool.mouseReleased(g, 10, 11);
		Mockito.verify(g).drawLine(5, 6, 10, 11);
		// check to make sure that g.drawLine(5,5,10,10) was called

	}

	@Test
	public void testDrawPreview() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		LineTool tool = new LineTool(properties);
		Graphics2D g = Mockito.mock(Graphics2D.class);
		BufferedImage image = Mockito.mock(BufferedImage.class);
		Mockito.when(image.getGraphics()).thenReturn(g);
		tool.mousePressed(g, 3, 4, image);
		tool.mouseDragged(g, 7, 8);
		tool.drawPreview(g);
		Mockito.verify(g).drawLine(3, 4, 7, 8);
	}
}
