//Leetcode: 207. Course Schedule
//Time Complexity: O(n) // where n is no of courses
//Space Complexity: O(n) // n+n n for hashmap and n for queue
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites ==null || prerequisites.length==0 ) return true;
        HashMap<Integer, List<Integer>> hm  = new HashMap<>();
        int[] indegree=new int[numCourses];
        for(int[] c :  prerequisites){
            if(!hm.containsKey(c[1])){
                hm.put(c[1], new ArrayList<Integer>());
                
            }
            indegree[c[0]]=indegree[c[0]]+1;
            List<Integer> l= hm.get(c[1]);
            l.add(c[0]);
            hm.put(c[1],l);
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int c= q.poll();
            List<Integer> temp = hm.get(c);
            if(temp!=null){
                for(Integer t : temp){
                indegree[t]=indegree[t]-1;
                if(indegree[t]==0){
                    q.add(t);
                }
            }
            }
            
        }
        for(int i: indegree){
            if(i!=0){
                return false;
            }
        }
        return true;
        
    }
}