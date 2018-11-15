package PdeX;

import java.util.HashSet;

public class OrdParciales {
	public static void main(String[] args) {
		HashSet<Integer> p = new HashSet<>();
		for(int i = 1; i<=3; i++) {
			p.add(i);
		}
		HashSet<Pair<Integer>> PxP = new HashSet<>();
		for (Integer i : p) {
			for(Integer j: p) {
				PxP.add(new Pair<Integer>(i, j));
			}
		}
		int count=0;
		HashSet<HashSet<Pair>> partesPxP = (HashSet<HashSet<Pair>>) PartesX.partes(PxP);
		for (HashSet<Pair> s : partesPxP) {
			if(Verificar.verify(s, p)) {
				System.out.println(s);
				count ++;
			}
		}
		System.out.println(count);
	}
	
}
