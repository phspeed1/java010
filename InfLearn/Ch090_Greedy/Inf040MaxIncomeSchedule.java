import java.util.*;
import java.io.*;

public class Inf040MaxIncomeSchedule{

    public static void main(String[] args){
        int N = 6;
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
    
        String rtn = new Inf040MaxIncomeSchedule().solution(N, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int[][] arr){
        StringBuilder buff = new StringBuilder();
        List<Lecture> list = new ArrayList<Lecture>();
        int maxDays = 0;
        for(int i=0; i<N; i++){
            list.add(new Lecture(arr[i][0], arr[i][1]));
            maxDays = Math.max(maxDays, arr[i][1]);
        }
        Collections.sort(list);
 //       System.out.println(list);

        int answer = 0;
        int days = maxDays;
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int j=0;
        for(int i=maxDays; i>=1; i--){

            for( ; j<N; j++){
                if(list.get(j).days < i) break;
                pQ.offer(list.get(j).income);
            }
            if(pQ.size() >0)
               answer += pQ.poll();

        }
//        if(pQ.size() >0)
  //          answer += pQ.poll();

        buff.append(answer);
        return buff.toString();
    }

    class Lecture implements Comparable<Lecture>{
        int income;
        int days;
        Lecture(int income, int days){
            this.income = income;
            this.days = days;
        }
        public int compareTo(Lecture o){
            if(this.days == o.days && this.income == o.income) return 0;
            if(this.days == o.days){
                return o.income - this.income;
            }
            return o.days - this.days;
        }
        public String toString(){
            return "{income:"+this.income+", days:"+this.days+"}";
        }
    }

}