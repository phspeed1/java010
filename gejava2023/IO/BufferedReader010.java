
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class BufferedReader010{

    public static void main(String[] args){
        String str = "This is hello world 1.5 ";
        System.out.println("input : "+str);
    
//        new BufferedReader010().solution(str);
//        new BufferedReader010().test(str);
//        new BufferedReader010().testArrays();
//        new BufferedReader010().dfsbfs();
//        new BufferedReader010().compareTest();
        new BufferedReader010().test2();

 //       System.out.println("output : "+str);
    }
    
    void solution(String str){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("값을 입력하세요.");
            String inpStr = br.readLine();
            System.out.println("입력한 값은 : "+inpStr+"입니다.");

            StringTokenizer st = new StringTokenizer(inpStr, " ");
            System.out.println("countTokens : "+st.countTokens());
            while(st.hasMoreElements()){
                System.out.println(st.nextToken());
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void test(String str){
        List<String> list = new ArrayList<String>();

        list.add("2");
        list.add("1");
        list.add("3");
        list.add("1.5");

        System.out.println("-1 list : "+list);
        Collections.sort(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("-2 list : "+list);
        Iterator<String> ite = list.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }

        String[] strArr = str.split(" ");
        Arrays.sort(strArr);
        int isIndex = Arrays.binarySearch(strArr, "is");
        System.out.println("strArr : "+Arrays.toString(strArr));
        System.out.println("isIndex : "+isIndex);
    }

    void testArrays(){
        String arr[] = {"10", "1", "8", "4", "11", "2", "3", "0"};
        System.out.println(""+Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println("Arrays.sort : "+Arrays.toString(arr));

        int idx4 = Arrays.binarySearch(arr,"4");
        System.out.println("Arrays.binarySearch(4) : "+idx4);

        List<String> list = Arrays.asList(arr);
        System.out.println("Arrays.asList(4) : "+list);

        String[] subArr = Arrays.copyOf(arr, 4);
        System.out.println("Arrays.copyOf(4) : "+Arrays.toString(subArr));

        String[] subArr2 = Arrays.copyOfRange(arr, 2, 5);
        System.out.println("Arrays.copyOf(4) : "+Arrays.toString(subArr2));

        String[] strArr1 = "Hi, this is hello world, 2".split(",");
        System.out.println("String.split : "+Arrays.toString(strArr1));

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("java", 11);
        map.put("python", 3);
        map.put("C++", 2);

        map.put("javascript", map.getOrDefault("javascript", 6));
        map.put("java", map.getOrDefault("java", 6));
        System.out.println("map : "+map);
        for(String key : map.keySet()){
            System.out.println(key+" : "+map.get(key));
        }
    }


    private class Node{
        int x; int y; int dist;
        Node(int x, int y, int dist){
            this.x = x; this.y=y; this.dist=dist;
        }
    }

    void dfsbfs(){
        
        List<Node> list = new ArrayList<Node>();
        list.add(new Node(1, 1, 1));
        list.add(new Node(2, 2, 2));
        list.add(new Node(3, 3, 3));

        int[][] nodes = {{1}, {0, 2, 3}, {1, 4, 3}, {1, 2, 4, 5}, {2, 3}, {3, 6, 7}, {8, 5}, {5}, {6}};
    /*
     0
    /
    1--3   7
    |/ | \/
    2--4  5--6--8
     */
    // DFS : 0 1 2 4 3 5 6 8 7
    // BFS : 0 1 2 3 4 5 6 7 8
    
    System.out.println("nodes : "+Arrays.deepToString(nodes));

    boolean[] visited = new boolean[nodes.length];
    List<Integer> resList = new ArrayList<Integer>();
    dfs(nodes, 0, visited, resList);
    System.out.println("DFS : "+resList);

    resList = new ArrayList<Integer>();
    visited = new boolean[nodes.length];
    bfs(nodes, 0, visited, resList);
    System.out.println("BFS : "+resList);

    }

    void dfs(int[][] nodes, int node, boolean[] visited, List<Integer> resList){
        resList.add(node);
        visited[node] = true;

        for(int link : nodes[node]){
            if(!visited[link]){
                dfs(nodes, link, visited, resList);
            }
        }
    }

    void bfs(int[][] nodes, int startNode, boolean[] visited, List<Integer> resList){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(startNode);
        visited[startNode] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            resList.add(node);

            for(int link : nodes[node]){
                if(!visited[link]){
                    queue.offer(link);
                    visited[link] = true;
                }
            }

        }
    }
    

    void compareTest(){
        int[] intArr = {4, 2, 1, 3, 5};
        Integer[] integerArr = Arrays.stream(intArr).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArr, Collections.reverseOrder());
        System.out.println("Arrays.sort Collections.reverseOrder() : "+Arrays.toString(integerArr));
        
        int[] arr = Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();
        System.out.println("map to int : "+Arrays.toString(arr));

        List<Integer> arrList = Arrays.asList(integerArr);
        System.out.println("Arrays.asList : "+arrList);

        Integer[] integerArr4 = arrList.toArray(new Integer[arrList.size()]);
        System.out.println("List.toArray : "+Arrays.toString(integerArr4));
        int[] intArray4 = Arrays.stream(integerArr4).mapToInt(Integer::intValue).toArray();
        System.out.println("Arrays.toArray : "+Arrays.toString(intArray4));
        Integer[] integerArr41 = Arrays.stream(intArray4).boxed().toArray(Integer[]::new);
        System.out.println("boxed().toArray : "+Arrays.toString(integerArr41));

       // Integer[] integetArr2 = Arrays.stream(intArr).boxed().toArray(Integer[]::new);
       // int[] intArr2 = Arrays.stream(integetArr2).mapToInt(Integer::intValue).toArray();

       StuScore[] stuScores = new StuScore[5];
       stuScores[0] = new StuScore("A", 50, 90);
       stuScores[1] = new StuScore("B", 60, 50);
       stuScores[2] = new StuScore("C", 50, 50);
       stuScores[3] = new StuScore("D", 40, 50);
       stuScores[4] = new StuScore("E", 50, 10);
/*
       System.out.println("stuScores : "+Arrays.toString(stuScores));
       Arrays.sort(stuScores);
       System.out.println("Arrays.sort : "+Arrays.toString(stuScores));
       Arrays.sort(stuScores, Collections.reverseOrder());
       System.out.println("Arrays.reverseOrder : "+Arrays.toString(stuScores));
*/
        List<StuScore> stuList = Arrays.asList(stuScores);
        System.out.println("stuList : "+stuList);
/*        
        Collections.sort(stuList);
        System.out.println("Collections.sort : "+stuList);
        Collections.sort(stuList, Collections.reverseOrder());
        System.out.println("Collections.reverseOrder : "+stuList);

        System.out.println("StuScore.compareTo : "+stuScores[1].compareTo(stuScores[3]));
 */
        Queue<StuScore> pQue = new PriorityQueue<StuScore>();
        for(StuScore ss : stuScores){
            pQue.offer(ss);
        }
        System.out.println("pQue : "+pQue);
        while(!pQue.isEmpty()){
            System.out.println("pQue sort : "+pQue.poll());
        }

        StuScore[] part1 = Arrays.copyOfRange(stuScores, 1, stuScores.length -1);
        System.out.println("Arrays.copyOf : "+Arrays.toString(part1));

        int[] testArr = {5, 3, 4, 1, 3, 2};
        System.out.println("testArr : "+Arrays.toString(testArr));
        int sum = Arrays.stream(testArr).sum();
        System.out.println("Arrays.sum() : "+sum);
        int[] stestArr2 = Arrays.stream(testArr).distinct().toArray();
        System.out.println("Arrays.distinct() : "+Arrays.toString(stestArr2));

    }

    class StuScore implements Comparable<StuScore>{
        String name;
        int eng;
        int math;
        StuScore(String name, int eng, int math){
            this.name = name;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public String toString(){
            return("\n{name:"+name+", eng:"+eng+", math:"+math+"}");
        }

        @Override
        public int compareTo(StuScore otherStuScore){
            if(this.eng > otherStuScore.eng)
                return -1;
            if(this.eng == otherStuScore.eng && this.math > otherStuScore.math)
                return -1;
            return 1;
        }


    }

    void test2(){
        List<String> list = new ArrayList<String>(Arrays.asList("C", "B", "A", "B", "a"));
        System.out.println("list : "+list);

        Collections.sort(list);
        System.out.println("Collections.sort : "+list);

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println("String.CASE_INSENSITIVE_ORDER : "+list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Collections.reverseOrder : "+list);

        Collections.sort(list, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));        
        System.out.println("reverseOrder.CASE_INSENSITIVE_ORDER : "+list);

        List<String> dList = list.stream().distinct().collect(Collectors.toList());
        System.out.println("distinct() : "+dList);

        List<String> aList = new ArrayList<String>();
        aList.addAll(list);
        System.out.println("aList : "+aList);

        List<String> subList = list.subList(1, list.size()-1);
        System.out.println("subList : "+subList);

        System.out.println("MIN : "+Collections.min(list)+", MAX : "+Collections.max(list));



    }


}
