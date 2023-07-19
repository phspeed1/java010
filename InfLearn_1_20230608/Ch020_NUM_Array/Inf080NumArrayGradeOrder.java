import java.util.*;
import java.io.*;

public class Inf080NumArrayGradeOrder{

    public static void main(String[] args){
        int N = 6;
        String str = "87 89 92 100 76";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf080NumArrayGradeOrder().solution(N, str);
        System.out.println(rtn);
    }
    
    private String solution(int N, String str){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arrInp = new int[strArr.length];
        int[] arrSort = new int[strArr.length+1];
        int[] arrGrade = new int[strArr.length];
        for(int i=0; i<strArr.length; i++){
            arrInp[i] = Integer.parseInt(strArr[i]);
            arrSort[i] = arrInp[i];
        }
        arrSort[arrSort.length-1] = -100001;
        Arrays.sort(arrSort);
        int grade = 1;
        int p = -100002;
        for(int i=arrSort.length-1; i>=0; i--){
            if(arrSort[i] != p){
                for(int j=0; j<arrInp.length; j++){
                    if(arrSort[i] == arrInp[j])
                        arrGrade[j] = grade;
                }
            }
            p = arrSort[i];
            grade++;
        }
        for(int g : arrGrade){
            buff.append(" "+g);
        }


        return buff.toString().trim();
    }

}