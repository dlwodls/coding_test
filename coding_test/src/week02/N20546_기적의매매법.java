package week02;

import java.util.Scanner;

public class N20546_기적의매매법 {
	// [TIMING] 상승
	public static int up(int[] stock, int n) {
		if (n < 3) return -1;
		if (stock[n - 2] > stock[n - 3] &&
			stock[n - 1] > stock[n - 2] &&
			stock[n] > stock[n - 1]) {
			return n;
		}
		return -1;
	}
	
	// [TIMING] 하강
	public static int down(int[] stock, int n) {
		if (n < 3) return -1;
		if (stock[n - 2] < stock[n - 3] &&
			stock[n - 1] < stock[n - 2] &&
			stock[n] < stock[n - 1]) {
			return n;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int balance = sc.nextInt();
		int BNP_balance = balance, TIMING_balance = balance;
		int ea = 0;
		int[] stock = new int[14];
		
		// 주가 입력받기
		for (int i = 0; i < stock.length; i++) {
			stock[i] = sc.nextInt();
		}
		
		// BNP 계산하기
		for (int i = 0; i < stock.length; i++) {
			if (balance / stock[i] > 0) {
				ea += balance / stock[i];
				balance = balance % stock[i];
			}
		}
		BNP_balance = balance + stock[13] * ea;
		
		balance = TIMING_balance;
		ea = 0;
		// TIMING 계산하기
		for (int i = 0; i < stock.length - 1; i++) {
			if (up(stock, i) != -1) {
				balance += stock[i + 1] * ea;
				ea = 0;
			}
			if (down(stock, i) != -1) {
				ea += balance / stock[i];
				balance = balance % stock[i];
			}
		}
		TIMING_balance = balance + stock[13] * ea;
		
		// 결과 출력
		if (BNP_balance > TIMING_balance) {
			System.out.println("BNP");
		}
		else if (BNP_balance == TIMING_balance) {
			System.out.println("SAMESAME");
		}
		else {
			System.out.println("TIMING");
		}
		
	}
}
