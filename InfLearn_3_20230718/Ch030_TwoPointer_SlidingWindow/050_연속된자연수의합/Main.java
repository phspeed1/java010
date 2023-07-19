import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = 15;
		N = sc.nextInt();
		System.out.println(new Main().solution(N));

	}

	int solution(int N){
		int answer = 0;
		int sum = 0, lt = 1;
		for(int rt=1; rt<N; rt++){
			sum += rt;
			if(sum == N) {
//				System.out.println(lt+"~"+rt+" : "+sum);
				answer++;
			}
			while(sum > N){
				sum -= lt++;
				if(sum == N) {
//					System.out.println(lt+"~"+rt+" : "+sum);
					answer++;
				}
			}

		}
		
		return answer;

	}

}
