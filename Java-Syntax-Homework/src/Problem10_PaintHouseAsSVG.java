import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.ext.awt.geom.Polygon2D;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;

public class Problem10_PaintHouseAsSVG {
	public static boolean readFromFile;

	public static boolean onTheRightSide(double[] firstPoint,
			double[] secondPoint, double X, double Y) {

		if ((secondPoint[0] - firstPoint[0]) * (Y - firstPoint[1])
				- (secondPoint[1] - firstPoint[1]) * (X - firstPoint[0]) < 0) {
			return false;
		}
		return true;
	}

	public static ArrayList<ArrayList<Double>> PointsInsideTheHouse()
			throws FileNotFoundException {
		Locale.setDefault(Locale.US);
		double x = 0;
		double y = 0;
		ArrayList<ArrayList<Double>> allPoints = new ArrayList<ArrayList<Double>>();
		if (readFromFile) {

			Scanner input = new Scanner(
					new FileInputStream("./src/Points.txt"), "UTF-8");
			try {
				while (input.hasNextLine()) {
					ArrayList<Double> newPoint = new ArrayList<Double>();
					x = input.nextDouble();
					y = input.nextDouble();
					newPoint.add(x);
					newPoint.add(y);
					allPoints.add(newPoint);
				}
			} finally {
				input.close();
			}

		} else {
			Locale.setDefault(Locale.US);
			Scanner input = new Scanner(System.in);
			String inputStr = " ";
			try {
				while (true) {
					inputStr = input.nextLine();
					if (inputStr == "" || inputStr.isEmpty()) {
						break;
					}
					String inputNums[] = inputStr.split(" ");
					x = Double.parseDouble(inputNums[0]);
					y = Double.parseDouble(inputNums[1]);
					ArrayList<Double> newPoint = new ArrayList<Double>();
					newPoint.add(x);
					newPoint.add(y);
					allPoints.add(newPoint);
				}
			} catch (Exception e) {

				System.out.println("Wrong input!");

			}

		}
		if (readFromFile) {
			System.out.println("Read from file done.");
		} else {
			System.out.println("Read done.");
		}

		for (ArrayList<Double> thePoint : allPoints) {
			// System.out.println(thePoint.get(0));
			// System.out.println(thePoint.get(1));
			x = thePoint.get(0);
			y = thePoint.get(1);
			// check first rectangle (bigger one)
			boolean rect1 = false;
			if (x <= 17.5 && x >= 12.5 && y <= 13.5 && y >= 8.5) {
				rect1 = true;
			}
			// check second rectangle
			boolean rect2 = false;
			if (x <= 22.5 && x >= 20 && y <= 13.5 && y >= 8.5) {
				rect2 = true;
			}
			boolean triangle = false;
			// check triangle
			double[] pointA = { 12.5, 8.5 };
			double[] pointB = { 17.5, 3.5 };
			double[] pointC = { 22.5, 8.5 };
			// Test Input- 12.5 6 -Wrong!It's Outside -look the picture
			if (onTheRightSide(pointA, pointB, x, y)
					&& onTheRightSide(pointB, pointC, x, y)
					&& onTheRightSide(pointC, pointA, x, y)) {
				triangle = true;
			}
			if (rect1 || rect2 || triangle) {
				// System.out.println("Inside");
				thePoint.add(1.0d);
			} else {
				thePoint.add(0.0d);
				// System.out.println("Outside");
			}
		}
		return allPoints;
	}

	public void drawAllPoints(Graphics2D point, double multiplyer)
			throws IOException {

		Color pointsColor = new Color(191, 191, 191, 180);
		;
		float thickness = (float) (0.02 * multiplyer);
		BasicStroke thinStroke2 = new BasicStroke(thickness);

		ArrayList<ArrayList<Double>> allPointsToDraw = new ArrayList<ArrayList<Double>>();
		allPointsToDraw = PointsInsideTheHouse();
		for (ArrayList<Double> thisPoint : allPointsToDraw) {
			// ellipse is in frame so:
			// x the X coordinate of the upper-left corner of the framing
			// rectangle
			// y the Y coordinate of the upper-left corner of the framing
			// rectangle
			// they have to be correct with the radius
			double diameter = 0.32 * multiplyer;
			Shape circle = new Ellipse2D.Double(thisPoint.get(0) * multiplyer
					- diameter / 2, thisPoint.get(1) * multiplyer - diameter
					/ 2, diameter, diameter);
			if (thisPoint.get(2) == 0.0d) {
				point.setPaint(pointsColor);
				point.fill(circle);
				point.setStroke(thinStroke2);
				point.setColor(Color.black);
				point.draw(circle);
			} else {
				point.setPaint(Color.black);
				point.fill(circle);
				point.setStroke(thinStroke2);
				point.setColor(Color.black);
				point.draw(circle);
			}

		}
	}

