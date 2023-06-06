import java.util.*;
import java.io.*;

public class Inf010HashClassLeader{

    public static void main(String[] args){
        String str = "BACBACCACCBDEDE";
        int N = 15;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf010HashClassLeader().solution(str, N);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N){
        StringBuilder buff = new StringBuilder();

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        char stu = ' '; int max = 0;

        Iterator<Character> ite = map.keySet().iterator();
        while(ite.hasNext()){
            char c = ite.next();
            if(map.get(c) > max){
                stu = c;
                max = map.get(c);
            }
        }
        buff.append(stu);


        
        return buff.toString().trim();
    }

}