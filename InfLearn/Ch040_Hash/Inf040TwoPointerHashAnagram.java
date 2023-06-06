import java.util.*;
import java.io.*;

public class Inf040TwoPointerHashAnagram{

    public static void main(String[] args){
        String str = "bacaAacba";
        String s = "abc";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            s = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf040TwoPointerHashAnagram().solution(str, s);
        System.out.println(rtn);
    }
    
    private String solution(String str, String s){
        StringBuilder buff = new StringBuilder();
        int answer = 0;
        Map<Character, Integer> hash = new HashMap<Character, Integer>();
        int K = s.length();
        for(char c : s.toCharArray()){
            hash.put(c, hash.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int lt = 0;
        int N = str.length();

        for(int rt=0; rt < N; rt++){
            char c = str.charAt(rt);
            map.put(c, map.getOrDefault(c, 0)+1);

            if(rt < K-1) continue;

            // boolean isAna = true;
            // for(char h : hash.keySet()){
            //     if(!map.containsKey(h) || hash.get(h) != map.get(h))
            //         isAna = false;
            // }
            // if(isAna) answer++;
            if(map.equals(hash)) answer++;

            char x = str.charAt(lt);
            map.put(x, map.get(x)-1);
            if(map.get(x) == 0) map.remove(x);
            lt++;
        }

        buff.append(answer);
        return buff.toString();
    }

}