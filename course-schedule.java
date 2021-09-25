//Time complexity: O(∣E∣+∣V∣)
//Space complexity: O(∣E∣+∣V∣)
class Solution {
    boolean[] path;
    boolean[] visited;
    Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        //iterate through the prerequisites 
        for(int[] edge: prerequisites) {
            //if the node is not traversed, add to the map
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            //if the node is present, add the dependent node 
            map.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i] && hasCycle(i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean hasCycle(int course) {
        //base
        if(path[course]) {
            return true;
        }
        if(visited[course]) {
            return false;
        }
        
        //logic
        visited[course] = true;
        //action
        path[course] = true;
        List<Integer> children = map.get(course);
        if(children != null) {
            for(int child: children) {
                if(hasCycle(child)) {
                    return true;
                }
            }
        }
        path[course] = false;
        return false;
    }
}