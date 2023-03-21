class Solution {
    HashMap<Integer,List<Integer>> map;
    boolean [] visited;
    boolean [] path;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean [numCourses];
        path = new boolean [numCourses];
        map = new HashMap<>();
        for(int[] edge : prerequisites){
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && dfs(i)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int i){
        if(path[i])return true;
        if(visited[i])return false;
        visited[i] = true;
        path[i] = true;
        if(map.get(i)!=null){
            for(int n : map.get(i)){
                if(dfs(n)) return true;
            }
        }
path[i] = false;
return false;
    }

}