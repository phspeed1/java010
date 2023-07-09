import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(new Main().solution(N, C, arr));
	}

	int solution(int N, int C, int[] arr){
		int ans = 0;
		Arrays.sort(arr);
		int lt = 1;
		int rt = arr[N-1] ;
		int mid = (lt + rt)/2;
		ans = lt;

		while(lt <= rt){
			mid = (lt + rt)/2;
			int horseCnt = getHorseCnt(arr, mid);
	//		System.out.println("capacity("+mid+") horseCnt : "+horseCnt);
			//  1    4     8 : 2
			//  1    2     3 : 3
			//   2           3
			if(horseCnt >= C){
				ans = mid;
				lt = mid+1;
			}else{
				rt = mid-1;
			}
		}

		return ans;
	}
/*
  1  2  4  8  9
  1          2       <- 4
*/
	int getHorseCnt(int[] arr, int distance){
		int cnt = 1;
		int ep = arr[0];
		for(int i=1; i<arr.length; i++){
			if(arr[i] - ep >= distance){
				cnt++;
				ep = arr[i];
			}
		}
		return cnt;
	}


}
