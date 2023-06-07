import java.util.*;
import java.io.*;

public class Inf060Queue{

    public static void main(String[] args){
        int N = 8; //7
        int K = 3;
        N = 20; // 20
        // String str = "";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     String[] arr = str.split(" ");
        //     N = Integer.parseInt(arr[0]); 
        //     K = Integer.parseInt(arr[1]); 
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        int rtn = new Inf060Queue().solution(N, K);
        System.out.println(rtn);
    }
    
    private int solution(int N, int K){
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=1; i<=N; i++) queue.add(i);

        int i=0;
        while(queue.size() != 1){
            i++;
            if(i%K == 0){
                int pp = queue.poll();
                System.out.println("remove["+pp+"]"+queue);
            }else{
                queue.offer(queue.poll());
            }
        
        }
        return queue.poll();
    }

}