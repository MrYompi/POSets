package PdeX;

import java.util.HashSet;

public class Diagrama {

	public static void main(String[] args) {
		System.out.println("Tipo 1, ninguno relacionado:");
		HashSet<HashSet<Pair<String>>> t1 = new HashSet<>();
		HashSet<Pair<String>> r = new HashSet<>();
		for (int i = 1; i <= 3; i++) {
			r.add(new Pair<String>(i + "", i + ""));
		}
		t1.add(r);
		System.out.println(t1.size() + " orden:\n " + r);
		///
		System.out.println("Tipo 2, dos relacionados:");
		HashSet<HashSet<Pair<String>>> t2 = new HashSet<>();

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i != j) {
					HashSet<Pair<String>> r2 = new HashSet<>(r);
					r2.add(new Pair<String>(i + "", j + ""));
					t2.add(r2);
				}
			}
		}
		System.out.println(t2.size() + " ordenes:");
		for (HashSet<Pair<String>> h : t2) {
			System.out.println(h);
		}
		///
		System.out.println("Tipo 3, dos abajo, uno arriba:");
		HashSet<HashSet<Pair<String>>> t3 = new HashSet<>();

		for (int i = 1; i <= 3; i++) {
			HashSet<Pair<String>> r2 = new HashSet<>(r);
			for (int j = 1; j <= 3; j++) {
				if (i != j) {
					r2.add(new Pair<String>(j + "", i + ""));
				}
			}
			t3.add(r2);
		}
		System.out.println(t3.size() + " ordenes:");
		for (HashSet<Pair<String>> h : t3) {
			System.out.println(h);
		}
		///
		System.out.println("Tipo 4, dos arriba, uno abajo:");
		HashSet<HashSet<Pair<String>>> t4 = new HashSet<>();

		for (int i = 1; i <= 3; i++) {
			HashSet<Pair<String>> r2 = new HashSet<>(r);
			for (int j = 1; j <= 3; j++) {
				if (i != j) {
					r2.add(new Pair<String>(i + "", j + ""));
				}
			}
			t4.add(r2);
		}
		System.out.println(t4.size() + " ordenes:");
		for (HashSet<Pair<String>> h : t4) {
			System.out.println(h);
		}
		///
		System.out.println("Tipo 5, cadena:");
		HashSet<HashSet<Pair<String>>> t5 = new HashSet<>();

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i != j) {
					for (int k = 1; k <= 3; k++) {
						if (k != i && k != j) {
							HashSet<Pair<String>> r2 = new HashSet<>(r);
							r2.add(new Pair<String>(i + "", j + ""));
							t5.add(r2);
						}
					}
				}
			}
		}
		System.out.println(t5.size() + " ordenes:");
		for (HashSet<Pair<String>> h : t5) {
			System.out.println(h);
		}
		
		System.out.println("Total: "+(t1.size()+t2.size()+t3.size()+t4.size()+t5.size()));
	}

}
