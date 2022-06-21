//Time Complexity for recursive sol: o(n)
//Space Complxity for recursive sol: o(1) 
//https://leetcode.com/problems/binary-tree-level-order-traversal/


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
        if(null == root) return result;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int level){
        if(null == root) return;
        if(result.size() == level){
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            result.add(list);
        } else{
            result.get(level).add(root.val);
        }
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(null == root){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(null != node.left) queue.add(node.left);
                if(null != node.right) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
        
    }
    */
}

//------------------------------------------------
//Time Complexity: o(v+e)
//Space Complexity:o(v+e)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        
        int [] indegrees = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int[] edgs: prerequisites) {
            indegrees[edgs[0]]++;
            if(!map.containsKey(edgs[1])){
                map.put(edgs[1], new ArrayList());
            }
            map.get(edgs[1]).add(edgs[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0) {
                queue.add(i);
                //count edgs that you are pushing inside queue
                count++;
            }
        }
        
        while(!queue.isEmpty()){
            int edg = queue.poll();
            List<Integer> dependencies = map.get(edg);
            if(null != dependencies && !dependencies.isEmpty()){
                for(int dependency: dependencies){
                    indegrees[dependency]--;
                    if(indegrees[dependency] == 0){
                        queue.add(dependency);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
        
        return false;
    }
}