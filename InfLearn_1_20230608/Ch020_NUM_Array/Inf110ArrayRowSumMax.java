import java.util.*;
import java.io.*;

public class Inf110ArrayRowSumMax{

    public static void main(String[] args){
        int N = 6;
        String[] strArr;
        String str = "";
        strArr = new String[N];
        strArr[0] = "2 3 1 7 3";
        strArr[1] = "4 1 9 6 8";
        strArr[2] = "5 5 2 4 4";
        strArr[3] = "6 5 2 6 7";
        strArr[4] = "8 4 2 2 2";
        strArr[5] = "8 4 2 2 2";
        
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str);
        //     strArr = new String[N];
        //     for(int i=0; i<N; i++){
        //         str = br.readLine();
        //         strArr[i] = str;
        //     }
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf110ArrayRowSumMax().solution(N, strArr);
        System.out.println(rtn);
    }
    
    private String solution(int N, String[] strArr){
        StringBuilder buff = new StringBuilder();
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++){
            String[] sr = strArr[i].split(" ");
            for(int j=0; j<sr.length; j++){
                arr[i][j] = Integer.parseInt(sr[j]);
            }
        }

        // 초기화 End
        //////////////////////////////////////
        int clsCnt;
        int maxStuNo = 0;
        int maxClsCnt = 0;

        for(int i=0; i<N; i++){
            clsCnt = 0;
            for(int j=0; j<5; j++){
                int cls = arr[i][j];
                for(int k=0; k<N; k++){
                    if(k==i)
                        continue;
                    if(arr[k][j] == cls)
                        clsCnt++;
                }
            }
            if(clsCnt > maxClsCnt){
                maxClsCnt = clsCnt;
                maxStuNo = i;
            }
        }
        buff.append(maxStuNo+1);
    
        return buff.toString().trim();
    }

}