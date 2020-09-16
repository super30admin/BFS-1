//Time Complexity: O(n)
//Space Complexity: O(n) -> for queue
//Did it run on leetcode: yes
//Problems faced any: No

import java.util.*;
public class Problem59 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(i==size-1)
                    list.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }

        return list;
    }
}
