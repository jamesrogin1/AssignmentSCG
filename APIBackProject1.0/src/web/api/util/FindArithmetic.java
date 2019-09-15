package web.api.util;

public class FindArithmetic {
	
	public static void main(String[] args) {
		
		int[] number = new int[] {0,5,9,15,23,0,0};
		
		for(int i=0; i<number.length; i++) {
			if(i == 0 && i < 1) {
				number[i] = i + 1 + 2 * (i + 1);
			} else if(i > 4) {
				number[i] = 2 * ((i + 1) - 1);
				number[i] = number[i-1] + number[i];
			} 
			
			if(i > 0) {
				System.out.print(" , ");
			}
			System.out.print(number[i]);
		}
		
		System.out.println();
		System.out.println("X = "+number[0]);
		System.out.println("5 = "+number[1]);
		System.out.println("9 = "+number[2]);
		System.out.println("15 = "+number[3]);
		System.out.println("23 = "+number[4]);
		System.out.println("Y = "+number[5]);
		System.out.println("Z = "+number[6]);
	}
	
}
