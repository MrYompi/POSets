package PdeX;

import java.util.HashSet;

public class Continua {
	public static void main(String[] args) {				

		HashSet<String> P = new HashSet<>(); //el conjunto
		for(int i=1;i<=6;i++) {
			P.add(i+"");
		}
		
		HashSet<Pair<String>> r = new HashSet<>(); //el orden 
		for(int i=1;i<=6;i++) {
			for(int j=i;j<=6;j++) {
				r.add(new Pair<String>(i+"",j+""));
			}
		}		

		HashSet<Pair<String>> f = new HashSet<>(); //la funcion
		f.add(new Pair<String>("1","2"));
		f.add(new Pair<String>("2","2"));
		f.add(new Pair<String>("3","2"));
		f.add(new Pair<String>("4","5"));
		f.add(new Pair<String>("5","6"));
		f.add(new Pair<String>("6","6"));
		System.out.println(continua(f, P, r));
	}
	public static HashSet<String> cotasSuperiores(HashSet<String> P, HashSet<String> M, HashSet<Pair<String>> R){
		HashSet<String> cotas=new HashSet<>();
		for(String p:P) {
			boolean esCota=true;
			for(String m:M) {
				if(!R.contains(new Pair<String>(m,p))) {
					esCota=false;
				}
			}
			if(esCota) {
				cotas.add(p);
			}
		}
		return cotas;
	}
	public static String supremo (HashSet<String> P, HashSet<String> M, HashSet<Pair<String>> R) {
		HashSet<String> cotas=cotasSuperiores(P,M,R);
		for (String c:cotas) {
			boolean supremo=true;
			for(String d:cotas) {
				if(!d.equals(c)&&R.contains(new Pair<String>(d,c))) {
					supremo=false;
				}
			}
			if(supremo) {
				return c;
			}
		}
		return null;
	}
	public static boolean esDirigido(HashSet<String> P, HashSet<String> M, HashSet<Pair<String>> R) {
		boolean dirigido=false;
		for(String a:M) {
			for(String b:M) {
				HashSet<String> ab=new HashSet<>();
				ab.add(a);
				ab.add(b);
				HashSet<String> cotas=cotasSuperiores(P,ab,R);
				for(String c:cotas) {
					if(M.contains(c)) {
						dirigido=true;
					}
				}
			}
		}
		return dirigido;
	}
	public static boolean continua(HashSet<Pair<String>> f, HashSet<String> P, HashSet<Pair<String>> R) {
		boolean cont = true;
		if(!monotona(f, R)) {
			return false;
		}
		HashSet<HashSet<String>> partes = PartesX.partes(P);
		for(HashSet<String> m : partes) {
			if(esDirigido(P,m,R)) {
				HashSet<String> fDeM = apply(f,m);
				String sup=supremo(P,m,R);
				String fdeV=apply(f,sup);
				String supremoDeF =supremo(P,fDeM, R);
				if(!fdeV.equals(supremoDeF)) {
					cont=false;
				}
			}
		}
		return cont;
	}

	public static boolean monotona(HashSet<Pair<String>> f, HashSet<Pair<String>> r) {
		boolean m = true;
		for (Pair<String> p : f) {
			for (Pair<String> q : f) {
				if (r.contains(new Pair<String>(p.x(), q.x())) && 
						!r.contains(new Pair<String>(p.y(), q.y()))) {
					m = false;
				}
			}
		}
		return m;
	}
	public static HashSet<String> apply (HashSet<Pair<String>> f, HashSet<String> M){
		HashSet<String> fDeM= new HashSet<>();
		for(Pair<String> p : f) {
			if(M.contains(p.x())) {
				fDeM.add(p.y());
			}
		}
		return fDeM;
	}
	public static String apply (HashSet<Pair<String>> f, String M){
		String fDeM="";
		for(Pair<String> p : f) {
			if(M.equals(p.x())) {
				fDeM=p.y();
			}
		}
		return fDeM;
	}
}
