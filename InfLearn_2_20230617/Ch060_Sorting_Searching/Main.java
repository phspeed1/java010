import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			
		}

		System.out.println(new Main().solution(N, arr));
	}

	String solution(int N, int[] arr){
		StringBuilder ans = new StringBuilder();
		int[] arr2 = arr.clone();
		Arrays.sort(arr2);

		for(int i=0; i<N; i++){
			if(arr[i] != arr2[i]) { 
				ans.append( (i+1) + " ");
			}
		}

		return ans.toString().trim();
	}

	String solution(int N, int[] arr, int[] arr2){
		StringBuilder ans = new StringBuilder();
		Arrays.sort(arr2);

		for(int i=0; i<N; i++){
			if(arr[i] != arr2[i]) { 
				ans.append( (i+1) + " ");
				break;
			}
		}
		for(int i=N-1; i>=0; i--){
			if(arr[i] != arr2[i]) { 
				ans.append( (i+1));
				break;
			}
		}

		return ans.toString().trim();
	}

}
