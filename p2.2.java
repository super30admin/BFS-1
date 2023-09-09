// Time Complexity : O(v+e)
// Space Complexity :O(v+e)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    boolean result = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean[] path = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        //Putting every course and it's next courses in hashmap
        for(int[] pre: prerequisites){
            ArrayList<Integer> a = map.getOrDefault(pre[1], new ArrayList<>());
            a.add(pre[0]);
            map.put(pre[1], a);
        }

        //Recurse to find cycle
        for(int i=0; i<numCourses; i++){
            if(!visited[i] && dfs(i, path, visited, map)){
                 return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, boolean[] path, boolean[] visited, HashMap<Integer, ArrayList<Integer>> map){
        //base
        if(path[i]){
            return true;
        }
        if(visited[i]){
            return false;
        }

        //logic
        path[i] = true;
        List<Integer> l = map.get(i);

        if(l != null){
            for(Integer x: l){
                
                if(dfs(x, path, visited, map)){
                    return true;
                }
            }
        }

        //backtrack
        visited[i] = true;
        path[i] = false;
        return false;
    }
}