import java.util.*;
import java.io.*;

public class Inf111ArrayRowSumMax{

    public static void main(String[] args){
        int N = 4;
        String[] strArr;
        String str = "";
        strArr = new String[N];
        strArr[0] = "2 3 1 7 3";
        strArr[1] = "4 1 9 6 8";
        strArr[2] = "5 5 2 4 4";
        strArr[3] = "6 5 2 6 7";
  //      strArr[4] = "8 4 2 2 2";
 //       strArr[5] = "8 4 2 2 2";
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            strArr = new String[N];
            for(int i=0; i<N; i++){
                str = br.readLine();
                strArr[i] = str;
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf111ArrayRowSumMax().solution(N, strArr);
        System.out.println(rtn);
    }
    
    private String solution(int N, String[] strArr){
        StringBuilder buff = new StringBuilder();
        int[][] arr = new int[N][5];
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
            for(int j=0; j<N; j++){
                for(int k=0; k<5; k++){
                    if(arr[i][k] == arr[j][k]){
                        clsCnt++;
                        break; // 한번 같은반으로 체크한 학생은 다음 학년에 다시 카운트 할 필요가 없으므로 break
                    }
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