import java.util.*;
import java.io.*;

public class Inf010Gready{

    public static void main(String[] args){
        int N = 5;
        String str = "";
        int[][] arr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            arr = new int[N][2];
            for(int i=0; i<N; i++){
                str = br.readLine();
                arr[i][0] = Integer.parseInt(str.split(" ")[0]);
                arr[i][1] = Integer.parseInt(str.split(" ")[1]);
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf010Gready().solution(N, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int[][] arr){
        StringBuilder buff = new StringBuilder();
        int answer = N;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    answer--;
                    break;
                }
            }
        }

        buff.append(answer);
        return buff.toString();
    }

}