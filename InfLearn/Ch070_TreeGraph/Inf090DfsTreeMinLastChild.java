import java.util.*;
import java.io.*;

public class Inf090DfsTreeMinLastChild{

    public static void main(String[] args){
        String str = "";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf090DfsTreeMinLastChild().solution(str);
        System.out.println(rtn);
    }
    
    Node root;
    private String solution(String str){
        StringBuilder buff = new StringBuilder();
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        

        return buff.toString();
    }


    class Node implements Comparable<Node>{
        int val;
        Node lt;
        Node rt;
        boolean visited;
        Node(int val){
            this.val = val;
            lt = rt = null;
            visited = false;
        }
        public int compareTo(Node other){
            return this.val - other.val;
        }
    }

}