package PdeX;

public class Binario {
	public boolean[] num;
	public Binario(int size) {
		num = new boolean[size];
	}
	public void add() {
		boolean carry = true;
		int i=0;
		while(carry&&i<num.length) {
			if(carry) {
				carry=num[i];
				num[i]=!num[i];
			}
			i++;
		}		
	}
}
