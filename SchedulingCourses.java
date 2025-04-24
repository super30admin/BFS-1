package week5;

import java.util.*;

public class SchedulingCourses {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //(0, 1) (6, 1) (7, 0), (0, 5)
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        int count = 0;
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            List<Integer> list = adjacencyList.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            adjacencyList.put(prerequisite[1], list);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++ ){
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> list = adjacencyList.get(curr);
            if(list != null) {
                for (Integer integer : list) {
                    indegrees[integer]--;
                    if (indegrees[integer] == 0) {
                        q.add(integer);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}
