package week03;

import java.util.*;

public class N11724_연결요소의개수구하기 {	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void dfs(int node) {
		visited[node] = true;
		
		for (int n : graph[node]) {
			if (!visited[n]) {
				dfs(n);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		// 그래프 초기화
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		}
		
		int count = 0;	// 연결 요소 개수 초기화
		
		// DFS 실행
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
}