	public void drawHouse(Graphics2D newObjects, double multiplyer) {
		Color houseFillColor = new Color(191, 191, 191, 180);
		Color houseBorederColor = new Color(0, 32, 96, 200);
		float thickness = (float) (0.075 * multiplyer);
		BasicStroke borderStroke = new BasicStroke(thickness);

		// draw big rectangle

		Shape bigRect = new RoundRectangle2D.Double(12.5 * multiplyer,
				8.5 * multiplyer, 5.0 * multiplyer, 5.0 * multiplyer, 0, 0);
		newObjects.setPaint(houseFillColor);
		newObjects.fill(bigRect);
		newObjects.setStroke(borderStroke);
		newObjects.setColor(houseBorederColor);
		newObjects.draw(bigRect);

		// small rectangle
		Shape smallRect = new RoundRectangle2D.Double(20 * multiplyer,
				8.5 * multiplyer, 2.5 * multiplyer, 5.0 * multiplyer, 0, 0);
		newObjects.setPaint(houseFillColor);
		newObjects.fill(smallRect);
		newObjects.setStroke(borderStroke);
		newObjects.setColor(houseBorederColor);
		newObjects.draw(smallRect);

		// draw polygon (triangle)
		Point2D a = new Point2D.Double(12.5 * multiplyer, 8.5 * multiplyer);
		Point2D b = new Point2D.Double(17.5 * multiplyer, 3.5 * multiplyer);
		Point2D c = new Point2D.Double(22.5 * multiplyer, 8.5 * multiplyer);
		Polygon2D p = new Polygon2D();
		p.addPoint(a);
		p.addPoint(b);
		p.addPoint(c);

		newObjects.setPaint(houseFillColor);
		newObjects.fill(p);
		newObjects.setStroke(borderStroke);
		newObjects.setColor(houseBorederColor);
		newObjects.draw(p);
	}

	public void drawCoordinateLines(Graphics2D newLine, double multiplyer) {
		Color lineColor = new Color(91, 155, 213, 100);
		float thickness = (float) multiplyer * 0.03f;
		float dash1[] = { (float) multiplyer * 0.105f,
				(float) multiplyer * 0.04f };
		BasicStroke thinStroke4 = new BasicStroke(thickness,
				BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
				0.0f);
		newLine.setStroke(thinStroke4);
		Font myFont = new Font("arial", Font.BOLD, (int) (1 * multiplyer));

		double startX = 10d;
		double endX = 22.5;
		double interval = 2.5d;
		double startY = 3.5d;
		double endY = 17d;
		for (double i = startX; i <= endX; i += interval) {
			Shape currnetLine = new Line2D.Double(i * multiplyer,
					2.5 * multiplyer, i * multiplyer, 17.5 * multiplyer);
			newLine.setStroke(thinStroke4);
			newLine.setColor(lineColor);
			newLine.draw(currnetLine);
			newLine.setColor(Color.black);
			newLine.setFont(myFont);
			String myFormatString = String.format("%.1f", i);
			FontMetrics fm = newLine.getFontMetrics();
			float w = (float) (multiplyer / 5);
			float h = (float) (multiplyer / 10);
			float x = (w - fm.stringWidth(myFormatString)) / 2;
			float y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
			newLine.drawString(myFormatString, x
					+ (float) ((i + 0.3) * multiplyer), y
					+ (float) (multiplyer));
		}
		for (double i = startY; i <= endY; i += interval) {
			Shape currnetLine = new Line2D.Double(9.5 * multiplyer, i
					* multiplyer, 24 * multiplyer, i * multiplyer);
			newLine.setStroke(thinStroke4);
			newLine.setColor(lineColor);
			newLine.draw(currnetLine);
			newLine.setColor(Color.black);
			newLine.setFont(myFont);
			String myFormatString = String.format("%.1f", i);
			FontMetrics fm = newLine.getFontMetrics();
			float w = (float) (multiplyer / 5);
			float h = (float) (multiplyer / 10);
			float x = (w - fm.stringWidth(myFormatString)) / 2;
			float y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
			newLine.drawString(myFormatString, x + (float) (8 * multiplyer), y
					+ (float) ((i) * multiplyer));
		}
	}

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		// all necessary settings. You can change multiplyer, and will scale the
		// svg drawing!!!
		double multiplyer = 50;
		System.out.print("Do you want to read points from file?[Y/N]:");
		Scanner input = new Scanner(System.in);
		String answer = input.next();
		if (answer.toUpperCase().equals("N")) {
			readFromFile = false;
		} else {
			readFromFile = true;
		}
		// Get a DOMImplementation.
		DOMImplementation domImpl = GenericDOMImplementation
				.getDOMImplementation();

		// Create an instance of org.w3c.dom.Document.
		String svgNS = "http://www.w3.org/2000/svg";
		Document document = domImpl.createDocument(svgNS, "svg", null);

		// Create an instance of the SVG Generator.
		SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

		// Ask the test to render into the SVG Graphics2D implementation.
		Problem10_PaintHouseAsSVG test = new Problem10_PaintHouseAsSVG();

		test = new Problem10_PaintHouseAsSVG();
		test.drawHouse(svgGenerator, multiplyer);
		test.drawCoordinateLines(svgGenerator, multiplyer);
		test.drawAllPoints(svgGenerator, multiplyer);

		boolean useCSS = true; // we want to use CSS style attributes

		// Write to HTML or SVG file
		try {
			// First we will create the file, if it does not exist
			String filePath = "mySVG.html";

			// Create an instance of FileOutputStream which will be used to
			// write to file
			OutputStream output = new FileOutputStream(filePath);

			// write the bytes to the sample.txt using write method of
			// OutputStream
			svgGenerator.stream(filePath, useCSS);
			// close the stream
			output.close();
			// System.out.println("Written to file : " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Check the file mySVG.html");
	}
}