import java.util.*;
import java.io.*;

public class Inf100ArrayUpDownLeftRight{

    public static void main(String[] args){
        int N = 5;
        String[] strArr;
        String str = "";
        strArr = new String[N];
        strArr[0] = "5 3 7 2 3";
        strArr[1] = "3 7 1 6 1";
        strArr[2] = "7 2 5 3 4";
        strArr[3] = "4 3 6 4 1";
        strArr[4] = "8 7 3 5 2";
        
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
    
        String rtn = new Inf100ArrayUpDownLeftRight().solution(N, strArr);
        System.out.println(rtn);
    }
    
    private String solution(int N, String[] strArr){
        StringBuilder buff = new StringBuilder();
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++){
            String[] sr = strArr[i].split(" ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(sr[j]);
            }
        }

        // 초기화 End
        //////////////////////////////////////
        int cnt = 0;
        int[][] ards = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        final int X=0, Y=1;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                boolean pyk = true;
                for(int[] ard:ards ){
                    int nx = i+ard[X];
                    int ny = j+ard[Y];
                    if(0 <= nx && nx < N && 0 <= ny && ny < N )
                    {
                        if(arr[i][j] <= arr[nx][ny]){
                            pyk = false;
                        }
                    }
                }
                if(pyk){
                    cnt++;
//                    System.out.println("["+i+"]["+j+"]");
                }
            }
        }
        buff.append(cnt);
    
        return buff.toString().trim();
    }

}