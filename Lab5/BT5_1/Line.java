package BT5_1;

public class Line {
private Point begin;
private Point end;
public Line(Point begin, Point end) {
	this.begin = begin;
	this.end = end;
}

public Line(int beginX,int beginY,int endX,int endY) {
	begin=new Point(beginX,beginY);
	end=new Point(endX,endY);
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
	return (int)Math.sqrt(Math.pow(getBeginX()-getEndX(),2)+Math.pow(getBeginY()-getEndY(),2));
}

public double getGradient() {
	return Math.atan2(getEndY()-getBeginY(),getEndX()-getBeginX());
}

}
