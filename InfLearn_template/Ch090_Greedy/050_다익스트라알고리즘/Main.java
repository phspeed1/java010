import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 6;
		int M = 9;
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] arr = new int[M][3];
		for(int i=0; i<M; i++){
			for(int j=0; j<3; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(new Main().solution(N, M, arr));
	}
	

	String solution(int N, int M, int[][] arr){
		String answer = "";


		return answer;
	}



}
