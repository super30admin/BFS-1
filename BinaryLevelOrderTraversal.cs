// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


// BFS approach
// 	2) Add the root in queue
// Based on size of queue run the loop, because number of elements will give you the level of tree, so that u know when to create new list and add element.
List<IList<int>> result = new List<IList<int>>();
public IList<IList<int>> LevelOrder(TreeNode root) {
        
    if(root == null)
        return result;
    
    Queue<TreeNode> queue = new Queue<TreeNode>();
    queue.Enqueue(root);
    
    while(queue.Count > 0)
    {
        int size = queue.Count;
        List<int> curr = new List<int>();
        for(int i = 0; i < size; i++)
        {
            TreeNode node = queue.Dequeue();
            if(node.left != null)
                queue.Enqueue(node.left); 
            if(node.right != null)
                queue.Enqueue(node.right); 
            curr.Add(node.val);
        }
        result.Add(curr);
    }
    return result;
}


//DFS 
//O(n), O(h)
public IList<IList<int>> LevelOrder(TreeNode root) {
        
    if(root == null)
        return result;
    
    dfs(root, 0);
    return result;
}

//calls dfs recursively at every time send level+1
//when going child node left or right, we increment the level
//that way we know to cretae list or add elemeent in existing result
private void dfs(TreeNode root, int level)
{
    //base condition
    if(root == null)
        return;
    
    //logic
    if(level == result.Count)
        result.Add(new List<int>(){root.val});
    else
        result[level].Add(root.val);
    dfs(root.left, level+1);
    dfs(root.right, level+1);
}