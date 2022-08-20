//Tc 0(V+E) v-> vertex, E -> edges
//Sc 0(V)

class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        // adjaceny list
        //list to maintain the values and its coresponding directions/prereqs
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        //indegrees
        int[] indegrees = new int[numCourses];
        //iterating through edges
        for(int[] edge :  edges){
            
            indegrees[edge[0]]++;
            //independent to dependent nodes
            if(!map.containsKey(edge[1])){
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);  
        }
        
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        //iterating indegrees array;
        for(int i=0;i<numCourses;i++){
            
            if(indegrees[i]==0){
                q.add(i);
                count++;
            }
        }
        
        if(q.isEmpty()) return false ; 
        while(!q.isEmpty()){
            int curr = q.poll();
            //reduce the indegrees of babies   
            List<Integer> child = map.get(curr);
            //do it only child is not null
            if(child !=null){
                   for(int c : child){
                indegrees[c]--;
                if(indegrees[c]==0){
                    q.add(c);
                    count++;
                    if(count == numCourses) return true;
                }
            }   
            }  
        }
        return count == numCourses;
    }
}
