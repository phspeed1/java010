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
		str = str+" ";
		int d=1;
		for(int i=0; i<str.length()-1; i++){
			if(str.charAt(i) != str.charAt(i+1)){
				System.out.print(str.charAt(i));
				if(d >1) System.out.print(d);
				d=1;
			}else{
				d++;
			}
		}
		return "";
	}

	
}