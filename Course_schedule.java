//Using BFS

// Time Complexity : O(V+E); where V = numofcourses and E = length of prerequisites array
// Space Complexity : O(V+E)


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // adding count of dependency of each edge in indegrees array
        for (int[] edge : prerequisites) {
            indegrees[edge[0]]++;
            // making a map with independent node to dependent node
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {  //checking for independent nodes 
            if (indegrees[i] == 0) {  //if indegree ==0 => node is independent and we will add it to the queue and in crease the count
                q.add(i);
                count++;
            }
        }
        if (q.isEmpty()) // if q is empty it means that there is no independent node
            return false;
        while (!q.isEmpty()) {
            //removing node from queue and checking for its babies
            int curr = q.poll();  
            // reduce the indegrees of curr's babies
            List<Integer> children = map.get(curr);
            if (children == null)  //if there is no baby of curr then continue
                continue;
            for (int child : children) {  //for each child in children , reduce the indegree
                indegrees[child]--;
                if (indegrees[child] == 0) {  //if indegree of child become the add it to the queue and increase the count
                    q.add(child);
                    count++;
                    if (count == numCourses)   
                        return true;
                }

            }
        }
        if (numCourses != count)
            return false;
        return true;

    }
}