// Time Complexity :O(n)
// Space Complexity :O(n/2) or O(n) n = leaf nodes
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for(int i = 0 ;i < size;i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            
            result.add(temp);
        }
        
        return result;
    }
}

// Time Complexity :O(n)
// Space Complexity :O(n/2) or O(n) n = leaf nodes
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
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
     result = new ArrayList<>();
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int level){
        int size = result.size();
        if(root == null) return;
        if(size == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
//         if(size > level){

//         }
        helper(root.left,level+1);
        helper(root.right,level+1);
        
    }
}

// Time Complexity :O(v+e)
// Space Complexity :O(v+e) v = vertices e = edges;
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
   
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int [] indgrees = new int[numCourses];
        for(int[] edge :prerequisites){
            indgrees[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i =0;i<indgrees.length;i++){
            if(indgrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int course = q.remove();
            List<Integer> chlidren = map.get(course);
            if(chlidren != null){
                for(int child : chlidren){
                    indgrees[child]--;
                    if(indgrees[child] == 0){
                        q.add(child);
                        count ++;
                    }
                }
            }
        }
          return count == numCourses;
    
        
    }
}
