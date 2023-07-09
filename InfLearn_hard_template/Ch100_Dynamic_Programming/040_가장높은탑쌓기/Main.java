import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 5;
		N = sc.nextInt();
		int[][] arr = new int[N][3];
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++){
				arr[i][j] = sc.nextInt();
			}
		}

		System.out.println(new Main().solution(N, arr));
	}

	int solution(int N, int[][] arr){	
		int answer = 0;

		return answer;
	}

}
