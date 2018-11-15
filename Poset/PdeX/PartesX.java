package PdeX;

import java.util.ArrayList;
import java.util.HashSet;

public class PartesX {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static HashSet partes(HashSet entrada) {
		ArrayList x = new ArrayList(entrada);
		HashSet<HashSet> PdeX = new HashSet<>();	
		Binario bin = new Binario(x.size());
		for(int i=0;i<Math.pow(2, x.size());i++) {
			HashSet aux = new HashSet<>();
			for(int j=0; j<bin.num.length;j++) {
				if(bin.num[j]) {
					aux.add(x.get(j));
				}				
			}
			bin.add();
			PdeX.add(aux);
		}
		return PdeX;
	}
}
