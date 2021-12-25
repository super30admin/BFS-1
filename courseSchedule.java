// Time Complexity : O(v+e)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Lof of things to remember, like indegree array, hashMap to store dependent courses, queue to store the nodes for BFS traversal, count to keep track of all the completed courses


// Your code here along with comments explaining your approach
// BFS solution is Topological sort
// DFS solution is not Topological sort

// Topological sort problem which is being solved with a BFS approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites==null || numCourses == 0) return true;

        // count will keep track of all the courses completed
        int count=0;

        // Array to store indegrees
        int[] indegree = new int[numCourses];

        // Adjacency list to store dependancy
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Queue to implement BFS, which will hold the nodes/courses/vertices which has 0 indegree
        Queue<Integer> q = new LinkedList<>();

        // Fill the indegree array and adjacency list
        for (int[] edge: prerequisites) {
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }

        // Add nodes with 0 indegree to the queue
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        // Itterate over all the nodes in the queue
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            List<Integer> courses = map.get(node);
            if (courses != null) {
                for (int course: courses) {
                    indegree[course]--;
                    if (indegree[course] == 0) {
                        q.add(course);
                    }
                }
            }
        }

        return count == numCourses;
    }
}

// DFS Approach: