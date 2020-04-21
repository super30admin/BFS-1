// Time Complexity : O(V+E) 
// Space Complexity : O(2V+E) : V+E creating the graph and queue has V courses in it in best case where all nodes are processed.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//use topological sort. We have solved it using BFS.
//first craete a graph (using hashmap) to store the adjacency list.
//keep track of indegree of each node in a separate array.
//initialize a queue. If any indegree of any node is equal to 0, put it in the queue.
//traverse the queue until it is not empty, to process the node. REduce the indegree of the processed node by 1. If any node exists with indegree equal to 0, put it inside the queue.
//keep track of number of nodes processed using "count". At the end check whether count is equal to total number of nodes or not.

class Solution {
 //V is numCourse, E is the edges 
 // Time Complexity: O(V+E) 
 // Space Complexity: O(2V+E) : V+E creating the graph and queue has V courses in it in best case where all nodes are processed.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //create adjacency graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        //put elements inside the graph
        for(int i=0; i<numCourses; i++){
            graph.put(i, new LinkedList<>());
        }
        
        int[] inDegrees = new int[numCourses];
        
        for(int[] tuple : prerequisites){
            int course = tuple[0];
            int prerequisite = tuple[1];
            graph.get(prerequisite).add(course);
            inDegrees[course]++;
        }
        
        //as we are using BFS, we will use queue to keep track of nodes processed
        Queue<Integer> q = new LinkedList<>();
        
        //iterate over the indegree array to add the nodes with 0 indegree in queue
        for(int i=0; i<inDegrees.length; i++){
            if(inDegrees[i] == 0){
                q.offer(i);
            }
        }
        
        int count = 0; //counter to keep track of number of nodes processed. This should be equal to the total number of nodes at the end.
        
        //process and add nodes until queue is empty
        while(!q.isEmpty()){
           int currentCourse = q.poll(); //get the node with inDegree 0
            
            //get the corresponding courses linked to the above node. 
            List<Integer> courses = graph.get(currentCourse);
            
            //iterate over the elements in courses to reduce their indegree value
            for(int course: courses){
                inDegrees[course]--;
                //if the indegree of any course is equal to 0, we immediately add it to the queue
                if(inDegrees[course] == 0){
                    q.offer(course);
                }
            }
            
            //we increment count by 1. This means a node have been processed.
            count++;
            
        }
        
        //return whether count is equal to the total number of courses, means whther all the nodes have been sucessfully processed or not.
        return count == numCourses;
    }
}