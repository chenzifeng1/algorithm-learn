package data_structure;

/**
 * @ProjectName: spring-security
 * @ClassName: DoubleNode
 * @Author: czf
 * @Description: 节点类 双向列表
 * @Date: 2021/3/4 23:16
 * @Version: 1.0
 **/

public class DoubleNode<T> {

    private T value;
    public DoubleNode<T> last;
    public DoubleNode<T> next;

    public DoubleNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
