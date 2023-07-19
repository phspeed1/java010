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
		int[] dp = new int[str.length()];
		
		int d = 9999;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == tgt) d=0;
			else d++;
			dp[i] = d;
		}
//		System.out.println(Arrays.toString(dp));

		d = 9999;
		for(int i=str.length() -1; i >=0; i--){
			if(str.charAt(i) == tgt) d=0;
			else d++;
			if(dp[i] > d) dp[i] = dp[i] = d;
		}
//		System.out.println(Arrays.toString(dp));
		for(int x : dp) System.out.print(x+" ");

		return "";
	}


	
}