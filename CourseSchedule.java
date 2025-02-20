// Time Complexity : O(E+V) 
// Space Complexity : O(V+E) since we are using a queue and adjacency list of size V(no of vertices) and its corresponding edges.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int n, int[][] prereq) {
    List<List<Integer>> adjacency = new ArrayList<>(n);
        for(int i=0; i<n; i++)
            adjacency.add(new ArrayList<Integer>());
        
        int[] inDegree = new int[n];
        Arrays.fill(inDegree, 0);

        for(int[] arr : prereq)
        {
            adjacency.get(arr[1]).add(arr[0]);
            inDegree[arr[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            if(inDegree[i] == 0)
               que.offer(i);
        }
        int count = 0;
        while(!que.isEmpty())
        {
            int node = que.poll();
            count++;
            for(int elem : adjacency.get(node))
            {
                inDegree[elem]--;
                if(inDegree[elem]==0)
                    que.offer(elem);
            }         
        }
        return count == n;
    }
}

