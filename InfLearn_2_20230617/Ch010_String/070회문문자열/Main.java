import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	System.out.println(main.solution(in.nextLine()));
    return ;
  }

	String solution(String str1){
		char[] str = str1.toUpperCase().toCharArray();
		for(int i=0; i<str.length; i++){
			if(str[i] != str[str.length-1 -i]) return "NO";
		}
		return "YES";
	}

	
	String solution1(String str){
		String str1 = new StringBuilder(str).reverse().toString();
		if(str.equalsIgnoreCase(str1)) return "YES";
		else return "NO";
	}
}