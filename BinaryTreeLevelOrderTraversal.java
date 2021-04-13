/**
 *
 *  Time Complexity: O(N) Where N is the number of nodes in the tree.
 *  Space Complexity: O(N) Since in the worst case for BFS it would be the number of nodes in the lowest level which is N/2. When we use DFS if all the nodes have only one child it would cause the call stack size to be N.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  Explanation: If we are using BFS we can use a queue to hold all the element of each level in it. Then we can maintan the count of elements(cnt) in each level by checking the size of the queue when all the elements of the previous level are processed. Then we can process these elements (cnt) in this level and add these elements to the result list, along with adding all the child element to the queue. We repeat this till we complete all the elements in the queue. 
 */
class Solution {
    
    // BFS:  
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int level=1;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while(level>0){
                TreeNode node= queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);    
                level--;
            }
            result.add(list);
            level=queue.size();
        }
        return result;
    } 
    
    
    // DFS:
//     List<List<Integer>> result;
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         result = new ArrayList<>();
//         if(root==null) return result;
//         dfs(root,0);
//         return result;
//     }

//     private void dfs(TreeNode node, int level){
//         if(node==null) return;
//         if(result.size()==level){
//             List<Integer> list = new ArrayList<>();
//             list.add(node.val);
//             result.add(list);
//         }else{
//             List<Integer> list = result.get(level);
//             list.add(node.val);
//         }
//         if(node.left!=null) dfs(node.left,level+1);
//         if(node.right!=null) dfs(node.right,level+1);
//     }
        
}
