package PdeX;

import java.util.ArrayList;
import java.util.HashSet;

public class PartesX {
	public static void main(String[] args) {
		ArrayList<String> x = new ArrayList<>();
		HashSet<HashSet<String>> PdeX = new HashSet<>();
		for(int i=1;i<=3;i++) {
			x.add(new Integer(i).toString());
		}		
		Binario bin = new Binario(x.size());
		for(int i=0;i<Math.pow(2, x.size());i++) {
			HashSet<String> aux = new HashSet<>();
			for(int j=0; j<bin.num.length;j++) {
				if(bin.num[j]) {
					aux.add(x.get(j));
				}
				bin.add();
			}
			PdeX.add(aux);
		}
		System.out.println(PdeX);
	}
}
