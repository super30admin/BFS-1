// Time Complexity : O(v+e)
// Space Complexity : O(v)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

public class courseschedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int inDegree[] = new int[numCourses];
            Map<Integer, List<Integer>> map = new HashMap<>();

            for(int pre[] : prerequisites){
                inDegree[pre[0]]++;

                if(!map.containsKey(pre[1])){
                    map.put(pre[1], new ArrayList<>());
                }
                map.get(pre[1]).add(pre[0]);
            }
            Queue<Integer> queue = new LinkedList<>();

            for(int c = 0 ; c < numCourses ; ++c){
                if(inDegree[c] == 0){
                    queue.add(c);
                }
            }
            int completed = 0;

            while(!queue.isEmpty()){
                int precourse = queue.remove();
                completed++;

                List<Integer>d = map.get(precourse);
                if(d != null){
                    for(int x : d){
                        inDegree[x]--;
                        if(inDegree[x] == 0){
                            queue.add(x);
                        }
                    }
                }
            }

            return completed == numCourses;
        }
    }
