class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0){
            return true;
        }
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        int[] indegree= new int[numCourses];
        
        for( int[] edge: prerequisites ){
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
            }
        
        Queue<Integer> q= new LinkedList<>();
        
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int current=q.poll();
            List<Integer> e= map.get(current);
            if(e!=null){
                for(int m:e){
                indegree[m]--;
                if(indegree[m]==0)
                {
                    q.add(m);
                }
            }
            }
        }
        
    for(int i=0;i<indegree.length;i++){
        if(indegree[i]>0){
            return false;
        }
    }
        return true;
        
    }
}