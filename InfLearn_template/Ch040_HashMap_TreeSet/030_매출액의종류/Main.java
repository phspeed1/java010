import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];

		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();

		List<Integer> answer = new Main().solution(N, K, arr);
		for(int a : answer) System.out.print(a + " ");
		System.out.println();
	}

	List<Integer> solution(int N, int K, int[] arr){
		List<Integer> answer = new List<Integer>();

		return answer;
	}

}
