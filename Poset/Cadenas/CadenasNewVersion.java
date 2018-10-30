package Cadenas;
import java.util.HashSet;

public class CadenasNewVersion {
	public static int n = 6;
	public static int count=0;
	public static HashSet<HashSet<Pair>> visitados;

	public static void main(String[] args) {
		visitados = new HashSet<HashSet<Pair>>();
		HashSet<HashSet<Pair>> res = new HashSet<HashSet<Pair>>();
		HashSet<Pair> base = new HashSet<Pair>();
		for (int i = 1; i <= n; i++) {
			base.add(new Pair(i, 1));
		}
		res.add(base);
		for (int i = n; i >= 1; i--) {
			res.addAll(cad(base, i));
		}
		
		for(HashSet<Pair> g : res) {
			System.out.println(g);
		}
		System.out.println("Total: "+res.size());
		System.out.println(count);
	}

	public static HashSet<HashSet<Pair>> cad(HashSet<Pair> f, int m) {
		HashSet<HashSet<Pair>> res = new HashSet<HashSet<Pair>>();
		HashSet<Pair> func = new HashSet<Pair>();
		for(Pair p : f) {
			func.add(new Pair(p.x(),p.y()));
		}
		int aux = 0;
		for (Pair p : f) {
			if (p.x() == m) {
				aux=p.y()+1;
				func.remove(p);
				func.add(new Pair(p.x(), aux));
			}
		}
		if (aux <= n && monotona(func)&&!visitados.contains(func)) {			
			visitados.add(func);
			res.add(func);
			
			for (int i = n; i >= 1; i--) {
				for ( HashSet<Pair> g : cad(func, i)) {
					res.add(g);
				}
			}
		}

		return res;
	}

	private static boolean monotona(HashSet<Pair> s) {
		count ++;
		boolean mono = true;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (im(s, i) > im(s, j)) {
					mono = false;
				}
			}
		}
		return mono;
	}

	private static int im(HashSet<Pair> s, int m) {
		int t = 0;
		for (Pair p : s) {
			if (p.x() == m) {
				t = p.y();
			}
		}
		return t;
	}
}
