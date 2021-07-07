/*
 * #207. Course Schedule
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
             
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

1. The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
2. You may assume that there are no duplicate edges in the input prerequisites.
3. 1 <= numCourses <= 10^5

 */


/*
 * Time Complexity: O (N)
 * 
 * Space Complexity: O (N) -> 3 times O (N) for each Array, HashMap and Queue
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.BFS1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // #1. Create an array to keep track of number of incoming edges for each node in a graph
        int[] incomingEdges = new int[numCourses];
        
        // #2. Create a HashMap to store the 'prerequisite' as key and 'its children' as a list
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        // #3. Traverse through each list in a 'prerequisites' list, get the first element in that list, go to 'first' index in array and increment number of incoming edges for that 'first' element by 1
        for(int[] edge : prerequisites){
            int first = edge[0];
            int second = edge[1];
            
            incomingEdges[first] += 1;
            
            // #4. While we are traversing each list in a 'prerequisites' list, add key value pairs to HashMap if not present
            // If map does not contains the 'prerequisite' as a key, add it and create an empty ArrayList as a value, else, get the value for already added 'prerequisite' and add 'first' to the ArrayList 
            if(!map.containsKey(second)){
                map.put(second, new ArrayList<>());
            }
            map.get(second).add(first);
        }
        
        // #5. Create a queue to generate topological sorting order of elements
        Queue<Integer> queue = new LinkedList<Integer>();
        
        // #6. Traverse through the array to find starting node for topological sorting and add that node to queue
        for(int i = 0; i < incomingEdges.length; i++){
            if(incomingEdges[i] == 0){ // a node with no incoming edges
                queue.add(i);
            }
        }
        
        // #7. Start traversing the queue
        
        // If queue is empty
        if(queue.isEmpty()){
            return false; // no node found without incoming edges, so no topological sorting, return false
        }
        
        // If queue is not empty, start traversing it 
        while(!queue.isEmpty()){
            // Remove the front element from queue
            int front = queue.poll();
            
            // Check if that element is present as a key in HashMap?
            // If not, do nothing
            if(map.containsKey(front)){
                
                // If key present, then get the list(value) and for each element in list, go to that 'element' index in array and decrement the number of edges
                for(int x : map.get(front)){
                    // Since, we are removing front element from queue, its children's incoming edges are also gone, so  
                    incomingEdges[x] -= 1;
                    
                    // If number of incoming edges for any element becomes 0 in array, we got a new starting point for topological sorting, add the element in queue
                    if(incomingEdges[x] == 0){
                    queue.add(x);
                    }
                    
                }
            }
        
        } // while loop ends once queue is empty
        
        // #8. Now, traverse through the array and check if incoming edges count for all the elements is zero, meaning all the courses are completed
        // If not, there is some course left, return false
        for(int x : incomingEdges){
            if(x != 0){
                return false;
            }
        }
        
        return true; // else, return true if everything is zero in array
    }

}
