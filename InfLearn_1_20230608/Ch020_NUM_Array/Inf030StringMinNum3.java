import java.util.*;
import java.io.*;

public class Inf030StringMinNum3{

    public static void main(String[] args){
        int N = 0;
        int[][] arr = null;
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            arr = new int[2][N];
            for(int i=0; i<2; i++){
                str = br.readLine();
                String[] sArr = str.split(" ");
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(sArr[j]);
                }
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf030StringMinNum3().solution(N, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int[][] arr){
        StringBuilder buff = new StringBuilder();

        for(int i=0; i<N; i++){
            if(arr[0][i] == arr[1][i]){
                buff.append("D\n");
            }else if(arr[0][i] == 1 && arr[1][i] == 3){
                buff.append("A\n");
            }else if(arr[0][i] == 2 && arr[1][i] == 1){
                buff.append("A\n");
            }else if(arr[0][i] == 3 && arr[1][i] == 2){
                buff.append("A\n");
            }else{
                buff.append("B\n");
            }
        }
        
        return buff.toString().trim();
    }

}