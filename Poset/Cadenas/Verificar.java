package Cadenas;
import java.util.HashSet;
import java.util.Set;

public class Verificar {
	private static Set<Pair> s;

	public static void main(String[] args) {
		s = new HashSet<Pair>();
		s.add(new Pair(1, 1));
		s.add(new Pair(2, 2));
		s.add(new Pair(3, 3));
		s.add(new Pair(1, 2));
		s.add(new Pair(2, 3));
		s.add(new Pair(1, 3));
		System.out.println(verify());
	}

	private static boolean verify() {
		boolean orden = true;
		// aux es el conjunto sobre el que se aplica la relacion
		Set<Integer> aux = new HashSet<Integer>();
		for (Pair p : s) {
			aux.add(p.x());
			aux.add(p.y());
		}
		// reflexiva
		for (int o : aux) {
			orden = s.contains(new Pair(o, o)) ? orden : false;
		}
		// transitiva
		for (Pair p : s) {
			int o = p.x();
			for (Pair q : s) {
				if (!q.equals(p) && q.x() == p.y()) {
					orden = s.contains(new Pair(o, q.y())) ? orden : false;
				}
			}
		}
		// antisimetrica
		for (Pair p : s) {
			if (p.x() != p.y()) {
				orden = s.contains(new Pair(p.y(), p.x())) ? false : orden;
			}
		}
		return orden;
	}
}
