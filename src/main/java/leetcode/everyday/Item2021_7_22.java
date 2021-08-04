package leetcode.everyday;

/**
 * @ProjectName:
 * @ClassName: Item2021_7_22
 * @Author: czf
 * @Description: 每日一题
 * @Date: 2021/7/22 23:21
 * @Version: 1.0
 **/

public class Item2021_7_22 {

    public static void main(String[] args) {
        //[7,null],[13,0],[11,4],[10,2],[1,0]


    }

    public Node copyRandomList(Node head) {
        return null;
    }


    public static Node test1(Node head) {
        if (head == null) {
            return null;
        }

        Node newNode = new Node(head.val);
        Node newNodeHead = newNode;
        Node last = head;
        Node next = head.next;
        while (last.next != null) {
            last = last.next;
            next = last.next;
            Node temp = new Node(last.val);
            newNode.next = temp;
        }

        return newNodeHead;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
