import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	System.out.println(main.solution(in.nextLine()));
//	System.out.println(main.solution("g0en2T0s8eSoft"));

    return ;
  }

	int solution(String str){
		int answer = 0;
		char[] arr = str.toCharArray();
		for(char c : arr){
			if(Character.isDigit(c)){
				int n = c - '0';
				answer = answer * 10 + n;
			}
		}

		return answer;
	}

	
}