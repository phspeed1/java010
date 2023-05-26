import java.util.*;

public class Solution02 {
    public static void main(String[] args) {
        String input_string = "edeaaabbccd";
        System.out.println("input_string : "+input_string);
        String output_string = new Solution02().solution(input_string);
        System.out.println("output_string : "+output_string);
    }
    public String solution(String input_string) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        sb.append(input_string.charAt(0));
        for(int i=1; i<input_string.length(); i++){
            char c = input_string.charAt(i);
            if(c != sb.charAt(sb.length()-1)){
                if(sb.indexOf(String.valueOf(c)) > -1){
                    if(answer.indexOf(c) == -1)
                        answer += c;
                }
                sb.append(c);
            }
            System.out.println(input_string+"["+i+"]"+c+" -->"+sb.toString()+"==>"+answer);            
        }
        char[] chars = answer.toCharArray();
        Character[] chracters = new Character[chars.length];
        for(int i=0; i<chars.length; i++){
            chracters[chars.length-1-i] = chars[i];
        }

//        Arrays.sort(chracters, Collections.reverseOrder(null));
        Arrays.sort(chracters);
        answer = "";
        for(Character c : chracters)
            answer += c;
        
        if(answer.length()==0)
            answer = "N";
        

        return answer;
    }    
}
