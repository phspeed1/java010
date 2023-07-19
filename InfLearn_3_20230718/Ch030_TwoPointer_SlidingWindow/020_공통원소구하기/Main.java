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


	String solution(int N1, int N2, int[] arr1, int[] arr2){
		String answer = "";
		Arrays.sort(arr1); Arrays.sort(arr2);
		int i1 = 0;
		int i2 = 0;
		while(i1 < N1 && i2 < N2){
			if(arr1[i1] == arr2[i2]){
				answer += arr1[i1++] + " ";
				i2++;
			}else if(arr1[i1] < arr2[i2]) i1++;
			else i2++;
		}

		return answer;

	}


}
