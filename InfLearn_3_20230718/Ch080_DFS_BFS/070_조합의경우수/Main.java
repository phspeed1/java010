public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();

		System.out.println(new Main().solution(N, R));
	}

	int[][] dp;
	int solution(int N, int R){
		int answer = 0;
		dp = new int[34][34];
		answer = combiCnt(N, R);
		return answer;
	}

	int combiCnt(int n, int r){
		if(n == r || r == 0) return 1;
		return dp[n][r] = combiCnt(n-1, r-1) + combiCnt(n-1, r);
	}



}
