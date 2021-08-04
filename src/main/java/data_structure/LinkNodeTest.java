package data_structure;

/**
 * @ProjectName: spring-security
 * @ClassName: LinkNodeTest
 * @Author: czf
 * @Description: 链表基础 coding
 * @Date: 2021/3/4 23:20
 * @Version: 1.0
 **/

public class  LinkNodeTest<T> {

    /**
     * 单链表反转
     *
     * @param root 根节点
     */
    public Node<Integer> reversal(Node<Integer> root) {
        Node<Integer> pre = null;
        Node<Integer> next = null;
        while (root != null) {
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;

    }

    /**
     * 双向链表反转
     *
     * @param root 根节点
     */
    public DoubleNode<Integer> reversal(DoubleNode<Integer> root) {
        DoubleNode<Integer> pre = null;
        DoubleNode<Integer> next = null;
        while (root != null) {
            next = root.next;
            root.next = pre;
            root.last = next;
            pre = root;
            root = next;
        }
        return pre;
    }

    /**
     * 删除所有值为value的节点
     * @param head
     * @param value
     */
    public Node<T> deleteNode(Node<T> head,T value){
        if(head == null){
            return null;
        }
        while (head!=null&&value.equals(head.getValue())){
            head = head.next;
        }
        Node<T> last = head;
        Node<T> curr = head;
        while (curr != null) {
            if(value.equals(curr.getValue())){
                last.next = curr.next;
            }else {
                last = curr;
            }
            curr = curr.next;
        }
        return head;
    }

}
