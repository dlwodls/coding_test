package week01;

import java.util.Scanner;

public class N2231_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		
		// N의 범위 구하기
		int chance = Math.max(1, N - 9 * String.valueOf(N).length());
		
		// chance부터 N까지 검사
		for (int i = chance; i < N; i++) {
			int sum = i;
			int temp = i;
			
			while (temp > 0) {
				sum += temp % 10;	// 마지막 자리수 더하기
				temp /= 10;			// 다음 자리로 이동
			}
			
			if (sum == N) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}
}
