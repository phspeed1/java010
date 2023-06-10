import java.util.*;
import java.io.*;

public class Inf010Recursive{

    public static void main(String[] args){
        int N = 3;
        String str = "";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str);
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf010Recursive().solution(N);
        System.out.println(rtn);
    }
    
    private String solution(int N){
        StringBuilder buff = new StringBuilder();
        recursivePrintNum(N, N, buff);
        return buff.toString().trim();
   }

   void recursivePrintNum(int N, int x, StringBuilder buff){
    if(x < 1) return;

        recursivePrintNum(N, x-1, buff);
        buff.append(" "+x);
   }

}