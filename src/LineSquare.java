import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;


public class LineSquare extends ShapeP{

	public LineSquare() {
		shape = new Rectangle2D.Double();
		points = new Point2D[2];
		scale = 0;
		drag = false;
		select = false;
		draw = new DrawFill();
		NShape = 5;
	}
	@Override
	public void makeShape() {
		
		((RectangularShape) shape).setFrameFromDiagonal(points[0], points[1]);
		
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
