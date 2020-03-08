// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        
        for(int i=0;i<numCourses;i++){
            graph.put(i,new LinkedList<>());
        }
        
        int[] indegree=new int[numCourses];
       for(int[] tuple:prerequisites){ 
           //[course,prereq]
         //  prereq ---> course
           int course=tuple[0];
           int prerequisite=tuple[1];
         graph.get(prerequisite).add(course);
                indegree[course]++;                    
                                    
       }
        Queue<Integer> queue = new LinkedList<>();
        for(int j=0;j<numCourses;j++){
            if(indegree[j]==0){
                queue.add(j);
            }
        }
        int count=0;
        while(!queue.isEmpty()){
           int course= queue.poll();
            List<Integer> correspondincourses = graph.get(course);
            for(int cc: correspondincourses){
                indegree[cc]--;
                if(indegree[cc]==0){
                    queue.add(cc);}
            }
            count++;
        }
    if(count == numCourses){
        return true;
    }
        return false;
    }
}