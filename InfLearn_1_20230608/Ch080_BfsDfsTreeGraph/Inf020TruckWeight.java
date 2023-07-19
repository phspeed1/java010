import java.util.*;
import java.io.*;

public class Inf020TruckWeight{
	public static void main(String[] args){
		int C = 259;
		int N = 5;
		String str = "";
		int[] arr = new int[N];
		String[] strArr;
		arr[0]=81;
		arr[1]=58;
		arr[2]=42;
		arr[3]=33;
		arr[4]=61;

		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try{
			str = reader.readLine();
			strArr = str.split(" ");
			C = Integer.parseInt(strArr[0]);
			N = Integer.parseInt(strArr[1]);
			arr = new int[N];
			for(int i=0; i<N; i++){
				str = reader.readLine();
				arr[i] = Integer.parseInt(str);
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		new Inf020TruckWeight().solution(arr, N, C);
	}
	int answer;
	private void solution(int[] arr, int N, int C){
	//	System.out.println(Arrays.toString(arr));
		answer = 0;
		
		DFS(arr, N, C, 0, 0);
		List<Integer> list = new ArrayList<Integer>();
//		combination(arr, N, C, 0, list);

		System.out.println(answer);
	}

	private void DFS(int[] arr, int N, int total, int lv, int sum){
		if(sum <= total) {
			answer  = Math.max(answer, sum);
		}
		// System.out.println(lv+" : "+sum);
		if(lv == N) return;
		
		DFS(arr, N, total, lv+1, sum);
		DFS(arr, N, total, lv+1, sum + arr[lv]);

	}

	private void combination(int[] arr, int N, int total, int lv, List<Integer> list){
		
		int sum = getSum(list);
		// System.out.println(lv+" : "+sum+" "+list);
		if(sum<= total){
			answer  = Math.max(answer, sum);
		}

		if(lv == N) return;

		for(int i=lv; i<N; i++){
			list.add(arr[i]);
			combination(arr, N, total, i+1, list);
			list.remove(list.size()-1);
		}

	}

	private int getSum(List<Integer> list){
		int sum = 0;
		for(int i : list) sum+=i;
		return sum;
	}
}
