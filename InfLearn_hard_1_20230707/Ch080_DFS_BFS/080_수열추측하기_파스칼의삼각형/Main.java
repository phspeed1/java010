public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int F = sc.nextInt();

		System.out.println(new Main().solution(N, F));
	}

	String ans = "";
	int[][] dy;
	int[] bias;
	boolean ended;
	int F;

	String solution(int N, int F){
		ans = "";
		dy = new int[N+1][N+1];
		bias = new int[N];
		for(int i=0; i<N; i++){
			bias[i] = combiCnt(N-1, i);
		}
		
		this.F = F;
		ended = false;
		DFS(N, 0, new int[N], new boolean[N+1]);

		return ans;
	}

	void DFS(int N, int lv, int[] res, boolean[] visited){
		if(ended) return;
		if(lv == N){
			int sum = 0;
			for(int i=0; i<N; i++){
				sum += res[i] * bias[i];
			}
			if(sum == F){
				ended = true;
				for(int num : res) ans += num + " ";
			}

			return;
		}

		for(int i=1; i<=N; i++){
			if(visited[i]) continue;
			visited[i] = true;
			res[lv] = i;
			DFS(N, lv+1, res, visited);
			visited[i] = false;
		}
	}
	
	int combiCnt(int N, int R){
		if(N==R || R == 0) return 1;
		if(dy[N][R] != 0) return dy[N][R];
		return dy[N][R] = combiCnt(N-1, R-1) + combiCnt(N-1, R);
	}
}
