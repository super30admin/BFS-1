// Time Complexity : O(V+E) where V is total no of vertices(numCourses) and E is edges(courses dependent on each other)
// Space Complexity : O(n) because in the worst case half of the nodes(all leaves) will be inside the queue.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Wasn't able to think through this until the class.

import java.util.*;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length==0) return true;
        int [] indegrees = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int [] edge: prerequisites){
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);

        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
                //System.out.println(i);
                count++;
            }
        }
        //System.out.println(count);
        while(!q.isEmpty()){
            int curr = q.poll();
            // indegrees of dependent nodes
            List<Integer> li = map.get(curr);
            //System.out.println(li);
            if(li != null){
                for(int edg : li){
                    indegrees[edg]--;
                    if(indegrees[edg]==0){
                        q.add(edg);
                        count++;
                        if(count==numCourses) return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String [] args){
        CourseSchedule cs = new CourseSchedule();
        int [][] prereq = new int[][]{{1,4},{2,4},{3,1},{3,2}};
        System.out.println(cs.canFinish(5, prereq));
    }
}