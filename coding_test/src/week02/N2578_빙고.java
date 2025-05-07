package week02;

import java.util.Scanner;

public class N2578_빙고 {	
	// 세로 빙고 확인
	public static int height(int[][] bingo) {
		int ea = 0;
		for (int i = 0; i < bingo.length; i++) {
			if (bingo[0][i] == 0 && bingo[1][i] == 0 && bingo[2][i] == 0
				&& bingo[3][i] == 0 && bingo[4][i] == 0) {
				ea++;
			}
		}
		
		return ea;
	}
	
	// 가로 빙고 확인
	public static int width(int[][] bingo) {
		int ea = 0;
		for (int i = 0; i < bingo.length; i++) {
			if (bingo[i][0] == 0 && bingo[i][1] == 0 && bingo[i][2] == 0
				&& bingo[i][3] == 0 && bingo[i][4] == 0) {
				ea++;
			}
		}
		
		return ea;
	}
	
	// 대각선 빙고 확인
	public static int cross(int[][] bingo) {
		int ea = 0;
		
		if (bingo[0][0] == 0 && bingo[1][1] == 0 && bingo[2][2] == 0
			&& bingo[3][3] == 0 && bingo[4][4] == 0) {
			ea++;
		}
		
		if (bingo[0][4] == 0 && bingo[1][3] == 0 && bingo[2][2] == 0
			&& bingo[3][1] == 0 && bingo[4][0] == 0) {
			ea++;
		}
		
		return ea;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] bingo = new int[5][5];
		int[][] call = new int[5][5];
		
		// 빙고판 값 입력하기
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
		
		// 사회자가 부르는 값 입력하기
		for (int i = 0; i < call.length; i++) {
			for (int j = 0; j < call[i].length; j++) {
				call[i][j] = sc.nextInt();
			}
		}

		
		int print = 0;
		int ea = 0; 	// 빙고 개수
		int search = 0;
		// 사회자가 부르는 값 search에 저장
		for (int i = 0; i < call.length; i++) {
			for (int j = 0; j < call[i].length; j++) {
				search = call[i][j];
				
				// 사회자가 부른 값 체크하기
				for (int k = 0; k < bingo.length; k++) {
					for (int l = 0; l < bingo[k].length; l++) {
						if (search == bingo[k][l]) {
							search = 0;
							bingo[k][l] = 0;
							break;
						}
					}
					if (search == 0) {
						break;
					}
				}
				
				// 빙고인지 확인하기
				ea = height(bingo) + width(bingo) + cross(bingo);
				
				if (ea == 3) {
					print = 5 * i + (j + 1);
					break;
				}
				else ea = 0;
			
			} // end of for {j}
			if (print != 0) break;
		} // end of for {i}
		
		System.out.println(print);
	}
}
