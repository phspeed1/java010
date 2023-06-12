import java.util.*;
import java.io.*;

public class Inf030MaxWeight{
	public static void main(String[] args){
		int N = 5;
		int M = 20;
		String str = "";
		int[][] arr = new int[N][2];
		String[] strArr;
		arr[0][0]=10;arr[0][1]=5;
		arr[1][0]=25;arr[1][1]=12;
		arr[2][0]=15;arr[2][1]=8;
		arr[3][0]=6;arr[3][1]=3;
		arr[4][0]=7;arr[4][1]=4;

		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try{
			str = reader.readLine();
			strArr = str.split(" ");
			N = Integer.parseInt(strArr[0]);
			M = Integer.parseInt(strArr[1]);
			arr = new int[N][2];
			for(int i=0; i<N; i++){
				str = reader.readLine();
    			strArr = str.split(" ");
				arr[i][0] = Integer.parseInt(strArr[0]);
				arr[i][1] = Integer.parseInt(strArr[1]);
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		new Inf030MaxWeight().solution(arr, N, M);
	}
	int answer;
	private void solution(int[][] arr, int N, int M){
	//	System.out.println(Arrays.toString(arr));
		answer = 0;
		
		DFS(arr, N, M, 0, 0, 0);
        System.out.println(answer);
	}

    void DFS(int[][] arr, int N, int max, int lv, int time, int sum){
        if(time > max) return;
        
        answer = Math.max(answer, sum);

        if(lv == N) return;

        DFS(arr, N, max, lv+1, time, sum);
        DFS(arr, N, max, lv+1, time+arr[lv][1], sum+arr[lv][0]);
    }

}
