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
		Arrays.sort(arr);
		for(int i=0; i<N-1; i++){
			if(arr[i] == arr[i+1]) return "D";
		}
		return "U";
	}

}
