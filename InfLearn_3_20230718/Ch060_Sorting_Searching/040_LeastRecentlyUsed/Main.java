import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(S, N, arr));
	}

	String solution(int S, int N, int[] arr){
		String answer = "";

		int[] mem = new int[S];
		for(int n : arr){
			int hit = S-1;
					
			for(int i=0; i<S; i++){
				if(mem[i] == n){
					hit = i; break;
				}
			}
			for(int j = hit-1; j>=0; j--){
				mem[j+1] = mem[j];
			}
			mem[0] = n;

		}
		for(int n : mem) answer += n + " ";

		return answer;
	}

	
	void swap(int[] arr, int a, int b){
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}





}
