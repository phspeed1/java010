import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int[] arr1;
		int K = 0;

  		N = sc.nextInt();
  		K = sc.nextInt();
		arr1 = new int[N];
		for(int i=0; i<N; i++)
			arr1[i] = sc.nextInt();

		System.out.println(new Main().solution(N, K, arr1));
	}


	int solution(int N, int K, int[] arr){
		int answer = 0;

		return answer;
	}



}
