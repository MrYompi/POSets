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
			return nombre.equals(nombre);
		}
		return false;
	}
	@Override
	public int hashCode() {
		return nombre.hashCode();
	}
}
