import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


public class Ellipse extends ShapeP{

	public Ellipse() {
		shape = new Ellipse2D.Double();
		points = new Point2D[2];
		scale = 0;
		drag = true;
		select = true;
		draw = new DrawFill();
		NShape = 1;
	}
	@Override
	public void makeShape() {
		((Ellipse2D) shape).setFrameFromDiagonal(points[0], points[1]);
		
	}
	public void setFirstPoint(Point2D point) {
		points[0] = point;
		Point2D temp = new Point2D.Double(points[0].getX() + scale, points[0].getY() + scale);
		points[1] =  temp;
		makeShape();
	}
	@Override
	public void setPoints(Point2D point, int i) {
		points[i] = point;
		makeShape();
	}
}
