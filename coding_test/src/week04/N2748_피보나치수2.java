package week04;

import java.util.Scanner;

public class N2748_피보나치수2 {
	public static int fibo(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fibo(n));
	}
}
