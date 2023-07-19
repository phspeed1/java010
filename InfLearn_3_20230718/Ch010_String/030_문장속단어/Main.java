import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.nextLine();
    System.out.println(new Main().solution(str));
  }

	String solution(String str){
		String answer = "";
		StringTokenizer st = new StringTokenizer(str, " ");
		while(st.hasMoreTokens()){
			String s = st.nextToken();
			if(s.length() > answer.length()) answer = s;
			
		}
		return answer;
	}

}