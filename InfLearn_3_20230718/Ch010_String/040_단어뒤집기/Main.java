import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int N = in.nextInt();
	in.nextLine();

	for(int i=0; i<N; i++) System.out.println(new Main().solution(in.nextLine()));
    return ;
  }

	String solution(String str){
		String answer = "";
		answer = new StringBuilder(str).reverse().toString();

		return answer;
	}

}