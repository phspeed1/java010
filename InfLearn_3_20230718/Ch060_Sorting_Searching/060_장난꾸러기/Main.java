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

		int[] crr = Arrays.copyOf(arr, N);
		Arrays.sort(crr);

		for(int i=0; i<N; i++){
			if(arr[i] != crr[i]) answer += (i+1) + " ";
		}

		return answer;
	}

}
