package PdeX;

import java.util.HashSet;

public class Continua {
	public static void main(String[] args) {				

		HashSet<String> P = new HashSet<>(); //el conjunto
		/*for(int i=1;i<=6;i++) {
			P.add(i+"");
		}*/
		P.add("1");
		P.add("a");
		P.add("b");
		P.add("c");
		P.add("d");
		HashSet<Pair<String>> r = new HashSet<>(); //el orden 
		/*for(int i=1;i<=6;i++) {
			for(int j=i;j<=6;j++) {
				r.add(new Pair<String>(i+"",j+""));
			}
		}*/		
		r.add(new Pair<String>("1","1"));
		r.add(new Pair<String>("1","a"));
		r.add(new Pair<String>("1","b"));
		r.add(new Pair<String>("1","c"));
		r.add(new Pair<String>("1","d"));
		r.add(new Pair<String>("a","a"));
		r.add(new Pair<String>("a","b"));
		r.add(new Pair<String>("a","c"));
		r.add(new Pair<String>("a","d"));
		r.add(new Pair<String>("b","b"));		
		r.add(new Pair<String>("b","d"));
		r.add(new Pair<String>("c","c"));
		r.add(new Pair<String>("c","d"));
		r.add(new Pair<String>("d","d"));
		
		HashSet<Pair<String>> f = new HashSet<>(); //la funcion
		f.add(new Pair<String>("1","a"));
		f.add(new Pair<String>("a","a"));
		f.add(new Pair<String>("b","b"));
		f.add(new Pair<String>("c","b"));
		f.add(new Pair<String>("d","d"));
		/*f.add(new Pair<String>("1","2"));
		f.add(new Pair<String>("2","2"));
		f.add(new Pair<String>("3","2"));
		f.add(new Pair<String>("4","5"));
		f.add(new Pair<String>("5","6"));
		f.add(new Pair<String>("6","6"));*/
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
		boolean dirigido=true;
		for(String a:M) {
			for(String b:M) {
				HashSet<String> ab=new HashSet<>();
				ab.add(a);
				ab.add(b);
				HashSet<String> cotas=cotasSuperiores(P,ab,R);
				boolean pertenece=false;
				for(String c:cotas) {
					if(M.contains(c)) {
						pertenece=true;
					}
				}
				if(!pertenece) {
					dirigido=false;
				}
			}
		}
		return dirigido;
	}
	public static boolean continua(HashSet<Pair<String>> f, HashSet<String> P, HashSet<Pair<String>> R) {
		boolean cont = true;
		if(!monotona(f, R)) {
			System.out.println("No es monótona");
			return false;
		}
		HashSet<HashSet<String>> partes = PartesX.partes(P);
		partes.remove(new HashSet<String>());
		for(HashSet<String> m : partes) {
			if(esDirigido(P,m,R)) {
				HashSet<String> fDeM = apply(f,m);
				String sup=supremo(P,m,R);
				String fdeV=apply(f,sup);
				String supremoDeF =supremo(P,fDeM, R);
				if(!fdeV.equals(supremoDeF)) {
					System.out.println("Supremo de "+m+": "+sup+";\n"+"f del supremo de m: "+fdeV+";\n"+
							"f de m: "+fDeM+";\nSupremo de f de m:"+supremoDeF);
					System.out.println("----------------");
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
