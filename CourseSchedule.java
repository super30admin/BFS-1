// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// we create an indegree array of all dependencies and store a mapping of an element with its dependencies in a hashmap
// we then process the nodes in BFS and decrease the indegree count
// If indegree of all nodes are 0 at the end, then we can return true

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        int count =0;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++){
            int dep = prerequisites[i][0];
            int inde = prerequisites[i][1];
            indegrees[dep]++;
            if(!map.containsKey(inde))
                map.put(inde, new ArrayList<>());
            map.get(inde).add(dep);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0)
                {q.add(i);count++; }
        }
        while(!q.isEmpty()){
            int x = q.poll();
            List<Integer> temp = map.get(x);
            if(temp!=null)
                for(Integer j:temp){
                    indegrees[j]--;
                    if(indegrees[j]==0)
                        {q.add(j); count++;}
                }
        }
        if(count==numCourses)
            return true;
        return false;

    }
}