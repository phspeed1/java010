import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int K = 0;
		int[] arr;

  		N = sc.nextInt();
  		K = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, K, arr));
	}

	String solution(int N, int K, int[] arr){
		String answer = "";

		return answer;
	}

}
