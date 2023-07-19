import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(new Main().solution(N, M, arr));
	}

	int solution(int N, int M, int[] arr){
		int answer = 1;
		Arrays.sort(arr);
		int lt = 0;
		int rt = N-1;
//		System.out.println(Arrays.toString(arr));
		
		while(lt <= rt){
			int mid = (lt + rt)/2;
			if(arr[mid] == M) return mid+1;
			else if( M > arr[mid]) lt = mid+1;
			else rt = mid-1;
		}
		return answer;
	}


}
