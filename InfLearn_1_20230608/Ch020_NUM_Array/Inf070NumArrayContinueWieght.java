import java.util.*;
import java.io.*;

public class Inf070NumArrayContinueWieght{

    public static void main(String[] args){
        int N = 10;
        String str = "1 0 1 1 1 0 0 1 1 0";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf070NumArrayContinueWieght().solution(N, str);
        System.out.println(rtn);
    }
    
    private String solution(int N, String str){
        StringBuilder buff = new StringBuilder();
        char[] arr = str.replaceAll(" ", "").toCharArray();
        int num = 0;
        int p = 0;
        for(char c : arr){
            if(c=='1')
                p++;
            else
                p=0;
            num += p;
        }

        buff.append(num);
        return buff.toString();
    }

}