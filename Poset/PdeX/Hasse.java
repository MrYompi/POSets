package PdeX;

import java.util.ArrayList;

public class Hasse {
	public String nombre;
	public ArrayList<Hasse> sucesores;
	public Hasse(String n, ArrayList<Hasse> h) {
		nombre=n;
		sucesores=h;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Hasse) {
			Hasse o = (Hasse) obj;
			return nombre.equals(o.nombre);
		}
		return false;
	}
	@Override
	public int hashCode() {
		return nombre.hashCode();
	}
	public String toString() {
		return nombre;
	}
}
