import java.util.*;
import java.io.*;

public class Inf080Queue{

    public static void main(String[] args){
        int N = 5;
        int M = 2;
        String str = "60 50 70 80 90";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            String[] arr = str.split(" ");
            N = Integer.parseInt(arr[0]); 
            M = Integer.parseInt(arr[1]); 
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        int rtn = new Inf080Queue().solution(N, M, str);
        System.out.println(rtn);
    }
    
    private int solution(int N, int M, String str){
        int answer = 0;
        Queue<Student> queue = new LinkedList<Student>();
        String[] arr = str.split(" ");

        Student aStu = null;
        for(int i=0; i<N; i++){
            Student stu = new Student(i, Integer.parseInt(arr[i]));
            if(i == M) aStu = stu;
            queue.add(stu);
        }

        while(!queue.isEmpty()){
        //    System.out.println(queue);
            Student stu = queue.poll();
            answer++;
            if(needYeild(queue, stu)){
                answer--;
                queue.offer(stu);
            }else if(stu.no == M){
                return answer;
            }

        }
        return answer;
    }

    boolean needYeild(Queue<Student> queue, Student stu){
        for(int i=0; i<queue.size(); i++){
            Iterator<Student> ite = queue.iterator();
            while(ite.hasNext()){
                if(ite.next().prioty > stu.prioty)
                    return true;
            }
        }
        return false;
    }

    class Student{
        int no;
        int prioty;
        Student(int no, int prioty){
            this.no = no;
            this.prioty = prioty;
        }
        public String toString(){
            return "{["+this.no+"]"+this.prioty+"}";
        }
    }

}