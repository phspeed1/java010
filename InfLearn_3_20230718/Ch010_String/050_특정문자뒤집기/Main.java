import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	System.out.println(main.solution(in.nextLine() ) );
    return ;
  }

	String solution(String str) {
		String answer = "";
		char[] arr = str.toCharArray();
		int lt = 0;
		int rt = arr.length-1;
		while(lt < rt){
			while(!Character.isLetter(arr[lt]) ) lt++;
			while( !Character.isLetter(arr[rt]) ) rt--;
			char temp = arr[lt];
			arr[lt++] = arr[rt]; arr[rt--] = temp;
		}
		answer = new String(arr);
		return answer;
	}
}