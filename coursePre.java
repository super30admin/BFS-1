// Time Complexity : O(V+E)
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


public class coursePre {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        int[] indegree=new int[numCourses];
        HashMap<Integer, List<Integer>> sMap=new HashMap<>();
        for(int[] edge:prerequisites){
            int in=edge[0];
            int out=edge[1];
            if(!sMap.containsKey(out)){
                sMap.put(out, new ArrayList<>());
            }
            sMap.get(out).add(in);
            indegree[in]++;
        }        
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
            
        }
        if(q.isEmpty()) return false;
        
        while(!q.isEmpty()){
            int curr=q.poll();
            
            if(sMap.get(curr)==null) continue;
            for(int c : sMap.get(curr)){
                indegree[c]--;
                if(indegree[c]==0){
                    q.add(c);
                }
            }
        }
        
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]>0)
                return false;
        }
        return true;
        
        
        
        
    }
    
}
