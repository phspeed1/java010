import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	String str = "eochjgoekghlakegh h";
	str = in.nextLine();
	String str1 = str.split(" ")[0];
	char tgt  = str.split(" ")[1].charAt(0);
	System.out.println(main.solution(str1, tgt));

    return ;
  }

	String solution(String str, char tgt){
		String answer = "";

		char[] arr = str.toCharArray();
		for(int i=0; i<arr.length; i++){
			char c = arr[i];
			int dis = 0;

			while(true){
				if( i-dis >= 0 && arr[i-dis] == tgt) break;
				if( i+dis <arr.length && arr[i+dis] == tgt) break;
				dis++;
			}


			answer += dis + " ";

		}
		
		return answer;
	}


	
}