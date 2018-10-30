package Cadenas;

public class Formula {
	public static void main(String[] args) {
		int n=4;
		int total=1+contar(4,4);
		/*for(int i=1;i<n;i++) {
			total++;
			for(int j=1;j<=i;j++) {
				total++;
				for(int k=1;k<=j;k++) {
					total+=(1+k);
				}
			}
		}*/
		System.out.println(total);
	}
	
	public static int contar(int i, int r) {
		int result=0;
		if(r==1) {
			for(int j=1;j<=i;j++) {
				result+=(1+j);
			}
		}else {
			for(int j=1;j<=i;j++) {
				result+=(1+contar(j,r-1));
			}
		}
		return result;
	}
}
