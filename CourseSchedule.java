import java.util.*;

/**
* Use a queue and keep taking courses that have 0 prereqs
* Time Complexity: O(V + E): V: number of courses, E: Prereqs
* Space Complexity: O(V+ E)
*
* 
*
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Number of prereqs per course
        int[] inDegree = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;
            if (!map.containsKey(pre[1]))
                map.put(pre[1], new ArrayList());
            map.get(pre[1]).add(pre[0]);
        }
        
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0 && map.containsKey(i))
                queue.offer(i);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int num : map.get(cur))
                if(--inDegree[num] == 0 && map.containsKey(num))
                    queue.offer(num);
            map.remove(cur);
        }
        if (map.isEmpty())
            return true;
        return false;
    }
}
