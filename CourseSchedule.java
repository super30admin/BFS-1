/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//TC = O(N) no of courses + no of prerequisites
//SC = O(N) same order as of TC
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        for(int[] pair : prerequisites)
            indegree[pair[1]]++;
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<indegree.length ; i++ ){
            if(indegree[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
           int temp = q.poll();
            numCourses--;
            for(int [] pair : prerequisites){
                if(pair[0] == temp){
                    indegree[pair[1]]--; 
                    
                    if(indegree[pair[1]] == 0)
                    q.add(pair[1]);
                }
               
            }
        }
        return numCourses==0;
    }
}
        
