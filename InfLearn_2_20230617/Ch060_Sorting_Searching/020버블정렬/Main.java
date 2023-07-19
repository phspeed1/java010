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
			for(int j=0; j<N-1-i; j++)
				if(arr[j] > arr[j+1])
					swap(arr, j, j+1);
		}
		
		for(int x : arr) ans.append(x + " ");
		return ans.toString().trim();
	}

	String solution1(int N, int[] arr){
		StringBuilder ans = new StringBuilder();

		for(int i=0; i<N-1; i++){
			for(int j=N-1; j>i; j--)
				if(arr[j-1] > arr[j])
					swap(arr, j-1, j);
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
