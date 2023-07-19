public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();

		System.out.println(new Main().solution(N, R));
	}

	int[][] dp;
	int solution(int N, int R){
		dp = new int[35][35];
		int ans = combiCnt(N, R);
		return ans;
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
