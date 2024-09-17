//Time Complexity: O(n) -> num of nodes
//Space Complexity: O(n) -> basically the diameter of tree which is for queue
//Did it run on leetcode: yes
//Problems faced any: No

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem55 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();

        while(!queue.isEmpty()){
            //A temp list to add values of each level
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }

            list.add(temp);

        }
        return list;
    }
}
