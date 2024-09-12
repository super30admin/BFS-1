class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        int[] indegrees = new int[numCourses];
        //Adjustancy list
        HashMap<Integer,List<Integer>> map = new HashMap();
        //Initialize the indegrees and adjus.length){
          for(int i =0 ;i <prerequisites.length;i++) {
          indegrees[prerequisites[i][0]]++;  // (2,1) means 2 depends on 1 ie edge[0] depends on edge[1]
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new ArrayList());
            }    
              map.get(prerequisites[i][1]).add(prerequisites[i][0]);            
        }
        Queue<Integer> q = new LinkedList();
        for(int i = 0;i <indegrees.length;i++ ){
            if(indegrees[i]==0){
                q.add(i);
            }
        }
        if(q.size() == 0 ) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child : children){
                    indegrees[child]--;  
                    if(indegrees[child]==0){
                        q.add(child);
                    }
                }
            }
           
        }
            for(int i = 0;i < indegrees.length ;i++){
                if(indegrees[i] >  0 ) return false;
            }
             return true;
        }
       
}

/**
Time and Space complexity : O(V+ E) where v is vertices and e is edges
/

