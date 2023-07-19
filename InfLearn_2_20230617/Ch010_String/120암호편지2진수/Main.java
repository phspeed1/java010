import java.util.*;
  
public class Main {
  public static void main(String[] args){
	Main main = new Main();
    Scanner in=new Scanner(System.in);
	int N = 4;
	String str = "#****###**#####**#####**##**";
	N = in.nextInt();
	str = in.nextLine();
	str = in.nextLine();
	System.out.println(main.solution(N, str));
    return ;
  }

	String solution(int N, String str1){
		for(int i=0; i<N; i++){
			String str = str1.substring(i*7, (i+1)*7).replace("#", "1").replace("*", "0");
			int num = 0;
			for(int j=0; j<str.length(); j++){
				num = num * 2 + Character.getNumericValue(str.charAt(j));
			}
			char c = (char)num;
			System.out.print(c);
		}
		return "";
	}

	String solution1(int N, String str1){
		for(int i=0; i<N; i++){
			String str = str1.substring(i*7, (i+1)*7).replace("#", "1").replace("*", "0");
			Integer num = Integer.parseInt(str, 2);
			char c = (char)num.intValue();
			System.out.print(c);
		}
		return "";
	}


	
}