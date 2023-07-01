// Time Complexity :  O(V+E)
// Space Complexity :  O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: 
// We are building a indegree[] to have the count of dependent course and a hashmap independent to dependent.
// we create a queue, here root elements are the one with 0 dependent courses. So iterate through the indegree[] and add if its val is 0 to the queue
// perform BFS when you remove an element from the queue you will check its dependents in the hmap and decrese their indegree by 1 and if its indegree is 0 add it to the queue
// track the count each time you add elements you add to the queue, if it matches to the numof courses return true else false;


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // if(prerequisites==null || prerequisites.length==0) return true;
       HashMap <Integer, List<Integer>> map = new HashMap<>();
       int[] indegree = new int[numCourses];
       for(int[] pr : prerequisites)
       {
            indegree[pr[0]]++;
            if(!map.containsKey(pr[1])){
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add( pr[0]);
       }
       Queue<Integer> q = new LinkedList<>();
       int count=0;
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()) return false;
        if(count ==numCourses ) return true;

        while(!q.isEmpty())
        {
            int curr = q.poll();
            List<Integer> dep = map.get(curr);
            if(dep!=null) {
                for(int child : dep)
                {
                    indegree[child]--;
                    if(indegree[child]==0) {
                        q.add(child);
                        count++;
                        if(count ==numCourses ) return true;
                    }
                }
            }
        }
        return false;
    }
}