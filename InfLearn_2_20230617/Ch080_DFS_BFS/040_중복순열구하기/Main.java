public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] =i + 1;
		}

		System.out.println(new Main().solution(N, M, arr));
	}

	int M;

	String solution(int N, int M, int[] arr){
		this.M = M;

		int[] res = new int[M];
		DFS(arr, N, 0, res);
		return "";
	}

	void DFS(int[] arr, int N, int lv, int[] res){
		if(lv == M) {
			System.out.println(java.util.Arrays.toString(res));
			return;
		}
		
		for(int i=0; i<N; i++){
			res[lv] = arr[i];
			DFS(arr, N, lv+1, res);
		}

	}

}
