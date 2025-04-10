// TC: O(V+E)
// SC:- - O(V+E) ( for adjacency list) + O(2V) (for queue and inDegrees array)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pr : prerequisites) {
            // pr[0] - dependent, pr[1] -independent
            // We need to add the dependent elements here
            indegrees[pr[0]]++;
            //Adjacency list/hashMap
            map.putIfAbsent(pr[1], new ArrayList<>());
            map.get(pr[1]).add(pr[0]);
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        // So all the lements inside it has dependency 0
        for(int i=0; i<numCourses; i++) {
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }
        // This means there is a cycle
        if(q.isEmpty()) return false;
        // All the courses are independent and no dependency
        if(count == numCourses) return false;

        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> dependencies = map.get(curr);
            if(dependencies != null) {
                for(int dependent: dependencies) { // We get the dependent nodes of current course that has been completed. And decrease their dependency in 
                 // indegrees array. If the indegree of any becomes 0, then it gets added to queue as it can now be taken.
                    indegrees[dependent]--;
                    if(indegrees[dependent] == 0) {
                        q.add(dependent);
                        count++;
                        //if(count == numCourses) return true;
                    }
                }
            }
        }
           //  if(count == numCourses) return true;
            // So, if we come out of the while loop above without hitting line 38, if(count == numCourses) return true; that means we have some cycle in one 
            // part of the graph and hence, we return false.
            return count == numCourses;
    }
}