// Time Complexity : O(V + E)
// Space Complexity : O(V + E) , O(v) for indegree array & O(E) for hashmap if you add all values in hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Solution: (Graph like problem)create indegrees array which has all courses 0 to numCourses. increment the indegree at the
// course if a course has a prerequisite. Create hashmap for tracking a course as key and all courses which depend on that course as value.
// Use queue to track all courses which have now become independent i.e. have indegree as 0.
// We should have atleast 1 course which is independent i.e indegree = 0 in starting otherwise courses cannot be completed.
// if total no of courses that have become independent == numCourses return true.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] pq: prerequisites){ //O(E)
            indegrees[pq[0]]++;
            if(!map.containsKey(pq[1])){
                map.put(pq[1], new ArrayList<>());
            }
            map.get(pq[1]).add(pq[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i =0; i<numCourses; i++){ //O(V)
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }

        if(q.isEmpty()) return false;
        if(q.size() == numCourses) return true;
        while(!q.isEmpty()){ //O(V+E)
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children !=null){
                for(Integer child: children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }

        return false;
        
    }
}