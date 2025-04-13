package BT5_1;

public class LineSub extends Point {
private Point begin;
private Point end;
	public LineSub(int beginX, int beginY,int endX,int endY) {
		super(beginX, beginY);
		this.end=new Point(endX,endY);
	}
 
	public LineSub(Point begin,Point end) {
		super(begin.getX(),begin.getY());
		this.end=end;
		
	}
	
	public String toString() {
		return "Line [begin=" + begin + ", end=" + end + "]";
	}

	public Point getBegin() {
		return begin;

	}

	public Point getEnd() {
		return end;
	}

	public void setBegin(Point begin) {
		this.begin = begin;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public int getBeginX() {
		return begin.getX();
	}

	public int getBeginY() {
		return begin.getY();
	}

	public int getEndX() {
		return end.getX();
	}

	public int getEndY() {
		return end.getY();
	}

	public void setBeginX(int X) {
		begin.setX(X);
	}

	public void setBeginY(int Y) {
		begin.setY(Y);
	}

	public void setBeginXY(int X,int Y) {
		begin.setX(X);
		begin.setY(Y);
	}
	public void setEndX(int X) {
		end.setX(X);
	}

	public void setEndY(int Y) {
		end.setY(Y);
	}

	public void setEndXY(int X,int Y) {
		end.setX(X);
		end.setY(Y);
	}

	public int getLength() {
		return (int)Math.sqrt(Math.pow(getBeginX()-getEndY(),2)+Math.pow(getBeginX()-getEndY(),2));
	}

	public double getGradient() {
		return Math.atan2(getEndY()-getBeginY(),getEndX()-getBeginX());
	}
}
