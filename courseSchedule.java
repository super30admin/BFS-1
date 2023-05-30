// Time Complexity : O(n) where n is the length of the prerequisites array
// Space Complexity : O(n) (for HashMap and Q)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We consider this as a graph problem, where the vertices are the courses, and
 * directed edges represent the dependency relation. We use a topological sort
 * on this graph in order for us to see whether all courses can be taken or
 * not. First, we construct an "indegree" array which shows the number of edges
 * on which each course depends on. We use a HashMap to make the lookup on
 * prerequisites faster. We use a Q in order to perform BFS level-wise from the
 * independent courses and then onto the dependent courses. If finally we see
 * that all indegrees become 0, then we can say that all courses can be taken.
 */

import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // we need an indegrees array so that ultimately all courses
        // should have 0 indegrees
        int[] indegrees = new int[numCourses]; // all 0 initially
        for(int i=0; i<prerequisites.length; i++) {
            // add indegree for every course in dependency list (prerequisites)
            indegrees[prerequisites[i][0]]++;
        }

        // make lookup easy for the course prerequisites so that we can traverse each
        // course prerequisite and mark those as "attended" (i.e., reduce indegrees)
        HashMap<Integer, List<Integer>> m = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++) {
            int prereq = prerequisites[i][1];
            int dependent = prerequisites[i][0];
            if(!m.containsKey(prereq)) {
                m.put(prereq, new ArrayList<>());
            }
            m.get(prereq).add(dependent);
        }

        int attended = 0;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegrees.length; i++) {
            if(indegrees[i] == 0) {
                q.add(i); // add independent courses
                attended++; // mark as "attended"
            }
        }

        // perform BFS to "attend the courses"
        while(!q.isEmpty()) {
            int course = q.poll();
            List<Integer> dependentCourses = m.get(course);
            // only if there are any dependent courses
            if(dependentCourses != null) {
                for(int dcourse : dependentCourses) {
                    indegrees[dcourse]--; 
                    // if course now doesn't have any prereqs, add it to Q
                    if(indegrees[dcourse] == 0) {
                        attended++; // "attend" that course
                        q.add(dcourse);
                    }
                }
            }
        }

        return attended == numCourses;
    }
}