package com.ds.rani.bfs;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]. Given the total number of courses and a list of prerequisite pairs,
 * is it possible for you to finish all courses?
 * <p>
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * Constraints:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 1 <= numCourses <= 10^5
 */

//Approach: Using BFS approach here, create indegree array to store the count of current course is depend on how many
//courses. Use queue to maintain list of courses which doesnt have any prerequite.
//Process courses from queue and reduce the indegree count for each course who were dependent on course from queue.

//Time complexity:  o(V+E)==>V=numCourses and E=prerequisite array length
//Space complexity:  o(V+E)
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Inside my 2 D array[2,0] means 0th course is dependent on or have prerequisite 2.

        int[] indegree = new int[numCourses];
        //this map is for easy lookup. eg. for course 0 what are the prerequisite
        Map<Integer, List<Integer>> map = new HashMap<>();

        //find indegrees for each node, this course is dependent on how many courses
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            if (!map.containsKey( prerequisites[i][1] )) {
                map.put( prerequisites[i][1], new ArrayList() );
            }
            //fetchprerequisite list for course and add this prerequisite also
            map.get( prerequisites[i][1] ).add( prerequisites[i][0] );
        }

        //Add the courses in queue which has 0 indegrees or no prerequisite
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add( i );
            }

        }
        //Now take the courses which has no prerequisite and those courses are in my queue,
        // once I fnish that course, courses which are dependent on this course can also be taken

        while (!q.isEmpty()) {
            int course = q.remove();
            //now I have finished course so reduce prerequisite of the courses which are depndent
            // on this course
            List<Integer> dependents = map.get( course );
            if (dependents != null) {
                for (int dependent : dependents) {
                    indegree[dependent]--;
                    //if dependent has no prerequiste we can take that course
                    if (indegree[dependent] == 0)
                        q.add( dependent );
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] > 0)
                return false;
        }
        return true;

    }
}
