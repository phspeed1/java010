import java.util.*;
import java.io.*;

public class Inf060LinkedList{

    public static void main(String[] args){
        int N = 8; //7
        int K = 3;
      //  N = 20; // 20
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            String[] arr = str.split(" ");
            N = Integer.parseInt(arr[0]); 
            K = Integer.parseInt(arr[1]); 
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        int rtn = new Inf060LinkedList().solution(N, K);
        System.out.println(rtn);
    }
    
    private int solution(int N, int K){
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i=1; i<=N; i++) list.add(i);

        int cnt = 0;
        int i = 0;
        while(list.size() != 1){
            cnt++;
            if(cnt == K){
          //      System.out.println("["+list.get(i)+"]"+list);
                list.remove(i);
                cnt = 0;
            }else{
                i++;
            }
            if(i>=list.size()) i = 0;
        }

        return list.get(0);
    }

}