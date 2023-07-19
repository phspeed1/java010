import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	System.out.println(main.solution(in.nextLine()));
//	System.out.println(main.solution("found7, time: study; Yduts; emit, 7Dnuof"));
	
    return ;
  }

	String solution(String str1){
		String str = str1.toUpperCase().replaceAll("[^A-Z]", "");
		return str.equals(new StringBuilder(str).reverse().toString()) ? "YES":"NO";
	}

	String solution1(String str1){
		char[] str = str1.toUpperCase().toCharArray();
		int lt = 0;
		int rt = str.length - 1;
		while(lt <= rt){
			while(!Character.isAlphabetic(str[lt])) lt++;
			while(!Character.isAlphabetic(str[rt])) rt--;
			if(str[lt] != str[rt]) return "NO";
			lt++; rt--;
		}
		return "YES";
	}
}