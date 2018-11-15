package PdeX;
import java.util.HashSet;
import java.util.Set;

public class Verificar {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean verify(HashSet<PdeX.Pair> s, Set aux) {
		boolean orden = true;
		// reflexiva
		for (Object o : aux) {
			orden = s.contains(new Pair(o, o)) ? orden : false;
		}
		// transitiva
		for (Pair p : s) {
			Object o = p.x();
			for (Pair q : s) {
				if (!q.equals(p) && q.x().equals(p.y())) {
					orden = s.contains(new Pair(o, q.y())) ? orden : false;
				}
			}
		}
		// antisimetrica
		for (Pair p : s) {
			if (p.x() != p.y()) {
				orden = s.contains(new Pair(p.y(), p.x())) ? false : orden;
			}
		}
		return orden;
	}
}
