// Time Complexity : O(n), We traverse once through the linked list.
// Space Complexity : O(1), No extra space is created.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Wasn't able to get clean code(Too many errors before correction)


// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
//Creating adjacency list
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] edges:prerequisites){
            indegrees[edges[0]]++;
            if(!adj.containsKey(edges[1])){
                adj.put(edges[1],new ArrayList<>());
            }
            adj.get(edges[1]).add(edges[0]);
        }
//Adding independent nodes first
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty())return false;
//Popping queue, checking its children and reducing the indegrees of children.
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = adj.get(curr);
            if(children!=null){
                for(int child:children){
                    indegrees[child]--;
//now checking children's dependencies
                    if(indegrees[child]==0){
                        q.add(child);
                        count++;
                    }
                }
            }
            
        }
//finally if no dependencies are left(all values in indegrees list=), this should return true.
        return count==numCourses;
    }       
}