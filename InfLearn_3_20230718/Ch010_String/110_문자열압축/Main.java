import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	String str = "KKHSSSSSSSE";
	str = "KSTTTSEEKFKKKDJJGG";
	str = in.nextLine();
	System.out.println(main.solution(str));

    return ;
  }
	String solution(String str){
		String answer = "";
		str += " ";
		char[] arr = str.toCharArray();
		int cnt = 1;
		for(int i=0; i<arr.length -1; i++){
			if(arr[i] == arr[i+1]){
				cnt++;
			}else{
				answer += arr[i];
				if(cnt > 1) answer += cnt;
				cnt = 1;
			}
		}

		return answer;
	}

	
}