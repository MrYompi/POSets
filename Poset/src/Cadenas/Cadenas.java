package Cadenas;
import java.util.HashSet;

public class Cadenas {
	public static void main(String[] args) {
		HashSet<HashSet<Pair>> s=cadena(3);
		System.out.println("Total: "+s.size()+" funciones.");
		for(HashSet<Pair> h : s) {
			System.out.println(h);
		}
	}

	public static HashSet<HashSet<Pair>> cadena(int n) {
		HashSet<HashSet<Pair>> f = new HashSet<HashSet<Pair>>();
		HashSet<Pair> aux;
		if (n == 1) {
			aux = new HashSet<Pair>();
			aux.add(new Pair(1, 1));
			f.add(aux);
		} else {
			HashSet<HashSet<Pair>> rec = cadena(n - 1);
			HashSet<HashSet<Pair>> recursion = new HashSet<HashSet<Pair>> ();
			recursion.addAll(rec);
			for (HashSet<Pair> set : rec) {
				recursion.add(masUno(set));
			}
			for (HashSet<Pair> set : recursion) {
				int libre = -1;
				for (int i = 1; i <= n; i++) {
					boolean l = true;
					for (int j = 1; j <= n; j++) {
						if (set.contains(new Pair(i, j))) {
							l = false;
						}
					}
					if (l) {
						libre = i;
					}
				}
				for (int i = 1; i <= n; i++) {
					HashSet<Pair> funcion = new HashSet<Pair>();
					funcion.addAll(set);
					funcion.add(new Pair(libre, i));
					if (monotona(funcion, n)) {
						f.add(funcion);
					}
				}
			}
		}
		return f;
	}

	private static HashSet<Pair> masUno(HashSet<Pair> s) {
		HashSet<Pair> r = new HashSet<Pair>();
		for (Pair p : s) {
			r.add(new Pair(p.x() + 1, p.y() + 1));
		}
		return r;
	}

	private static boolean monotona(HashSet<Pair> s, int n) {
		boolean mono=true;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <=n; j++) {
				if(im(s, i)>im(s,j)) {
					mono=false;
				}
			}			
		}
		return mono;
	}

	private static int im(HashSet<Pair> s, int n) {
		int t = 0;
		for (Pair p : s) {
			if (p.x() == n) {
				t = p.y();
			}
		}
		return t;
	}
}
