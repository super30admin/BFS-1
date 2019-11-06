/** Course Schedule
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

// Time Complexity : O(n^2) since we are keeping a matrix of each nodes
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach(explain these to the interviewer)-1. First we create and calculate in-degrees array(counting all incoming edges for each nodes)
//2. Considering all elements/subjects in the queue (BFS order) which doesn't have any pre-requisites
//3. start processing each subjects which doesn't have any pre-requisites and whose pre-requisites have been already satisfied
//then, keep decrementing by 1 for each subject in indegrees array(for satisfied subject)
//result-if the indegree array becomes 0 for each subject, then its satisfied

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create in-degrees array for a size of num of courses taken
        int[] degrees = new int[numCourses]; //[0,0,0,0,0,0]
        //creating a queue to add subjects 
        Queue<Integer> q = new LinkedList<>();
        //[0, 1, 0, 0, 0, 0]
        //[4,0][2,0][1,2][1,4][5,1][5,3][3,2]
        for(int i = 0; i < prerequisites.length; i++){
            degrees[prerequisites[i][0]]++;
        }
        //keep adding the subject whoses prerequisites have been satisfied/doesn't have any pre-requisites
        for(int i = 0; i < degrees.length; i++){
            if(degrees[i] == 0){
                q.add(i);
            }
        }
        //processing the queue
        while(!q.isEmpty()){
            //consider a first element in queue and pop it out
            int course = q.poll();
            for(int i = 0; i < prerequisites.length; i++){
                //if the pre-requisite has already been done, decrement the indegrees array for that element
                if(prerequisites[i][0] == course){
                    degrees[prerequisites[i][1]]--;
                    //if the indegrees array becomes 0 for that element, add it to the queue
                    if(degrees[prerequisites[i][1]] == 0){
                        q.add(prerequisites[i][1]);
                    }
                }
            }
        }
        //if in-degrees array is not equal to 0, then return false and it doesn't satisfy
        for(int i = 0; i < degrees.length; i++){
            if(degrees[i] != 0) return false;
        }
        return true;
    }
}