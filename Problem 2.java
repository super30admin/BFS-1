// Time Complexity : O(E+V) 
// Space Complexity : O(E+V) 
// Did this code successfully run on Leetcode : yes, still need to fully learn this better

// Three line explanation of solution in plain english
// We are adding all our prerequisites as keys and their successive classes in an arraylist for the key values
// After, we are checking to see for each course if we can construct a cycle
// If there is a cycle, then it means we do not have a start node where taking all the classes is possible
 
//
class Solution {
    HashMap<Integer, List<Integer>> map;
    boolean [] visited;
    boolean [] path;
    public boolean canFinish(int numCourses, int[][] prerequisites){
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        map = new HashMap<>();
        for(int [] prerequisite : prerequisites){
            if(!map.containsKey(prerequisite[1])){
                map.put(prerequisite[1], new ArrayList<>());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && hasCycle(i)){
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(int i){
        //base
        if(path[i]) return true; //path is repeated so must be cycle
        if(visited[i]) return false; //if we already visited this node, we can skip
        //logic
        visited[i] = true;
        //action
        path[i] = true;
        
        List<Integer> children = map.get(i);
        if(children != null){
            for(int child : children){
                if(hasCycle(child)) return true;
            }
        }
        
        //backtrack
        path[i] = false;
        return false;
    }
}