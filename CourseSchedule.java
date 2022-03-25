// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//First we will create a adjecency list representation of graph
//We will also calculate the indegrees of each node
//Next we will add all the vetices with indegree 0 to a queue
//We will run a while loop with exit condition being queue empty
//Now we will poll queue and check all its adjacency list, decrement their indegrees
//We will keep the count of number of polls from the queue
//If poll count is equal to the numCourses that means its possible
//to take all courses and return true else false;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int[] indegreeC = new int[numCourses];
        
        //Create adjacency list and indegree array
        for(int[] x: prerequisites){
            int s = x[1]; //source
            int d = x[0]; //dependent
            if(!hm.containsKey(s)){
                List<Integer> ll = new ArrayList<>();
                hm.put(s,ll);
            }
            hm.get(s).add(d);
            ++indegreeC[d];
        }
        //put all indegree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegreeC[i] == 0)
                q.add(i);
        }
        //check all the vertices
        int done = 0;
        while(!q.isEmpty()){
            int c = q.poll(); //course
            done++;
            List<Integer> depen = hm.get(c);
            if(depen != null)
            for(int x: depen){
                --indegreeC[x];
                if(indegreeC[x] == 0){
                    q.add(x);
                }
            }
        }
        return done == numCourses;
    }
}