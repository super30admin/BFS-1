import java.util.*;
/*
Course Schedule
approach: indegrees, map, bfs
time: O(V+E)
space: O(V+E)
 */
public class Problem2 {
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: prerequisites) {
            indegrees[edge[0]]++;

            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());

            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            if (indegrees[i]==0) q.add(i);
        }
        int count = q.size();
        while (!q.isEmpty()) {
            int popped = q.poll();
            List<Integer> temp = map.get(popped);
            if(temp!=null)
                for (int child: temp) {
                    indegrees[child]--;
                    if (indegrees[child]==0) {
                        count++;
                        q.add(child);
                    }
                }
        }

        return count==numCourses?true:false;
    }

    public static void main(String[] args) {
        canFinish(3, new int[][]{{1,0},{1,2},{0,1}});
    }
}
