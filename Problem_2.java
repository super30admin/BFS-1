//Time Complexity: O(n)
//Space Complexity:O(n)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] edge: prerequisites){
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
                
            }
                map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) {q.add(i);
                               count++;
                               }  
            
        }
        //System.out.print(q);
        while(!q.isEmpty()){
            int curr= q.poll();
            List<Integer> currArray=map.get(curr);
            if(currArray!=null){
            for(int i : currArray){
                indegree[i]--;
                if(indegree[i]==0){ q.add(i);
                                  count++;}
            }
            }
        }
        if (count==numCourses)return true;
        return false;
    }
}