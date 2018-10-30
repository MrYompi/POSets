package Cadenas;

public class Pair {
	private int x, y;

	public Pair(int a, int b) {
		x = a;
		y = b;
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public void setX(int a) {
		x = a;
	}

	public void setY(int a) {
		y = a;
	}

	public int hashCode() {
		return 7*x+13*y;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Pair) {
			Pair q=(Pair) o;
			return this.x==q.x() && this.y==q.y();
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
}
