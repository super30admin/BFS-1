// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
 //BFS: We will create a queue and add the nodes from the tree in preorder manner, which has a sequence of Root, Left and right. 
 //We will check the number of nodes in each level, by adding the nodes in the queue and popping them into the inner list. Whenever a level is complete, we add this to the final result list.

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            //to check the number of nodes in a level
            int size=q.size();
            //creating a new inner list for every level
            List<Integer> li=new ArrayList<>();
            //level with the size of the queue
            for(int i=0;i<size;i++)
            {
                //we pop the first element of the queue: FIFO
                TreeNode curr=q.poll();
                //If there are children on the left, then they are added to the queue
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                //If there are children on the right, then they are added to the queue
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
                //The popped value is added to the inner list
                li.add(curr.val);
            }
            //inner list is added to the final result after every level
            result.add(li);
        }
        return result;
    }
}

//DFS: We will create a list of list and consider its indices as the level/height of each node. We will check if the size of the List is equal to the level, then we have still not covered all the levels yet. 
 //When this happens, we add a new list in the final list. We do this for each level, then we check if the level is already present, if yes, then we add the element to the respective one.

 class Solution {
    List<List<Integer>> result=new ArrayList<>();
public List<List<Integer>> levelOrder(TreeNode root) {

//We are doing recursion using the root and the level
dfs(root,0);
return result;
}
private void dfs(TreeNode root, int height)
{
if(root==null) return;
if(height==result.size())
{
    result.add(new ArrayList<>());
}
//Adding the root value for the particular level/index
result.get(height).add(root.val);
dfs(root.left,height+1);
dfs(root.right,height+1);
}

}