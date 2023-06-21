import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, arr));
	}

	String solution(int N, int[] arr){
		StringBuilder ans = new StringBuilder();

		for(int i=0; i<N-1; i++){
			int mi=i;
			for(int j=i+1; j<N; j++)
				if(arr[j] < arr[mi]) mi = j;
			swap(arr, i, mi);
		}
		
		for(int x : arr) ans.append(x + " ");
		return ans.toString().trim();
	}

	String solution1(int N, int[] arr){
		StringBuilder ans = new StringBuilder();

		for(int i=0; i<N; i++){
			int mi=i;
			for(int j=i; j<N; j++)
				if(arr[j] < arr[mi]) mi = j;
			swap(arr, i, mi);
		}
		
		for(int x : arr) ans.append(x + " ");
		return ans.toString().trim();
	}

	void swap(int[] arr, int i1, int i2){
		int tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}

}
