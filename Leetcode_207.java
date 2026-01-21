//Topological sort
//Travel through prereq
//Maintain indegree array; Maintain map with key as indep node and value as list of it's dependents
//Once the indegree array and map is formed, check number of independent nodes from indegree array
//If all are independent - we can complete all courses
//Else, add independent nodes to queue
//Process one by one. Update indegree array every time. 
//If all nodes of indegree array becomes 0, no cycle and courses can be completed
//TC: O(V+E)
//SC: O(V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        int[] indegree=new int[n];
        Map<Integer,List<Integer>> map=new HashMap<>();

        for(int[] req:prerequisites){
            int dep=req[0];
            int indep=req[1];

            indegree[dep]+=1;

            if(!(map.containsKey(indep))){
                map.put(indep,new ArrayList<>());
            }
            map.get(indep).add(dep);
        }

        int count=0;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                queue.add(i);
                count+=1;
            }
        }

        if(count==n) return true;

        while(!(queue.isEmpty())){
            int currVal=queue.poll();
            List<Integer> curr=map.get(currVal);
            if(curr!=null){
                for(int c:curr){
                    indegree[c]-=1;
                    if(indegree[c]==0){
                        queue.add(c);
                        count+=1;

                        if(count==n) return true;
                    }
                }
            }
        }

        if(count==n) return true;
        return false;


        
    }
}
