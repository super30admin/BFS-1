//binary-tree-level-order-traversal using BFS
//TC:O(n)..traverse through all the nodes
//SC:O(n)..max width of tree ->max no of leaf nodes->n/2
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //use BFS and Queue for level order traversal
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size(); //get the size of nodes at that level
            //we need size to process all nodes at that particular level
            //store nodes at one level to li
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();

                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
                li.add(curr.val);
            } //end of one level , add nodes collected from that level to main list
            result.add(li);

        }
        return result;
    }
}