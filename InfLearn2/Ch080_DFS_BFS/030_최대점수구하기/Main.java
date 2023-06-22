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

	int ans;
	int M;

	int solution(int N, int M, int[][] arr){
		this.M = M;
		ans = 0;

		DFS(arr, N, 0, 0, 0);
		return ans;
	}

	void DFS(int[][] arr, int N, int lv, int sum, int tm){
		if(tm > M) return;
		
		ans = Math.max(ans, sum);

		if(lv == N) return;

		DFS(arr, N, lv+1, sum+arr[lv][0], tm+arr[lv][1]);
		DFS(arr, N, lv+1, sum, tm);
	}

}
