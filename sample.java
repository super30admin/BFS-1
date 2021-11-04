// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// level order traversal

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
    
    List<List<Integer>> result;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
//         List<List<Integer>> result = new ArrayList<>();
        
//         if(root==null){
//             return result;
//         }
        
        
        
//         Queue<TreeNode> q = new LinkedList<>();
        
//         q.add(root);   //1st root node added 
        
//         while(!q.isEmpty()){
            
//             int size = q.size();
            
            
//             List currentLevel = new ArrayList<>();
            
//             for(int i=0; i<size; i++){
                
//                 TreeNode out = q.poll();
                
//                 currentLevel.add(out.val);
                
//                 if(out.left!=null){
//                     q.add(out.left);
//                 }
//                 if(out.right!=null){
//                     q.add(out.right);
//                 }
                
//             }
            
//             result.add(currentLevel);                                    
            
//         }
        
//         return result;
        
        result = new ArrayList<>();
        
        // first level is 1
        
        dfs(root,1);
        return result;
        
    }
    
    private void dfs(TreeNode root, int level){
        
        if(root==null){
            return;
        }
        
        // new level encountered so first left appended into list
        
        if(level>result.size()){
            result.add(new ArrayList<>());
        }
        
        result.get(level-1).add(root.val);  // level - 1 is because result list is 0-indexed
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        
        
    }
}

// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// scheduling courses

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] dependency = new int[numCourses];
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i<numCourses;i++){
            dependency[i]=0;
        }
        
        for(int i = 0; i<prerequisites.length;i++){
            dependency[prerequisites[i][0]]++;
        }
        
        for(int i = 0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i<prerequisites.length;i++){
            
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        // add independent courses
        
        for(int i=0; i<numCourses;i++){
            
            if(dependency[i]==0){
                q.add(i);
            }
            
        }
        
        while(!q.isEmpty()){
            
            int currSub = q.poll();
            
            List<Integer> dependencySub = adjList.get(currSub);
            
            for(int i = 0; i<dependencySub.size();i++){
                
                dependency[dependencySub.get(i)]--;
                
                if(dependency[dependencySub.get(i)]==0){
                    q.add(dependencySub.get(i));
                }
                
            }
            
        }
        
        for(int i=0;i<numCourses;i++){
            if(dependency[i]!=0){
                return false;
            }
        }
        
        return true;
        
    }
}



