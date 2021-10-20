//Time complexity:-O(M*N);
//Space complexity:-0(m*N);
// Did it run on leetcode?:-yes
//What problems did you face?:- some compilation errors initially.
//Your code with explanation:- initially using hashmap an adjacency matrix is constructed where keys are parent nodes and children are as list in values.
//At the same time indegrees array which tells which node have how many incoming edges is also constructed fro hashmap. Next in indegrees aray
//for all the elements having zero value are added to queue which are our starting point of bfs. next bfs is applied. after wards checking indegrees array, if it contains any non zero.
// implies there is a backedge which is cycle returning false else true is returned.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q =new LinkedList<>();
        int[] indegrees=new int[numCourses];
        HashMap<Integer,List<Integer>> hashmap= new HashMap<>();
        for(int[] x :prerequisites){
            int from=x[0];
            int to=x[1];
            indegrees[to]=indegrees[to]+1;
            if(!hashmap.containsKey(from)){
                hashmap.put(from,new ArrayList<>());
            }
            hashmap.get(from).add(to);
        }
        for(int x=0;x<numCourses;x++){
            if(indegrees[x]==0){
                q.add(x);
            }
        }
        while(!q.isEmpty()){
            int front=q.poll();
            if(hashmap.containsKey(front)){
                for(int x:hashmap.get(front)){
                    indegrees[x]=indegrees[x]-1;
                    if(indegrees[x]==0){
                     q.add(x);
                    }
            }
            }
        }
        for(int x:indegrees){
            if(x!=0){
                return false;
            }
        }
        
   return true; }
}