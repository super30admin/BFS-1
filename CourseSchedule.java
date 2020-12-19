// Time Complexity :O(n) n= prerequisites.length
// Space Complexity :O(numcourses) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach: store the edges of the graph in hashmap. maintain an array for ndegree.
// Iterate the ndegree array and add to queue whose ndegree is 0. Pop the queue and check in hashmap for the dependency subjects and reduce 
// their n degree and if it is 0 add to queue.
class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] ndegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ndegree = new int[numCourses];
        for(int i=0 ; i<prerequisites.length;i++){
            if(!map.containsKey(prerequisites[i][1]))
                map.put(prerequisites[i][1],new ArrayList<>());
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
   
            ndegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<ndegree.length;i++){
            if(ndegree[i]==0)
                queue.add(i);
        }
        
        while(!queue.isEmpty()){
            int n = queue.poll();
            if(map.containsKey(n))
            for(Integer x : map.get(n)){
                ndegree[x]--;
                if(ndegree[x]==0)
                    queue.add(x);
            }
        }
        
        for(int i=0;i<ndegree.length;i++){
                if(ndegree[i]!=0)
                    return false;
        }
        return true;
    }
}