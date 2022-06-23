// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // creating inDegree array;
        // here I am counting number of incoming edges at each node
        int[] inD = new int[numCourses];

        // map for adjacency list
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // Here I am counting indegrees at each node and making adjacency List
        for (int[] edge : prerequisites) {
            inD[edge[0]]++;
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        // queue BFS traversal
        Queue<Integer> q = new LinkedList<>();
        // to check that I have taken all the courses or not
        int count = 0;

        // those who do not have incoming edges I can add them into the queue first
        for (int i = 0; i < numCourses; i++) {
            if (inD[i] == 0) {
                q.add(i);
                count++;
            }
        }
        // BFS traversal
        while (!q.isEmpty()) {
            // popping first element
            int curr = q.poll();
            // get dependent node for current node
            List<Integer> li = map.get(curr);
            // after visitning this node we can decrease dependent nodes inDegrees
            if (li != null) {
                for (int edge : li) {
                    inD[edge]--;
                    if (inD[edge] == 0) {
                        q.add(edge);
                        count++;
                        // if count == numCourses that means we have commpleted all the courses so we
                        // return true;
                        if (count == numCourses)
                            return true;
                    }
                }
            }

        }
        if (count == numCourses)
            return true;

        // if there is count not equal to numCOurses then we return false
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = new int[][] {
                { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 },
                { 4, 1 }, { 5, 4 }, { 5, 2 }
        };
        System.out.println(canFinish(numCourses, prerequisites));
    }
}