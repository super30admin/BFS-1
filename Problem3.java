//Time o(V+E)
//space o(V) as ignoring the o(E) as auxillary space
class Solution {                //V                //E
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        
        //indegree matrix
        int indegree[] = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        //o(E)
        for(int i=0;i<prerequisites.length;i++){
            int idx = prerequisites[i][0];
            indegree[idx]++;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        //queue and process the graph
        Queue<Integer> q = new LinkedList<>();
        //o(V)
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        //o(E)
        while(!q.isEmpty()){
            int node = q.poll();
            List<Integer> childs = map.get(node);
            
            if(childs != null){
                for(int child:childs){
                    indegree[child]--;
                    if(indegree[child]==0)
                    {
                        q.add(child);
                    }
                }
            }
        }
        //o(V)
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]>0)
                return false;
        }
        return true;
    }
}