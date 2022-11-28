// Time Complexity : O(V+E) //v -> vertices, E-> edges
// Space Complexity :O(V+E)  
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0) return true;
        int[] indegree=new int[numCourses];
        HashMap<Integer, List<Integer>> hm=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        int completed=0;
        for(int[] edge:prerequisites){
            int in= edge[0];
            int out=edge[1];
            
            indegree[in]++;
            
            if(!hm.containsKey(out)){
                hm.put(out,new ArrayList());
            }
            hm.get(out).add(in);
        }
        
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                completed++;
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur=q.poll();
            List<Integer> edges=hm.get(cur);
            if(edges!=null){
                for(int n:edges){
                    indegree[n]--;
                    if(indegree[n]==0){
                        completed++;
                        q.add(n);
                    }
                }
            }
        }
        
        return completed==numCourses;
    }
}