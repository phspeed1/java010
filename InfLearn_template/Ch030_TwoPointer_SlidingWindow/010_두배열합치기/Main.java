import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int[] arr1;
		int M = 0;
		int[] arr2;

  		N = sc.nextInt();
		arr1 = new int[N];
		for(int i=0; i<N; i++)
			arr1[i] = sc.nextInt();

  		M = sc.nextInt();
		arr2 = new int[M];
		for(int i=0; i<M; i++)
			arr2[i] = sc.nextInt();

		System.out.println(new Main().solution(N, M, arr1, arr2));
	}


	String solution(int N, int M, int[] arr1, int[] arr2){
		String answer = "";

		return answer;
	}


}
