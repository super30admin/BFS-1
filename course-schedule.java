// Time - O(V+E)
// Space - O(V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses ==0) {
            
            return true;
        }
        
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i=0;i<prerequisites.length;i++) {
            indegrees[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])) {
               map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for(int i=0;i<numCourses;i++) {
            if(indegrees[i] == 0) {
                q.add(i);
            }                           
        }
        
        while(!q.isEmpty()) {
            int ele = q.poll();
            List<Integer> children = map.get(ele);
            if(children != null) {
                for(int num : children ) {
                    indegrees[num]--;
                    if(indegrees[num] == 0) {
                        q.add(num);
                    }
                }
            }
            
        }
        for(int i=0;i<numCourses;i++) {
            if(indegrees[i] > 0) {
                return false;
            }
        }
        
        return true;
    }
}

class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // bulid the map
        for(int i=0;i<prerequisites.length;i++) {
            if(!graph.containsKey(prerequisites[i][1])) {
                graph.put(prerequisites[i][1], new ArrayList<>());
            }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        boolean[] checked = new boolean[numCourses];
        
        boolean[] path = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++) {
            if(checkCycle(i, checked, path)) {
                return false;
            }
        }
        
        return true;        
    }
    
    private boolean checkCycle(int i, boolean[] checked, boolean[] path) {
        if(checked[i]) {
            return false;
        }
        
        if(path[i]) {
            return true;
        }
        
        if(!graph.containsKey(i)) {
            return false;
        }
        
        path[i] = true;
        
        boolean res = false;
        
        for(int child : graph.get(i)) {
            res = checkCycle(child, checked, path);
            if(res)
                break;
        }
        
        path[i] = false;
        
        checked[i] = true;
        
        return res;
    }
}
