// Time Complexity : O(V + E)
// Space Complexity : O(V + E)

class Solution {
    boolean[] visited;
    boolean[] path;
    Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
    
        map = new HashMap<>();
        for(int prerequisite[]:prerequisites){
            int pre = prerequisite[1];
            int course = prerequisite[0];
            if(!map.containsKey(pre)){
                map.put(pre, new ArrayList());
            }
            map.get(pre).add(course);
        }
        for(int i = 0;i < numCourses;i++){
            if(!visited[i] && hasCycle(i))
                return false;
        }
        return true;
    }
    
    public boolean hasCycle(int i){
        if(path[i])
            return true;
        if(visited[i])
            return false;
        visited[i] = true;
        path[i] = true;
        List<Integer> li = map.get(i);
        if(li != null){
            for(int course:li)
                if(hasCycle(course))
                    return true;
        }
        path[i] = false;
        return false;
    }
}