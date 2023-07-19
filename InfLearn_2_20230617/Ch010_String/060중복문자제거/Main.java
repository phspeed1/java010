import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	System.out.println(main.solution(in.nextLine()));
    return ;
  }

	String solution(String str){
		StringBuilder ans = new StringBuilder();
		for(char c : str.toCharArray()) 
			if(ans.indexOf(String.valueOf(c)) == -1) ans.append(c);
		return ans.toString();
	}

	String solution2(String str){
		HashSet<Character> set = new HashSet<Character>();
		String ans = new String();
		for(char c : str.toCharArray()){
			if(set.contains(c)) continue;
			ans += c; set.add(c);
		}
		return ans;
	}

}