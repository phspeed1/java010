public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int C = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(C, N, arr));
	}
	int ans;



	int solution(int C, int N, int[] arr){
		ans = 0;

		max = 0;
		DFS(C, N, arr, 0, 0);
		ans = max;

		return ans;
	}

	int max;
	void DFS(int C, int N, int[] arr, int lv, int sum){
		if(sum > C) return;
		max = Math.max(max, sum);
		if(lv == N) return;

		DFS(C, N, arr, lv+1, sum);
		DFS(C, N, arr, lv+1, sum + arr[lv]);

	}

/*
	int solution(int C, int N, int[] arr){
		ans = 0;

		int[] dp = new int[C+1];

		for(int i=0; i<N; i++){
			int w = arr[i];
			for(int j=C; j>= w; j--){
				dp[j] = Math.max(dp[j], dp[j - w]+w);
			}
		}
		ans = dp[C];

		return ans;
	}
*/


}
