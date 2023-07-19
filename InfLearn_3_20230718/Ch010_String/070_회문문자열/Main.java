import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	System.out.println(main.solution(in.nextLine()));
    return ;
  }

	String solution(String str1){
		String answer = "YES";
		char[] arr = str1.toUpperCase().toCharArray();
		for(int i=0; i< arr.length/2; i++){
			if(arr[i] != arr[arr.length-1 -i]) return "NO";
		}

		return answer;
	}

	
}