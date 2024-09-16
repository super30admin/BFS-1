import java.util.LinkedList;
import java.util.Queue;

// Time and Space : O(V+E)

// 1.  Keep track of indegrees in an Array along with children of each node (course) in a HashMap. Push all those nodes to
//     the Queue whose indegree is zero (no prerequisite exists) and if no such node exists, then courses can't be finished.
// 2.  For each node (course) in Queue, traverse all its children (BFS) and reduce their indegree by one because if the
//     prerequisite course is completed, then its children nodes are cleared off its dependency.
// 3.  After all the nodes, if indegree of any course is still greater than zero, it means courses can't be finished;
//     otherwise courses can be finished.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // Update indegrees array and children HashMap in parallel
        for(int [] edge: prerequisites) {
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])) {
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        // Add courses with no prereq to the queue that is no dependency
        for(int i=0;i<indegrees.length;i++) {
            if(indegrees[i]==0) q.add(i);
        }
        // Iterate over the queue while updating indegrees and add a course to the queue whenever it has no prereqs
        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children!=null) {
                for(int child:children) {
                    indegrees[child]--;
                    if(indegrees[child]==0)
                        q.add(child);
                }
            }
        }
        // After the Queue being empty, if any indegree is greater than zero, those courses can't be finished
        for(int i=0;i<indegrees.length;i++) {
            if(indegrees[i]>0) return false;
        }
        return true;
    }
}