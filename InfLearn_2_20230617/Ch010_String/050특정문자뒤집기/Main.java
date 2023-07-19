import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	System.out.println(main.solution(in.nextLine() ) );
    return ;
  }

	String solution(String str1) {
		char[] str = str1.toCharArray();
		int lt = 0;
		int rt = str.length -1;

		while(lt <= rt) {
			while(!Character.isAlphabetic(str[lt]) ) lt++;
			while(!Character.isAlphabetic(str[rt]) ) rt--;
			if(lt <= rt){
				char t = str[lt];
				str[lt++] = str[rt];
				str[rt--] = t;
			}
		}
		
		return String.valueOf(str);
	}
}