package week01;

import java.util.Scanner;
import java.util.Arrays;

public class N2309_일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] height = new int[9];
		int[] answer = new int[7];
		int sum = 0;
		
		// 난쟁이 9명 키 입력받기
		for (int i = 0; i < height.length; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}
		
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				// (난쟁이 7명 조합의 키) == 100인지 확인
				int h_sum = sum - height[i] - height[j];
				
				if (h_sum == 100) {
					int index = 0;
					for (int k = 0; k < height.length; k++) {
						if (k != i && k != j)
							answer[index++] = height[k];
					}
					Arrays.sort(answer);
				
					for (int k = 0; k < answer.length; k++)
						System.out.println(answer[k]);
				
					return;
				}
			} // end of for{f}
		} // end of for{i}
	}
}
