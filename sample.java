import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Binary Tree Level Order Traversal
//Time Complexity : O(N)
//Space Complexity : O(level nodes)
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
       while(!q.isEmpty()){
           //create new list
           List<Integer> level = new ArrayList<>();
           int size = q.size();
           for(int i = 0; i < size; i++){
               //store in curr the node from queue
               TreeNode curr = q.poll();
               //add it to list
               level.add(curr.val);
               //if it has child add them too
               if(curr.left!=null)
               q.add(curr.left);
               if(curr.right!=null)
               q.add(curr.right);
           }
           //add the list to result list
           result.add(level);
       }
       return result;
   }
    }

//Course Schedule
//Time Complexity : O(V+E)
//Space Complexity : O(V+E)
class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
      int [] indegrees = new int[numCourses];
      HashMap<Integer, List<Integer>> map = new HashMap<>();
        //one by one prerequisites
      for(int [] edge : prerequisites){
          indegrees[edge[0]]++;
          //if map doesnt contain 1
          if(!map.containsKey(edge[1])){
              map.put(edge[1], new ArrayList<>());
              
          }
          //if contains add edge of 0
          map.get(edge[1]).add(edge[0]);
      }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        //check if it has 0
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i]==0){
                q.add(i);
                count++;
            }
        }
        //cannot finish as there is no independent course
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            //get all the dependencies from hashmap
            List<Integer> edges = map.get(curr);
            if(edges != null){
                for(int edge : edges){
                    indegrees[edge]--;
                    //if independent
                    if(indegrees[edge] == 0){
                        q.add(edge);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
        return false;
    }
}

