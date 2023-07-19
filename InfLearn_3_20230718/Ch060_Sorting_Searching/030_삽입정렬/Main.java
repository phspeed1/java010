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
		String answer = "";

		for(int i=1; i<N; i++){
			int n = arr[i];
			int j=i-1;
			for( ; j>=0; j--){
				if(arr[j] >= n) {
					arr[j+1] = arr[j];
				}else{
					break;
				}
			}
			arr[j+1] = n;
		}
		/*
		11 7 5 6 10 9
		     7
		*/

		for(int n : arr) answer += n + " ";

		return answer;
	}

	void swap(int[] arr, int a, int b){
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}

}
