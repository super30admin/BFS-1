// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//In this approach we take a hashmap and add all the vertices as keys and edges as values. Then we maitain indegree array.
//Whichever has indegree of 0 we process that first by adding it to the queue and then from the map we find the edges and reduce their indegree. We keep on doing this till the queue is empty.
//if it not then we return false. We also maintain a count when we add to the queue and when we process all the courses we return true.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        Queue<Integer> q = new LinkedList<>();
        int [] inDegrees = new int[numCourses];
        for(int [] edges: prerequisites){
            if(!map.containsKey(edges[1])){
                map.put(edges[1],new ArrayList<>());
            }
            map.get(edges[1]).add(edges[0]);
            inDegrees[edges[0]]++;
        }
        int count =0;
        for(int i=0;i<numCourses;i++){
            if(inDegrees[i]==0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty())return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> li= map.get(curr);
            if(li!= null){
                for(int child : li ){
                inDegrees[child]--;
                    if(inDegrees[child]==0){
                        q.add(child);
                        count++;
                    }
                }
            }
        }
        if(count == numCourses)return true;
        return false;
    }
}