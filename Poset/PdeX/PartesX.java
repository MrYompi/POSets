package PdeX;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class PartesX {
	public static HashSet <Pair> r = new HashSet<Pair>();
	
	public static void main(String[] args) {
		Hasse uno= initH();
		initR(uno);
		HashSet<HashSet<Pair>> res = new HashSet<HashSet<Pair>>();
		
		HashSet<Pair> base = new HashSet<Pair>();
		Stack<Hasse> s =new Stack<Hasse>();
		s.addAll(uno.sucesores);
		Hasse p = uno;
		while(!s.isEmpty()) {
			base.add(new Pair(p.nombre, uno.nombre));
			p = s.pop();
			s.addAll(p.sucesores);
		}		
		res.add(base);
		res.addAll(obt(base, uno));
		for(HashSet<Pair> g : res) {
			System.out.println(g);
		}
		System.out.println("Total: "+res.size());
	}
	
	public static HashSet<HashSet<Pair>> obt(HashSet<Pair>f, Hasse o){
		HashSet<HashSet<Pair>> res = new HashSet<HashSet<Pair>>();
		
		return res;
	}
	
	public static boolean monotona(HashSet<Pair> f) {
		boolean m=true;
		for(Pair p : f) {
			for(Pair q : f) {
				if(r.contains(new Pair(p.x(), q.x()))&&
						!r.contains(new Pair(p.y(), q.y()))){
					m=false;
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
		Hasse p=o;
		Stack<Hasse> s = new Stack<Hasse>();
		s.addAll(p.sucesores);
		r.add(new Pair(o.nombre, p.nombre));
		while(!s.isEmpty()) {
			p=s.pop();
			r.add(new Pair(o.nombre, p.nombre));
			initR(p);
			s.addAll(p.sucesores);
		}
	}
}
