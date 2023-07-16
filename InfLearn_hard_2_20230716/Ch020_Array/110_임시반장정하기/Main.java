import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int[][] arr;

  		N = sc.nextInt();
		arr = new int[N][5];
		for(int i=0; i<N; i++)
			for(int j=0; j<5; j++)
				arr[i][j] = sc.nextInt();

		System.out.println(new Main().solution(N, arr));
	}


	int solution(int N, int[][] arr){
		int ans = 0;

		int max = 0;

		for(int i=0; i<N; i++){
			int sum = 0;
			for(int j=0; j<N; j++){
				for(int k=0; k<5; k++){
					if(arr[i][k] == arr[j][k]){
						sum++;
						break;
					}
				}
			}
			if(sum > max){
				max = sum;
				ans = i+1;
			}
		}


		return ans;
	}


}
