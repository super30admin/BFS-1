// Time Complexity : O(V+E)  v is the number of courses and e is the number of prerequisites
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using Kahn's algorithm for topological sorting to determine if we can finish all courses.
// We maintain a map of all courses and their prerequisites, as well as an indegree array to track the number of prerequisites for each course. By taking the course with no prerequisites, we can reduce the indegree of its neighbors. This allows us to eventually process all courses with no remaining prerequisites.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        int[] indegree = new int[numCourses];
        for(int[] edge: prerequisites){
            int ai = edge[0];
            int bi = edge[1];
            indegree[bi]++;
            if(!map.containsKey(ai))
                map.put(ai,new ArrayList());
            map.get(ai).add(bi);
        }

        Queue<Integer> q = new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int count =0;
        while(!q.isEmpty()){
            count++;
            int takeCourse = q.poll();
            if(!map.containsKey(takeCourse)) continue;
            List<Integer> li = map.get(takeCourse);
            for(Integer i: li){
                indegree[i]--;
                if(indegree[i]==0)
                    q.add(i);
            }
        }

        return count == numCourses;
    }
}