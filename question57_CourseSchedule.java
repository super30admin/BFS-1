package BFS1;

import java.util.*;

public class question57_CourseSchedule {
    /* Created by palak on 6/23/2021 */

    /*
        Graph Problem: It shows the dependencies. Normally in graph problems we are given a list of vertices/ edges/ connections or dependencies or adjacency matrix.
        This is the pattern of the Topological sort. In this we will first check for the independent nodes.
        If we cannot finish all the courses, there must a cycle in the graph.
        In order to maintain the order, we need to see the dependencies.
    */
    /*
        Time Complexity: O(V + E)
        Space Complexity: O(V + E)
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        int[] indegrees = new int[numCourses];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] prerequisite: prerequisites) {
            int in = prerequisite[0];
            int out = prerequisite[1];

            indegrees[in]++;
            if(!map.containsKey(out)) {
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < indegrees.length ; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }
        if(queue.size() == 0) return false;
        int count = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            //babies
            List<Integer> children = map.get(curr);
            if(children != null) {
                for(int child: children) {
                    indegrees[child]--;
                    if(indegrees[child] == 0) {
                        queue.add(child);
                    }
                }
            }
        }
        if(count == numCourses) return true;
        return false;
    }


    /*
        DFS Solution (A bit higher level)
            Time Complexity: O(V + E)
            Space Complexity: O(V + E)
    */
    boolean path[];
    boolean visited[];
    HashMap<Integer, List<Integer>> map;
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        for(int[] prerequisite: prerequisites) {
            int in = prerequisite[0];
            int out = prerequisite[1];

            if(!map.containsKey(out)) {
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        for(int i = 0 ; i < numCourses ; i++) {
            if(!visited[i] && hasCycle(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int i) {
        //Base
        if(path[i]) return true;
        if(visited[i]) return false;

        //Logic
        visited[i] = true;
        //Action
        path[i] = true;
        //recurse
        List<Integer> children = map.get(i);
        if(children != null) {
            for(int child: children) {
                if(hasCycle(child)) return true;
            }
        }
        //Backtrack
        path[i] = false;
        return false;
    }

    public static void main(String[] args) {

    }
}