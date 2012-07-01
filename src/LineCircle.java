import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


public class LineCircle extends ShapeP{

	public LineCircle() {
		shape = new Ellipse2D.Double();
		points = new Point2D[2];
		scale = 0;
		drag = false;
		select = false;
		draw = new DrawFill();
		NShape = 4;
	}
	@Override
	public void makeShape() {
		
		((Ellipse2D) shape).setFrameFromDiagonal(points[0], points[1]);
		
	}

	public boolean isSelect() {
		return false;
	}
	public void setFirstPoint(Point2D point) {
		points[0] = point;
		Point2D temp = new Point2D.Double(points[0].getX() + scale, points[0].getY() + scale);
		points[1] =  temp;
		makeShape();
	}

}
