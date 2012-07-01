import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;


public abstract class ShapeP {
	//istanza per disegnare con il giusto stile
	protected Draw draw;
	//punti usato per settare dove la figura andrà posizionata
	protected Point2D[] points;
	//colore della figura
	protected Color c;
	//Oggetto Shape è quello che andrà realmente ad essere disegnato
	protected Shape shape;
	//dimensione
	protected double scale;
	//booleano per verificare se si tratta di una classe che può essere spostata
	protected boolean drag;
	//booleano per verificare se si tratta di una classe che puà essere selezionata
	protected boolean select;
	//intero che indentifica il tipo di figura
	protected int NShape;
	
	public ShapeP() {
		select = false;
		scale = 5;
	}
	public boolean isDraglable() {
		return drag;
	}
	public Shape getShape() {
		makeShape();
		return shape;
	}
	public Point2D[] getPoints() {
		return points;
	}
	public boolean isSelect() {
		return select;
	}
	public void setPoints(Point2D point,int i) {
		points[i] = point;
		makeShape();
	}
	public void setFirstPoint(Point2D point) {
		points[0] = point;
	}
	public void select(boolean b) {
		select = b;
	}
	public void setStile(int stile) {
		switch (stile) {
			case 0 : {
				draw = new DrawFill();
			} break;
			case 1 : {
				draw = new DrawBorder();
			} break;
			case 2 : {
				draw = new DrawWhiteBorder();
			}
		}
	}
	public void setColor(Color colorC) {
		c = colorC;
	}
	public Color getColor() {
		return c;
	}
	public void setScale(int i) {
		scale = i;
	}
	public int getNShape() {
		return NShape;
	}
	public abstract void makeShape();
	public void draw(Graphics2D g2) {
		draw.draw(shape ,g2, c);
	}
	
}
