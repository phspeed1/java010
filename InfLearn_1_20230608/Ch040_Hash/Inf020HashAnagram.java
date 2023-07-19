import java.util.*;
import java.io.*;

public class Inf020HashAnagram{

    public static void main(String[] args){
        String str = "AbaAeCe";
        String str2 = "baeeACA";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            str2 = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf020HashAnagram().solution(str, str2);
        System.out.println(rtn);
    }
    
    private String solution(String str1, String str2){
        StringBuilder buff = new StringBuilder();
        if(str1.length() != str2.length()) return "NO";

        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();

        for(char c : str1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        for(char c : str2.toCharArray()){
            // map2.put(c, map2.getOrDefault(c, 0)+1);
            if(!map1.containsKey(c) || map1.get(c) == 0) return "NO";
            map1.put(c, map1.get(c) -1);
        }
        // for(char c : map1.keySet()){
        //     if(map1.get(c) !=0 ) return "NO";
        // }


        // if(map1.size() != map2.size()) return "NO";
        // int N = map1.size();
        // for(char k1 : map1.keySet()){
        //     int v1 = map1.get(k1);
        //     if(!map2.containsKey(k1)) return "NO";
        //     if(v1 != map2.get(k1)) return "NO";
        // }
        
        return "YES";
    }

}