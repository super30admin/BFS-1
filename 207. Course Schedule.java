// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] numDependency = new int[numCourses]; // to keep no of course it depends on
        HashMap<Integer,List<Integer>> hm = new HashMap<>(); // to keep dependent courses lists 
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for( int i = 0; i< prerequisites.length; i++){
            numDependency[prerequisites[i][0]]++;
        }
        for( int i = 0; i<prerequisites.length; i++){
            if(!hm.containsKey(prerequisites[i][1])){
                hm.put(prerequisites[i][1],new ArrayList<>());
            }
            hm.get(prerequisites[i][1]).add(prerequisites[i][0]);

        }
        for( int i = 0; i<numDependency.length; i++){
            if(numDependency[i]==0) q.add(i);
        }   
        while(!q.isEmpty()){
            int course = q.poll();
            list = hm.get(course);
            if(list!=null){
                for( int child : list){
                    numDependency[child]--;

                    if(numDependency[child] == 0)q.add(child);
                }
            }
        }
        for( int i = 0; i<numCourses; i++){
            if(numDependency[i]!=0)return false;
        }
        return true;
    }
}