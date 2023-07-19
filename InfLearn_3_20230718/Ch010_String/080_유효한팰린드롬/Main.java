import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	System.out.println(main.solution(in.nextLine()));
//	System.out.println(main.solution("found7, time: study; Yduts; emit, 7Dnuof"));
	
    return ;
  }

	String solution(String str){
		String answer = "YES";

		char[] arr = str.toUpperCase().toCharArray();
		int lt = 0; int rt = arr.length -1;
		while(lt<= rt){
			while(!Character.isLetter(arr[lt])) lt++;
			while(!Character.isLetter(arr[rt])) rt--;
			if(lt <= rt){
				if(arr[lt++] != arr[rt--]) return "NO";
			}
		}

		return answer;
	}

}