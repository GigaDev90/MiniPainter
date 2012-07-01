import java.util.ArrayList;


public class ConcreteCreator implements Creator {
	private ArrayList<ShapeP> listUnUsedShape;
	
	public ConcreteCreator() {
		listUnUsedShape = new ArrayList<ShapeP>();
	}
	//implementazione OjectPool
	private ShapeP checkAlreadyCreate(int i) {
		for(int j = 0; j < listUnUsedShape.size(); j ++) {
			if(((ShapeP) listUnUsedShape.get(j)).getNShape() == i) {
				return (ShapeP) listUnUsedShape.remove(j);
				
			}
		}
		return null;
	}
	@Override
	public ShapeP getShape(int i) {
		
		ShapeP shape = checkAlreadyCreate(i);
		if(shape == null)
			switch (i) {
				case 1 : {
					shape = new Ellipse();
				} break;
				case 2 : {
					shape = new Rectangle();
				} break;
				case 3 : {
					shape = new Line();
				} break;
				case 4 : {
					shape = new LineCircle();
				} break;
				case 5 : {
					shape = new LineSquare();
				} break;
				case 6 : {
					shape = new LineStar();
				} break;
				case 7 : {
					shape = new Pen();
				} break;
				case 8 : {
					shape = new Curve();
				} break;
				case 9 : {
					shape = new Eraser();
				} break;
				default : {
					shape = new LineCircle();
				}
			}
		return shape;
	}
	

	@Override
	public void releaseShape(ShapeP p) {
		listUnUsedShape.add(p);
	}

}
