import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String input_string = "edeaaabbccd";
        System.out.println("input_string : "+input_string);
        String output_string = new Solution().solution(input_string);
        System.out.println("output_string : "+output_string);
    }
    public String solution(String input_string) {
        String answer = "";

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<input_string.length(); i++){
            if(i==0){
                map.put(input_string.charAt(i), 1);
                continue;
            }
            
            if(input_string.charAt(i-1) != input_string.charAt(i)){
                System.out.println("PUT : "+input_string.charAt(i-1)+"!="+input_string.charAt(i));
                map.put(input_string.charAt(i), addMapCnt(map, input_string.charAt(i)));
            }else{
                System.out.println("SKP : "+input_string.charAt(i-1)+"=="+input_string.charAt(i));
            }

        }

        System.out.println("map : "+map);

        ArrayList<Character> list = new ArrayList<Character>();

        Set<Character> set = map.keySet();
        Iterator<Character> ite = set.iterator();
        while(ite.hasNext()){
            char c = ite.next();
            if(map.get(c)>= 2)
                list.add(c);
        }
        
        Collections.sort(list);
        for(char c : list)
            answer += c;
        if(answer.length() ==0)
            answer = "N";

        return answer;
    }    
    int addMapCnt(Map<Character, Integer> map, char c){
        if(map.containsKey(c)){
            return map.get(c)+1;
        }else{
            return 1;
        }

    }
}
