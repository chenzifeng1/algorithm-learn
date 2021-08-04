package data_structure;

import java.util.Random;

/**
 * @ProjectName: spring-security
 * @ClassName: Node
 * @Author: czf
 * @Description: 节点类  单向列表
 * @Date: 2021/3/4 23:15
 * @Version: 1.0
 **/

public class Node<T> {
    /**
     *
     */
    private T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    public Node<Integer> randomLinkNode(int size,int maxValue){
        Random random = new Random();
        Node<Integer>  root = new Node<Integer>(random.nextInt(maxValue));
        Node<Integer> temp = root;
        for (int i = 0; i < size-1; i++) {
            Node<Integer> newNode = new Node<Integer>(random.nextInt(maxValue));
            temp.next = newNode;
            temp = newNode;
        }
        return root;
    }

}
