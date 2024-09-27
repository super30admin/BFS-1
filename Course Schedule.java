/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

/*
 * Hints:
 * 1. This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 * 2. Topological Soriting can be done via DFS or BFS
 *
 */

// Breadth First Search Solution

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            
                indegree[prerequisites[i][0]]++;
        }       
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        int count = 0;
        
        for(int i = 0; i < indegree.length; i++){
            
            if(indegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()){
            
            int a = q.remove();
            count++;
            
            for(int i = 0; i < prerequisites.length; i++){
                
                if(a == prerequisites[i][1]){
                    
                    indegree[prerequisites[i][0]]--;
                
                    if(indegree[prerequisites[i][0]] == 0){

                        q.add(prerequisites[i][0]);

                    }
                }
            }
        }
        
        return count == numCourses;
    }
}


// Depth - First Search Solution

// Learn how to do Topological sorting using DFS