import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 20;
   		N = sc.nextInt();

		System.out.println(new Main().solution(N));
	}

	int[] dp;

	int solution(int N){
		int answer = 0;

		int[] arr = new int[N+1];
		for(int i=2; i<=N; i++){
			if(arr[i] == 0) { 
				answer++;
//				System.out.println(i);
				for(int j=i; j<=N; j+=i){
					if(arr[j] == 0) arr[j] = i;
				}
			}
		}
//		System.out.println(""+Arrays.toString(arr));

		return answer;
	}




}
