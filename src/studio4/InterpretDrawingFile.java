package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File

		String shape = in.next();
		int red = in.nextInt();
		int green = in.nextInt();
		int blue = in.nextInt();
		boolean filled = in.nextBoolean();

		Color penColor = new Color(red,green,blue);
		StdDraw.setPenColor(penColor);

		if(shape.equals("rectangle")) {
			double xPos = in.nextDouble();
			double yPos = in.nextDouble();
			double halfWidth = in.nextDouble();
			double halflength = in.nextDouble();
			if(filled == true) {
				StdDraw.filledRectangle(xPos, yPos, halfWidth, halflength);
			}else {
				StdDraw.rectangle(xPos, yPos, halfWidth, halflength);
			}
		}else if(shape.equals("ellipse")) {
			double xPos = in.nextDouble();
			double yPos = in.nextDouble();
			double majorAxis = in.nextDouble();
			double minorAxis = in.nextDouble();
			if (filled == true) {
				StdDraw.filledEllipse(xPos, yPos, majorAxis, minorAxis);
			}else {
				StdDraw.ellipse(xPos, yPos, majorAxis, minorAxis);
			}
		}else {
			double xPos1 = in.nextDouble();
			double yPos1 = in.nextDouble();
			double xPos2 = in.nextDouble();
			double yPos2 = in.nextDouble();
			double xPos3 = in.nextDouble();
			double yPos3 = in.nextDouble();
			double[] x = {xPos1, xPos2, xPos3};
			double[] y = {yPos1, yPos2, yPos3};
			if (filled == true) {
				StdDraw.filledPolygon(x, y);
			}else {
				StdDraw.polygon(x, y);
			}
		}
	}
}