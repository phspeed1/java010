import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int[] arr;

  		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, arr));
	}


	String solution(int N, int[] arr){
		String answer = "";

		for(int i : arr){
			int g = 1;
			for(int j : arr){
				if(j > i) g++;
			}
			answer += g + " ";
		}
		

		return answer;
	}

}
