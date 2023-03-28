// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Add all the edges into a map with the independent value as key and the dependent nodes as children of that key. 
 * Maintain an array of their indegree counts. 
 * If indegree of that child is 0, increase count and put it into the queue. 
 * If it isnt 0, process the child and decrement indegree until you can push it back into the queue. 
 */

import java.util.Queue;

public class Problem2 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            int count = 0; 
            int[] inDegree = new int[numCourses];
            for(int edge[]: prerequisites){
                int out = edge[1];
                int in = edge[0];
                inDegree[in]++;
                if(!map.containsKey(out))
                    map.put(out, new ArrayList<>());
                map.get(out).add(in);
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i =0; i < numCourses; i++){
                if(inDegree[i] == 0){
                    count++;
                    q.add(i);
                }
            }
            if(q.isEmpty())
                return false; 
            while(!q.isEmpty()){
                int currCourse = q.poll();
                List<Integer> children = map.get(currCourse);
                if(children != null){
                    for(int child:children){
                        inDegree[child]--;
                        if(inDegree[child] == 0){
                            q.add(child);
                            count++;
                        if(count == numCourses)
                            return true;
                    }
                }
            }
        }
            if(count == numCourses)
                return true;
            return false;
        }
}
