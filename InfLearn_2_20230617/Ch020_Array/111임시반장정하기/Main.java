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
			int cnt=0;
			for(int k=0; k<N; k++){
				for(int j=0; j<5; j++){
					if(arr[i][j] == arr[k][j]){
						cnt++;
						break;
					}
				}
			}
			if(cnt > max){
				max = cnt;
				ans = i;
			}
		}
		

		return ans+1;
	}


}
