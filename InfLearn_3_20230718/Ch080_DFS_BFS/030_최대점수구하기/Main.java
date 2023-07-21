public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		System.out.println(new Main().solution(N, M, arr));
	}

	int answer;

	int solution(int N, int M, int[][] arr){
		answer = 0;
		DFS(N, M, arr, 0, 0, 0);
		return answer;
	}

	void DFS(int N, int M, int[][] arr, int lv, int ss, int st){
		if(st > M) return;
		answer = Math.max(answer, ss);
		if(lv == N) return;

		DFS(N, M, arr, lv+1, ss + arr[lv][0], st + arr[lv][1]);
		DFS(N, M, arr, lv+1, ss, st);

	}



}
