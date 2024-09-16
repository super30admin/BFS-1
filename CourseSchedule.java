/**
Problem: Course schedule
Time complexity: O(V + E), where V is the number of vertices, and E is the number of edges.
Space complexity: O(V + E), where V is the number of vertices, and E is the number of edges.

Did it run on LeetCode: Yes

Approach:
1. We create an indegrees array, which contains the number of prerequisite courses for every course.
2. Since it is a graph problem, we make an edge list, using a hashmap.
3. We then use BFS to solve it. We start with the course that has an indegree of 0, and add its children to the queue.
4. We then go to the children and add their children to the queue, and reduce their indegree. When all the indegrees become 0, that is there is no other dependency on other courses, we will have completed all the courses successfully. Else not.
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     if(prerequisites == null || prerequisites.length == 0) {
         return true;
        }   
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int[] edge : prerequisites) {
            indegrees[edge[0]] += 1;
            if(!hm.containsKey(edge[1])) {
                hm.put(edge[1], new ArrayList<>());
            }
            hm.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<indegrees.length; i++) {
            if(indegrees[i] == 0) {
                q.add(i);
            }
        }
        if(q.size() == 0) return false;
        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> childNodes = hm.get(curr);
            if(childNodes != null) {
                for(int child : childNodes) {
                indegrees[child]--;
                if(indegrees[child] == 0) {
                    q.add(child);
                }
            }
        }
    }
        for(int i = 0; i<indegrees.length; i++) {
            if(indegrees[i]>0) {
                return false;
            }
        }
        return true;
    }
}