import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int V = 9;
		int E = 12;
		V = sc.nextInt();
		E = sc.nextInt();
		int[][] arr = new int[E][3];
		for(int i=0; i<E; i++){
			for(int j=0; j<3; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(new Main().solution(V, E, arr));
	}
	

	int solution(int V, int E, int[][] arr){
		int answer = 0;


		return answer;
	}

}
