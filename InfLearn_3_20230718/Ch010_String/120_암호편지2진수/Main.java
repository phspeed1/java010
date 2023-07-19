import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	int N = 4;
	String str = "#****###**#####**#####**##**";
//	N = in.nextInt();
//	str = in.next();
	System.out.println(main.solution(N, str));
    return ;
  }

	String solution(int N, String str){
		String answer = "";
		str = str.replace("#", "1").replace("*", "0");
		
		for(int i=0; i<N*7; i+=7){
			String s = str.substring(i, i+7);
			int num = Integer.parseInt(s, 2);
			answer += ((char)num);
		}

		return answer;
	}
	String solution1(int N, String str){
		String answer = "";
		
		for(int i=0; i<N*7; i+=7){
			String s = str.substring(i, i+7);
			int num = 0;
			for(char c : s.toCharArray()){
					num = num * 2 +  (c == '#'?1:0);
			}
			answer += ((char)num);
		}

		return answer;
	}


	
}