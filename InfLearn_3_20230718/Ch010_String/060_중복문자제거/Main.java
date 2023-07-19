import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	System.out.println(main.solution(in.nextLine()));
    return ;
  }

	String solution(String str){
		String answer = "";

		char[] arr = str.toCharArray();
		for(int i=0; i<arr.length; i++){
			boolean isBefore = false;
			for(int j=i-1; j>=0; j--){
				if(arr[j] == arr[i]) isBefore = true;
			}
			if(!isBefore) answer += arr[i];
		}

		return answer;
	}


}