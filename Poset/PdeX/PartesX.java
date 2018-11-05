package PdeX;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import Cadenas.Pair;
public class PartesX {
	public static HashSet <Pair> r = new HashSet<Pair>();
	
	public static void main(String[] args) {
		Hasse uno= initH();
		initR(uno);
		System.out.println(r);
	}
	public static Hasse initH() {
		Hasse dos = new Hasse("dos", null);
		Hasse a = new Hasse("a", new ArrayList<Hasse>());
		Hasse b = new Hasse("b", new ArrayList<Hasse>());
		Hasse uno = new Hasse("uno", new ArrayList<Hasse>());
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
		while(!s.isEmpty()) {
			r.add(new Pair(o.nombre, p.nombre));
			p=s.pop();
			s.addAll(p.sucesores);
		}
	}
}
