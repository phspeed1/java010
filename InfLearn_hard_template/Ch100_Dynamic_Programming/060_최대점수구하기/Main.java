import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N= sc.nextInt();
		int M = sc.nextInt();

		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		System.out.println(new Main().solution(N, arr, M));
	}

	int solution(int N, int[][] arr, int M){	
		int answer = 0;


		return answer;
	}



}
