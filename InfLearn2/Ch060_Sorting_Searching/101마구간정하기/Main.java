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
		int rt = Arrays.stream(arr).max().getAsInt();

		while(lt <= rt){
			int midDist = (lt + rt) / 2;
			int horseCnt = canHorseCount(arr, midDist);
			if(horseCnt >= C){
				ans = midDist;
				lt = midDist +1;
			}else{
				rt = midDist -1;
			}
		}
		


		return ans;
	}

	int canHorseCount(int[] arr, int dist){
		int canHorse = 1;
		int lastPoint = arr[0];
		for(int i=1; i<arr.length; i++){

			if(arr[i] - lastPoint >= dist){
				canHorse++;
				lastPoint = arr[i];
			}
		}

		return canHorse;
	}


}
