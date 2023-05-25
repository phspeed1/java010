import java.util.Scanner;
  
public class Main {

    int solution(String str, char t){
        int answer = 0;
        

        for(int i=0; i<str.length(); i++){
            if(Character.toLowerCase(str.charAt(i))==Character.toLowerCase(t))
                answer++;
        }

        return answer;
    }
  public static void main(String[] args){
    System.out.println("문자열을 입력하세요.");
    Scanner in=new Scanner(System.in);
    String str = in.next();
    System.out.println("문자를 입력하세요.");
    char c = in.next().charAt(0);
    System.out.println("입력한 문자열 : " + str+", 찾을문자 : "+c);
    int cnt = new Main().solution(str, c);
    System.out.println("찾은 갯수 : "+cnt);
    return ;
  }
}