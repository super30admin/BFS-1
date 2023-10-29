//BFS Solution using Queue
// when traversing each level of the tree, add the node to the queue
//add all the curr nodes left and right child and add to final result list
//return the result 

//TC: O(n)
//SC:O(n)
//works on leetcode

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return result;


        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            result.add(li);
        }

    return result;
    }
}


//DFS 
// we can scan depth of the array
// and in a hashset then keep adding the values
// take the list of the hashset, and if the level + 1 exist, add to it
// else create a new list and add to it

//TC: O(h)
//SC: O(n)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    
    public void helper(TreeNode root, int level)
    {

        //base
        if(root == null) return;
        //logic
        if(level == result.size())
        {
            result.add(new ArrayList<>());
        }
        helper(root.left, level+1);
        helper(root.right, level+1);
        result.get(level).add(root.val);

    }
}
