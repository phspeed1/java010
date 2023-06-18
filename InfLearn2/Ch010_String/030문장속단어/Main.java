import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.nextLine();
    Main main = new Main();
    System.out.println(main.solution(str));
    return;
  }

String solution(String str){
	String answer = "";
	for(String s : str.split(" ")) {
		if(s.length() > answer.length()) {
			answer = s;
		}
	}
	return answer;
}

  String solution1(String str){
	  StringTokenizer st = new StringTokenizer(str, " ");
	  String answer = "";
	  while(st.hasMoreTokens()){
		String s = st.nextToken();
		if(s.length() > answer.length()){
			answer = s;
		}
	  }
	  return answer;
  }
}