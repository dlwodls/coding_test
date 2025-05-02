package week01;

import java.util.Scanner;

public class N1018_체스판다시칠하기 {
	static char[][] board;
	
	public static int countRepaint(int r, int c) {
		int count_w = 0; // 횐색으로 시작하는 경우
		int count_b = 0; // 검은색으로 시작하는 경우
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				char recent = board[r + i][c + j];
				
				if ((i + j) % 2 == 0) {
					if (recent != 'W')
						count_w++;
					if (recent != 'B')
						count_b++;
				}
				else {
					if (recent != 'B')
						count_w++;
					if (recent != 'W')
						count_b++;
				}
			} // end of for{j}
		} // end of for{i}
		
		return Math.min(count_w, count_b);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
				
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = sc.nextLine().toCharArray();
		}
		
		int min = 64; // 칠할 수 있는 최솟값 중에서 최댓값(초기값)이 64
		
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0 ;j <= M - 8; j++) {
				min = Math.min(min, countRepaint(i, j));
			}
		}
		
		System.out.println(min);
	}
}
