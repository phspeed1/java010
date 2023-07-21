public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		System.out.println(new Main().solution(N, M));
	}


	String answer;
	String solution(int N, int M){
		answer = "";
		combiDup(N, M, 0, new int[M]);
		return answer;
	}

	void combiDup(int N, int M, int lv, int[] res){
		if(lv == M){
			for(int i : res) answer += i+" ";
			answer += "\n";
			return;
		}
		for(int i=1; i<=N; i++){
			res[lv] = i;
			combiDup(N, M, lv+1, res);
		}
	}


}
