public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int F = sc.nextInt();

		System.out.println(new Main().solution(N, F));
	}

	int[][] dp;
	int[] bias;
	int[] res;
	boolean[] visited;
	boolean isEnd;
	String ans = "";

	String solution(int N, int F){
		dp = new int[N+1][N+1];
		bias = new int[N];
		for(int i=0; i<N; i++){
			bias[i] = combiCnt(N-1, i);
		}
		
		res = new int[N];
		visited = new boolean[N+1];
		isEnd = false;
		
		DFS(N, F, 0, 0);
		
	//	System.out.println(java.util.Arrays.toString(bias));
		return ans;
	}

	void DFS(int N, int F, int lv, int sum){
		if(isEnd) return;
		if(lv == N){
			if(sum == F){
				for(int x : res) ans += x + " ";
				isEnd = true;
			}
			return;
		}
		
		for(int i=1; i<=N; i++){
			if(!visited[i]){
				visited[i] = true;
				res[lv] = i;
				
				DFS(N, F, lv+1, sum + (res[lv] * bias[lv]));
				visited[i] = false;
			}
		}


	}

	int combiCnt(int n, int r){
		if(n < r) return 0;
		if(r == 0) return 1;
		if(n == r) return 1;
		if(r == 1) return n;

		if(dp[n][r] > 0) return dp[n][r];

		return dp[n][r] = combiCnt(n-1, r-1) + combiCnt(n-1, r);
	}


}
