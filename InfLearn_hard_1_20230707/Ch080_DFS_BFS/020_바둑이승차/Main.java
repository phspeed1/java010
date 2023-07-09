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
	int C;
	int N;
	int solution(int C, int N, int[] arr){
		ans = 0;
		this.C = C;
		this.N = N;
		DFS(arr, 0, 0);

		return ans;
	}

	void DFS(int[] arr, int lv, int sum){
		if(sum <= C){
			ans = Math.max(ans, sum);
		}else{
			return;
		}
		if(lv == N) return;

		DFS(arr, lv+1, sum+arr[lv]);
		DFS(arr, lv+1, sum);

	}





}
