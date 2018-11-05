package PdeX;

public class Pair {
	private String x, y;

	public Pair(String a, String b) {
		x = a;
		y = b;
	}

	public String x() {
		return x;
	}

	public String y() {
		return y;
	}

	public void setX(String a) {
		x = a;
	}

	public void setY(String a) {
		y = a;
	}

	public int hashCode() {
		return 7*x.hashCode()+13*y.hashCode();
	}
	
	public boolean equals(Object o) {
		if (o instanceof Pair) {
			Pair q=(Pair) o;
			return this.x.equals(q.x()) && this.y.equals(q.y());
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
}
