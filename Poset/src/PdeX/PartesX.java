package PdeX;

import java.util.ArrayList;

public class PartesX {
	
	public static void main(String[] args) {
		Hasse dos = new Hasse("dos", null);
		Hasse a = new Hasse("a", new ArrayList<Hasse>());
		Hasse b = new Hasse("b", new ArrayList<Hasse>());
		Hasse uno = new Hasse("uno", new ArrayList<Hasse>());
		a.sucesores.add(dos);
		b.sucesores.add(dos);
		uno.sucesores.add(a);
		uno.sucesores.add(b);
	}
}
