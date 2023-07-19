import java.util.*;
  
public class Main {
  public static void main(String[] args){
	  Main main = new Main();
    Scanner in=new Scanner(System.in);
    int N = in.nextInt();
	in.nextLine();

	for(int i=0; i<N; i++) System.out.println(main.solution(in.nextLine()));
    return ;
  }

	String solution(String str){
	  StringBuilder ans = new StringBuilder();
	  for(int i=str.length() - 1; i >=0; i--) ans.append(str.charAt(i));
		return ans.toString();
	}

  String solution1(String str){
	  return new StringBuilder(str).reverse().toString();
  }
}