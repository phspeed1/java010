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
	boolean isSame = false;
	int C;

	int solution(int C, int N, int[] arr){
		this.C = C;
		ans = 0;

		DFS(arr, N, 0, 0);
		return ans;
	}

	void DFS(int[] arr, int N, int lv, int sum){
		if(sum > C) return;
		ans = Math.max(ans, sum);
		if(lv == N) return;

		DFS(arr, N, lv+1, sum+arr[lv]);
		DFS(arr, N, lv+1, sum);
	}

}
