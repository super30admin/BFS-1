class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true ; 

        int[] indegrees = new int[numCourses] ; 
        HashMap<Integer,List<Integer>> map = new HashMap<>() ; 
        Queue<Integer> q = new LinkedList<>() ; 
        
        for(int[]edge : prerequisites){
            int incoming = edge[0] ; 
            int outgoing = edge[1] ; 

            indegrees[incoming] ++ ; 
            if(!map.containsKey(outgoing)){
                map.put(outgoing , new ArrayList());
            }
            map.get(outgoing).add(incoming) ; 
        } 
        for(int i = 0 ; i  < indegrees.length ; i ++ ){
            if(indegrees[i] == 0){
                q.add(i) ; 
            }
        }
        

        while(!q.isEmpty()){
            int current = q.poll() ; 
            List<Integer> edges = map.get(current) ; 

            if(edges != null){
                for(int i : edges){
                    indegrees[i] -- ; 
                    if(indegrees[i] == 0){
                        q.add(i) ; 
                    }
                }
            }
        }

        for(int i = 0 ; i  < indegrees.length ; i ++ ){
            if(indegrees[i] != 0){
                return false;
            }
        }

        return true ; 
    }
}
