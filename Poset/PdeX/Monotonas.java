package PdeX;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Monotonas {
	public static HashSet<Pair<Hasse>> r = new HashSet<Pair<Hasse>>();
	public static HashSet<HashSet<Pair<Hasse>>> visited = new HashSet<>();
	public static ArrayList<Hasse> hs = new ArrayList<>();

	public static void main(String[] args) {
		Hasse uno = initH();
		initR(uno);
		HashSet<Pair<Hasse>> base = new HashSet<Pair<Hasse>>();
		for (Hasse h : hs) {
			base.add(new Pair<Hasse>(h, uno));
		}

		HashSet<HashSet<Pair<Hasse>>> res = new HashSet<>();
		res.add(base);
		for (int i = hs.size() - 1; i >= 0; i--) {
			res.addAll(obt(base, hs.get(i)));
		}

		for (HashSet<Pair<Hasse>> g : res) {
			System.out.println(g);
		}
		System.out.println("Total: " + res.size());
	}

	public static HashSet<HashSet<Pair<Hasse>>> obt(HashSet<Pair<Hasse>> f, Hasse o) {
		HashSet<HashSet<Pair<Hasse>>> res = new HashSet<HashSet<Pair<Hasse>>>();
		for (Pair<Hasse> p : f) {
			if (p.x().equals(o)) {
				for (Hasse q : p.y().sucesores) {
					HashSet<Pair<Hasse>> f2 = new HashSet<>(f);
					f2.remove(p);
					f2.add(new Pair<Hasse>(p.x(), q));
					if (monotona(f2) && !visited.contains(f2)) {
						visited.add(f2);
						res.add(f2);
						
						for (int i = hs.size() - 1; i >= 0; i--) {
							res.addAll(obt(f2, hs.get(i)));
						}
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
		
		//Hasse dos = new Hasse("2", new ArrayList<Hasse>());
		/*Hasse d = new Hasse("d", new ArrayList<Hasse>());
		Hasse e = new Hasse("e", new ArrayList<Hasse>());
		Hasse f = new Hasse("f", new ArrayList<Hasse>());*/	
		Hasse a = new Hasse("1", new ArrayList<Hasse>());
		Hasse b = new Hasse("2", new ArrayList<Hasse>());
		Hasse c = new Hasse("3", new ArrayList<Hasse>());		
		Hasse uno = new Hasse("b", new ArrayList<Hasse>());
		uno.sucesores.add(a);
		uno.sucesores.add(b);
		uno.sucesores.add(c);
		/*a.sucesores.add(d);
		a.sucesores.add(e);
		b.sucesores.add(d);		
		b.sucesores.add(f);		
		c.sucesores.add(e);		
		c.sucesores.add(f);				
		d.sucesores.add(dos);		
		e.sucesores.add(dos);		
		f.sucesores.add(dos);
		a.sucesores.add(dos);		
		b.sucesores.add(dos);		
		c.sucesores.add(dos);*/
		return uno;
	}

	public static void initR(Hasse o) {
		Hasse p = o;
		LinkedList<Hasse> s = new LinkedList<>();
		s.addAll(p.sucesores);
		r.add(new Pair<Hasse>(o, p));
		hs.remove(p);
		hs.add(p);
		while (!s.isEmpty()) {
			p = s.pop();
			r.add(new Pair<Hasse>(o, p));
			initR(p);
			s.addAll(p.sucesores);
			hs.remove(p);
			hs.add(p);
		}
	}
}
