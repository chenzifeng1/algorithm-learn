package leetcode.stack;

import java.util.*;

/**
 * @ProjectName:
 * @ClassName: Statck_103
 * @Author: czf
 * @Description: 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回锯齿形层序遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * @Date: 2021/5/27 22:08
 * @Version: 1.0
 **/

public class Statck_103 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //栈1
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Boolean isOrder = true;

        queue.offer(root);
        while (queue.size() > 0){
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode poll = queue.poll();
                if(!isOrder){
                    deque.addFirst(poll.val);
                }else {
                    deque.addLast(poll.val);
                }
                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }

            }
            result.add(new LinkedList<>(deque));
            isOrder=!isOrder;
        }

        return result;

    }


    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }

}
