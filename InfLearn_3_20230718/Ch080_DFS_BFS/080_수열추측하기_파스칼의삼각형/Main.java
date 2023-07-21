public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int F = sc.nextInt();

		System.out.println(new Main().solution(N, F));
	}

	String ans = "";
	int[][] dp;
	int[] wg;

	String solution(int N, int F){
		ans = "";
		
		dp = new int[11][11];
		wg = new int[N];
		for(int i=0; i<N; i++){
			wg[i] = combiCnt(N-1, i);
		}

		int[] ch = new int[N+1];
		int[] res = new int[N];

		finished = false;
		DFS(N, F, 0, ch, res, 0);

		return ans;
	}
	
	boolean finished;
	void DFS(int N, int F, int lv, int[] ch, int[] res, int sum){
		if(finished) return;
		if(lv == N){
			if(F == sum){
				finished = true;
				for(int n : res) ans += n+" ";
			}
			return;
		}

		for(int i=1; i<=N; i++){
			if(ch[i] == 1) continue;
			ch[i] = 1;
			res[lv] = i;
			DFS(N, F, lv+1, ch, res, sum + res[lv] * wg[lv]);
			ch[i] = 0;
		}
	}

	int combiCnt(int n, int r){
		if(n==r || r == 0) return 1;
		return dp[n][r] = combiCnt(n-1, r-1) + combiCnt(n-1, r);
	}

}
