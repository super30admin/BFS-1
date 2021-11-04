// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] dependency=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<prerequisites.length;i++){
            dependency[prerequisites[i][0]]++;
        }
         for(int i=0;i<dependency.length;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
           
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue=new LinkedList<>();
        
        for(int i=0;i<dependency.length;i++){
            if(dependency[i]==0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int curr= queue.poll();
            List<Integer> currList=adj.get(curr);
            for(int i=0;i<currList.size();i++){
                dependency[currList.get(i)]--;
                if(dependency[currList.get(i)]==0){
                    queue.add(currList.get(i));
                }
            }
        }
        
        for(int i=0;i<dependency.length;i++){
            if(dependency[i]!=0){
                return false;
            }
        }
        
        return true;
        
    }
    