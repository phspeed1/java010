import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 3;
		int K = 3;
		int[] arr = {1, 2, 3};

  		N = sc.nextInt();
  		K = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, K, arr));
	}

	int solution(int N, int K, int[] arr){
		int answer = -1;

		Set<Integer> set = new TreeSet<Integer>(Collections.reverseOrder());
		for(int i = 0; i<N; i++){
			for(int j=i+1; j<N; j++){
				for(int k=j+1; k<N; k++){
					set.add(arr[i] + arr[j] + arr[k]);
				}
			}
		}
		int i=1;
		for(int n : set){
			if(i == K) return n;
			i++;
		}
		return answer;
	}


/*
	int solution(int N, int K, int[] arr){
		int answer = 0;

		Set<Integer> set = new TreeSet<Integer>(Collections.reverseOrder());
		for(int n : arr) set.add(n);
		int i=0;
		for(int n : set){
			if(i < K-1){
				i++;
				continue;
			}
			if(i == K-1 + K) return answer;
			answer += n;
			i++;
		}

		return answer;
	}
*/

}
