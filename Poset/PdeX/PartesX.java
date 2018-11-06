package PdeX;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class PartesX {
	public static HashSet<Pair<Hasse>> r = new HashSet<Pair<Hasse>>();
	public static HashSet<HashSet<Pair<Hasse>>> visited = new HashSet<>();
	public static Hasse origen;
	public static void main(String[] args) {
		Hasse uno = initH();
		initR(uno);
		origen=uno;
		HashSet<HashSet<Pair<Hasse>>> res = new HashSet<HashSet<Pair<Hasse>>>();

		HashSet<Pair<Hasse>> base = new HashSet<Pair<Hasse>>();
		Stack<Hasse> s = new Stack<Hasse>();
		s.addAll(uno.sucesores);
		Hasse p = uno;
		while (!s.isEmpty()) {
			base.add(new Pair<Hasse>(p, uno));
			p = s.pop();
			s.addAll(p.sucesores);
		}
		res.add(base);
		res.addAll(obt(base, uno));
		for (HashSet<Pair<Hasse>> g : res) {
			System.out.println(g);
		}
		System.out.println("Total: " + res.size());
	}

	public static HashSet<HashSet<Pair<Hasse>>> obt(HashSet<Pair<Hasse>> f, Hasse o) {
		HashSet<HashSet<Pair<Hasse>>> res = new HashSet<HashSet<Pair<Hasse>>>();
		boolean found = false;
		if (monotona(f)&&!visited.contains(f)) {
			visited.add(f);
			res.add(f);
			for (Pair<Hasse> p : f) {
				if (p.x().equals(o)) {
					found = true;
				}
				if (found) {
					for (Hasse q : p.y().sucesores) {
						HashSet<Pair<Hasse>> f2 = new HashSet<Pair<Hasse>>(f);
						f2.remove(p);
						f2.add(new Pair<Hasse>(o, q));
						res.addAll(obt(f2, o));
					}
					HashSet<Pair<Hasse>> base = new HashSet<Pair<Hasse>>();

					Hasse q = origen;
					Stack<Hasse> s = new Stack<Hasse>();
					s.addAll(origen.sucesores);
					while (!s.isEmpty()) {
						res.addAll(obt(f, q));
						q = s.pop();
						s.addAll(q.sucesores);
					}
				}
			}
		}
		return res;

	}

	public static boolean monotona(HashSet<Pair<Hasse>> f) {
		boolean m = true;
		for (Pair<Hasse> p : f) {
			for (Pair<Hasse> q : f) {
				if (r.contains(new Pair<Hasse>(p.x(), q.x())) && 
						!r.contains(new Pair<Hasse>(p.y(), q.y()))) {
					m = false;
				}
			}
		}
		return m;
	}

	public static Hasse initH() {
		Hasse dos = new Hasse("2", new ArrayList<Hasse>());
		Hasse a = new Hasse("a", new ArrayList<Hasse>());
		Hasse b = new Hasse("b", new ArrayList<Hasse>());
		Hasse uno = new Hasse("1", new ArrayList<Hasse>());
		a.sucesores.add(dos);
		b.sucesores.add(dos);
		uno.sucesores.add(a);
		uno.sucesores.add(b);
		return uno;
	}

	public static void initR(Hasse o) {
		Hasse p = o;
		Stack<Hasse> s = new Stack<Hasse>();
		s.addAll(p.sucesores);
		r.add(new Pair<Hasse>(o, p));
		while (!s.isEmpty()) {
			p = s.pop();
			r.add(new Pair<Hasse>(o, p));
			initR(p);
			s.addAll(p.sucesores);
		}
	}
}
