public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		Integer[] arr = new Integer[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int M = sc.nextInt();

		System.out.println(new Main().solution(N, arr, M));
	}

	int M;
	int ans;

	int solution(int N, Integer[] arr, int M){
		this.M = M;
		ans = Integer.MAX_VALUE;
		java.util.Arrays.sort(arr, java.util.Collections.reverseOrder());

		DFS(arr, N, 0, 0);
		return ans;
	}

	void DFS(Integer[] arr, int N, int lv, int sum){
		if(sum > M) return;
		if(lv > ans) return;

		if(sum == M) {
			ans = Math.min(ans, lv);
			return;
		}
		
		for(int i=0; i<N; i++){
			DFS(arr, N, lv+1, sum+arr[i]);
		}

	}

}
