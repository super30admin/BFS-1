import java.util.*;
//Time Complexity: O(V + E)
//Space Complexity: O(V +E)
//Leetcode: yes
public class CourseScheduleLeetCode207 {

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            if (prerequisites ==null || prerequisites.length == 0) {
                return true;
            }

            int[] indegree = new int[numCourses];
            HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

            for (int[] edge : prerequisites) {
                indegree[edge[0]]++;
                if (!graph.containsKey(edge[1])) {
                    List<Integer> li = new ArrayList<Integer>();
                    li.add(edge[0]);
                    graph.put(edge[1], li);
                } else {
                    graph.get(edge[1]).add(edge[0]);
                }
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            int count = 0;
            for (int i = 0; i< numCourses; i++) {
                if (indegree[i] == 0) {
                    count++;
                    queue.add(i);
                    System.out.println("Course i : "+i+" count : "+count);
                }
            }

            if (queue.isEmpty()) {
                //No courses are independent everythingis dependent on somenothing no place to start.
                return false;
            }

            while(!queue.isEmpty()) {

                int v = queue.poll();
                //Now get all the courses which is dependent on the course pulled out from the queue
                List<Integer> dependent = graph.get(v);
                if (dependent != null) {
                    //       System.out.println("Course  v : "+v+ " dependent.size : "+dependent.size());
                    for (int courses : dependent) {
                        indegree[courses]--;
                        if (indegree[courses] == 0) {
                            count++;
                            queue.add(courses);
                            if (count == numCourses) {
                                //this means we can take all the courses.
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }
}
