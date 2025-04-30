package week01;

import java.util.Scanner;

public class N10448_유레카이론 {
	public static int T(int p) {
		return p * (p + 1) / 2; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수 입력받기
		int test = sc.nextInt();
		int max = 0;
		
		// 테스트케이스 배열에 저장하기
		int[] testcase = new int[test];
		for (int i = 0; i < test; i++) {
			testcase[i] = sc.nextInt();
		}
		
		// 테스트케이스만큼 for{t}문 실행
		for (int t = 0; t < test; t++) {
			boolean result = false;
			// 가능한 삼각수 값 구하기
			for (int p = 2; p <= 45; p++) {
				if (testcase[t] < T(p)) {
					max = p - 1;
					break;
				}
			}

			int sum = 0;
			// 첫번쨰 삼각수 for{i}
			for (int i = 1; i <= max; i++) {
				// 두번째 삼각수 for{j}
				for (int j = 1; j <= max; j++) {
					// 세번째 삼각수 for {k}
					for (int k = 1; k <= max; k++) {
						sum = T(i) + T(j) + T(k);
						// 삼각수의 합이 맞는지 확인
						if (sum == testcase[t]) {
							System.out.println("1");
							result = true;
							break;
						}
					} // end of for{k}
					if (result) break;
				} // end of for{j}
				if (result) break;
			} // end of for{i}
			if (!result)
				System.out.println("0");
		} // end of for{t}
	}
}
