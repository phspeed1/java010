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
		for(int i=0; i<str.length(); i++){
			int min = Integer.MAX_VALUE;
			int m1 = str.substring(0, i+1).lastIndexOf(tgt);
			int m2 = str.substring(i).indexOf(tgt);
//			System.out.println("["+i+"] "+str.charAt(i)+" : "+m1+" ,  "+m2);
			m1 = m1 != -1 ? i - m1 : Integer.MAX_VALUE;
			m2 = m2 != -1 ? m2 : Integer.MAX_VALUE;
			System.out.print(Math.min(m1, m2)+" ");
		}
		return "";
	}


	
}