package week02;

import java.util.Scanner;

public class N1547_공 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 컵의 위치를 바꾼 횟수
		int M = sc.nextInt();
		
		// 공이 들어있는 초기 컵의 번호
		int ball = 1;		
		
		for (int i = 0; i < M; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
			if (ball == X) {
				ball = Y;
			}
			else if (ball == Y) {
				ball = X;
			}
			
			// 예외 발생
			if (X < 1 || X > 3 || Y < 1 || Y > 3) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(ball);

	}
}
