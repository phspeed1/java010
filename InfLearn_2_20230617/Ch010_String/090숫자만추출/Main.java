import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	System.out.println(main.solution(in.nextLine()));
//	System.out.println(main.solution("g0en2T0s8eSoft"));

    return ;
  }

	int solution(String str1){
		char[] str = str1.toCharArray();
		int ans = 0;
		for(char c : str){
			if(Character.isDigit(c))
				ans = ans * 10 + (Character.getNumericValue(c));
		}
		return ans;
	}

	int solution1(String str1){
		char[] str = str1.replaceAll("[^0-9]", "").toCharArray();
		int ans = 0;
		for(char c : str){
			ans = ans * 10 + (c - '0');
		}
		return ans;
	}

	
}