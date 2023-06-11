import java.util.*;
import java.io.*;

public class Inf010BfsTreeMinLastChild{

    public static void main(String[] args){
        String str = "";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf010BfsTreeMinLastChild().solution(str);
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
        
        int minLastChildPath = bfs(root);
        buff.append(minLastChildPath);
        return buff.toString();
    }

    int bfs(Node root){
        int lv = 0;
        Queue<Node> Q = new LinkedList<Node>();
        Q.offer(root);

        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                Node node = Q.poll();
                if(node.lt == null && node.rt == null) return lv;

                Q.offer(node.lt);
                Q.offer(node.rt);
            }
            lv++;
        }

        return lv;
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