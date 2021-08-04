package dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName:
 * @ClassName: Test
 * @Author: czf
 * @Description:
 * @Date: 2021/7/18 9:15
 * @Version: 1.0
 **/

public class Test {
    static class Node {
        int id;
        int parentId;
        String name;

        public Node(int id, int parentId, String name) 				{
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Node> nodeList = Arrays.asList(
                new Node(1, 0, "AA"),
                new Node(2, 1, "BB"),
                new Node(3, 1, "CC"),
                new Node(4, 3, "DD"),
                new Node(5, 3, "EE"),
                new Node(6, 2, "FF"),
                new Node(7, 2, "GG"),
                new Node(8, 4, "HH"),
                new Node(9, 5, "II"),
                new Node(10, 0, "JJ"),
                new Node(11, 10, "KK"),
                new Node(12, 10, "LL"),
                new Node(13, 12, "MM"),
                new Node(14, 13, "NN"),
                new Node(15, 14, "OO")
        );
        print(nodeList);

    }

    public static void print(List<Node> nodeList) {
        //todo
        // TreeMap<Integer,List<Node>> map = new TreeMap();

        printD(nodeList,0,0);

    }

    public static void printD(List<Node> nodeList,int pid,int d) {
        for(Node n : nodeList){
            if(n.parentId==pid){
                String temp = "";
                for(int i=0;i<d;i++)
                    temp+="  ";
                System.out.println(temp+n.name);
                printD(nodeList,n.id,d+1);
            }
        }
    }
}
