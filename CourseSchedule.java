// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: take adjacrncy matrix then store the numer dependencies for that particular value npe take the queue add the numbers which dosent have a dependency then using hash map check which other is depended on that number then recudy the depency by 1 in that adajency matrix it=f it is 0 then delete from queue.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] degrees = new int[numCourses];
        for(int [] edge: prerequisites){
            int in = edge[0];
            int out = edge[1];
            indegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
            }
            Queue<Integer> q = new Linkedlist<>();
            int count = 0;
            for(int i = 0; i< numCourses; i++){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            for(int child: children){
                indegrees[child]--;
                if(indegrees[child] == 0){
                    q.add(child);
                    count++;
                    if(count == numCourses){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}