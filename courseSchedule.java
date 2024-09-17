// Time : O(V + E) , V = vertices, E = edges (iterating over the prerequisites array, hashmap & queue)
// Space Complexity: O(V + E), V = vertices, E = edges (storing in hashmap & queue)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] prerequisite: prerequisites) {
            if(!map.containsKey(prerequisite[1]))
                map.put(prerequisite[1], new ArrayList<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList();
        int completed = 0;
        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0)
                queue.add(i);
        }
        
        if(queue.isEmpty()) return false;
        if(queue.size() == numCourses)
            return true;
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            completed++;
            List<Integer> list = map.get(curr);
            if(list != null) {
                for(int course : list) {
                indegrees[course]--;
                if(indegrees[course] == 0)
                    queue.add(course);
                }
            }
        }
        return completed == numCourses;
    }
}