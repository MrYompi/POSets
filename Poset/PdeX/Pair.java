package PdeX;

public class Pair<E> {
	private E x, y;

	public Pair(E a, E b) {
		x = a;
		y = b;
	}

	public E x() {
		return x;
	}

	public E y() {
		return y;
	}

	public void setX(E a) {
		x = a;
	}

	public void setY(E a) {
		y = a;
	}

	public int hashCode() {
		return 7*x.hashCode()+13*y.hashCode();
	}
	
	public boolean equals(Object o) {
		if (o instanceof Pair) {
			Pair<E> q=(Pair<E>) o;
			return this.x.equals(q.x()) && this.y.equals(q.y());
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
}
