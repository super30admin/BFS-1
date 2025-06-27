// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Problem2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0 || prerequisites[0].length == 0)
            return true;

        int[] indegree = new int[numCourses];   //contains no. of prerequisites for each course (index)
        Map<Integer, List<Integer>> adj = new HashMap<>();      //key = prerequisite, val = list of courses thaat get unlocked by prerequisite

        //this loop traverses & populates 'adj' and updates 'indegree'
        for(int[] x:prerequisites){
            List<Integer> l = new ArrayList<>();
            if(adj.containsKey(x[1]))
                l = adj.get(x[1]);
            l.add(x[0]);
            adj.put(x[1], l);
            indegree[x[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();      //contains course numbers which are unlocked (whose prereqs are zero)
        for(int i = 0; i<indegree.length; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        //this loop traverses through 'q', and updates 'indegree' and 'q'
        while (!q.isEmpty()) {
            int num = q.poll();
            List<Integer> l = new ArrayList<>();
            l = adj.get(num);
            if(l != null)
                for(int n: l){
                    indegree[n]--;
                    if(indegree[n]==0)
                        q.offer(n);
                }
        }

        //this checks if all elements in 'indegree' are '0' or not
        if(Arrays.stream(indegree).sum()==0)
            return true;
        
        return false;
    }
}
