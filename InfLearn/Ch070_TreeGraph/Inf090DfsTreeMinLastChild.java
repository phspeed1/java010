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
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        
        int minLastChildPath = dfs(root, 0);
        buff.append(minLastChildPath);
        return buff.toString();
    }

    int dfs(Node root, int lev){
        if(root.rt == null && root.lt == null)
            return lev;
        return Math.min(dfs(root.lt, lev+1), dfs(root.rt, lev+1));

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