public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int C = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(C, N, arr));
	}
	int answer;

	int solution(int C, int N, int[] arr){
		answer = 0;
		
		DFS(C, N, arr, 0, 0);

		return answer;
	}

	void DFS(int C, int N, int[] arr, int lv, int sum){
		if(sum > C) return;
		answer = Math.max(answer, sum);
		if(lv == N) return;

		DFS(C, N, arr, lv+1, sum);
		DFS(C, N, arr, lv+1, sum+arr[lv]);
	}



}
