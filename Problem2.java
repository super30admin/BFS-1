// Time Complexity : O(m+v) m number of edges and v vertices(adjacent)
// Space Complexity : O(m+v) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//create a graph and make a indgree array and hash map of indepent and dependent list 
//of courses. iterante the indegree array and add to queue with values 0 and increment count.
//if count matches with number of courses then return true else false.

import java.util.*;

public class Problem2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;

        for (int[] cr : prerequisites) {
            indegrees[cr[0]]++;
            if (!map.containsKey(cr[1])) {
                map.put(cr[1], new ArrayList<>());
            }
            map.get(cr[1]).add(cr[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }

        if (count == numCourses) return true;

        while (!q.isEmpty()) {
            int c = q.poll();
            List<Integer> li = map.get(c);
            if (li != null) {
                for (Integer i : li) {
                    indegrees[i]--;
                    if (indegrees[i] == 0) {
                        q.add(i);
                        count++;
                        if (count == numCourses) return true;
                    }
                }
            }
        }
        return false;
    }

    // Driver method for testing
    public static void main(String[] args) {
        Problem2 solution = new Problem2();

        // Test case 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Can finish courses (Test Case 1): " + solution.canFinish(numCourses1, prerequisites1));

        // Test case 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Can finish courses (Test Case 2): " + solution.canFinish(numCourses2, prerequisites2));
    }
}
