/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     List<List<Integer>>result;
    public List<List<Integer>> levelOrder(TreeNode root) {
   result = new ArrayList<>();
   if(root == null) return result;

   dfs(root,0);
   return result;
       
    }
    private void dfs(TreeNode root, int depth){

        //base
       if(root == null) return;

        //logic
        int size = result.size();

        if(size == depth){
            
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);

        dfs(root.left,depth+1);
        dfs(root.right,depth+1);

    }

}


						//	BFS																			
																										
		// 		 Queue<TreeNode> q = new LinkedList<>();
        // List<List<Integer>> result = new ArrayList<>();
        // if(root == null) return result;

        // q.add(root);
        
        

        // while(!q.isEmpty()){
        //     int size = q.size();
        //     List<Integer>list = new ArrayList<>();
        //     for(int i = 0; i< size; i++){
        //     TreeNode curr = q.poll();
            
        //     list.add(curr.val);
        //     if(curr.left != null) q.add(curr.left);
        //     if(curr.right != null) q.add(curr.right);
        //       }
        //       result.add(list);
        // }
        //    return result;

/***
BFS
TC - O(n) - Traversing all the nodes.
SC - O(n/2) - O(n) - Storing width of nodes inside queue, which is leaf node n/2.

Approach : 

1. In Breadth Firt search we will take all nodes at a time. 
2. By maintaining size we can classify distinct elements. By size we can know the level. 
3. So, Creating new list at each level and storing values and adding this list into result list. 

 
/***
DFS
TC - O(n) - Traversing all the nodes.
SC - O(H) - Storing Height of the tree nodes insisde stack

Approach : 

1. In Depth first approach we will visit each node at a time. 
2. Maintaining Depth at each level and comparing with result size. if depth and result size are equal the creating on list and geting that index of list inside array and adding value.
3. If we depth and result size is not equal the we will add value by getting index. 
4. Returing the result.



 */