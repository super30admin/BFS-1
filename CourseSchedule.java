/*
* Approach:
*  1. Applying topological sort using indegrees.
        Create a adjaceny list(as edges are given) and 
            parallely update indegree array representing dependency count.

        if indegree is 0 -> independent course.

    Apply BFS starting with ALL independent courses.
* 
*  2. Push all independent courses into queue based on indegree.
        Process each independent course dependencies by reducing the indegrees by 1.

    If indegree is 0, add to queue as independent course.
* 
*  3. If queue is empty and all indegrees are 0, return true.
    else, return false

    Hack:
    we can maintain a counter while adding courses into queue as independent.
    if count == all courses, all courses can be completed
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(V + E)
    in adjacency list, all edges are maintain by vertices to list of edges mapping.
    basically, all edges are represented in adjacency list. O(E)

    There can be scenario where edges can be less than vertices: O(V)
* 
* Space Complexity: O(V)
    all vertices are maintained in adj list as keys.
* 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        int[] indegree = new int[numCourses];

        for(int[] schedule: prerequisites){
            int dependentCourse = schedule[0];
            int independentCourse = schedule[1];

            indegree[dependentCourse]++;

            if(!adjList.containsKey(independentCourse)){
                adjList.put(independentCourse, new ArrayList<>());
            }

            adjList.get(independentCourse).add(dependentCourse);
        }

        Queue<Integer> queue = new LinkedList<>();

        int count = 0;

        for(int index = 0; index < numCourses; index++){
            if(indegree[index] == 0){
                queue.add(index);
                count++;
            }
        }

        // if all are independent courses
        if(count == numCourses)
            return true;
        
        // no independent courses
        if(queue.isEmpty())
            return false;
        
        while(!queue.isEmpty()){
            int currCourse = queue.poll();

            // if currCourse has not dependencies
            if(!adjList.containsKey(currCourse))
                continue;

            for(int dependentCourse: adjList.get(currCourse)){
                indegree[dependentCourse]--;

                // dependent course becomes independent
                if(indegree[dependentCourse] == 0){
                    queue.add(dependentCourse);
                    count++;
                }
            }

            // if all independent courses are pushed to queue
            if(count == numCourses)
                return true;
        }

        return false;
    }
}
