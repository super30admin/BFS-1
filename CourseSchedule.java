class Solution {
    boolean[] path; // to mark the nodes visited while we are doing dfs on a node and travesing that path, we backtrack when the recursion i.e. dfs on that node gets done

    boolean[] visited; // to mark that dfs from a particular node is fully complete that we have done dfs and explored all the nodes from that node

    HashMap<Integer,List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0 || prerequisites == null) return true;
        map = new HashMap<>();
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
    
        // Create a adjacency map
        for(int i=0;i<prerequisites.length;i++){
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new ArrayList<>()); // create a new list if the element is not already present int the map
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
    
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(hasCycle(i)) return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int i){
        // base
        if(path[i]) return true;
        // logic    
        path[i] = true; //action
        List<Integer> li = map.get(i);
        if(li != null){
            for(int j=0;j<li.size();j++){
                if(!visited[li.get(j)] && hasCycle(li.get(j))) return true; // recurse
            }
        }
        
        path[i] = false; // backtrack
        visited[i] = true;
        return false;
    }
}