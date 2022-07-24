// Time Complexity : o(v+e) 
// Space Complexity : o(v+e)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        
        for(int[] req : prerequisites){
            int in=req[0];
            int out=req[1];
            indegree[in]++;
            if(!map.containsKey(out)){
                map.put(out,new ArrayList<>());
            }
            map.get(out).add(in);
        }
        //add 0
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int course=q.poll();
            //if(!map.containsKey(course)) continue;
            List<Integer> edges=map.get(course);
            if(edges==null)continue;
            for(int edge : edges){
                indegree[edge]--;
                if(indegree[edge]==0){
                    q.add(edge);
                }
            }
         }
        
        for(int course:indegree){
            if(course!=0){
                return false;
            }
        }
        return true;
    }
                                   
}