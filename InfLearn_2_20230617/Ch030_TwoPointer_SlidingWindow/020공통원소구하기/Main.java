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
		StringBuilder buff = new StringBuilder();
		int idx=0;

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int p1 =0;
		int p2 = 0;
		while(p1 <N && p2<M){
			if(arr1[p1] == arr2[p2]) {
				buff.append(arr1[p1++]+" ");
				p2++;
			}else if(arr1[p1] < arr2[p2]){
				p1++;
			}else{
				p2++;
			}
		}

		return buff.toString().trim();
	}


}
