/*
Time Complexity - O(n)
Space Complexity - O(n)

*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // fill indegrees array
        for(int[] edge : prerequisites){
            indegrees[edge[0]]++;
            
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            
            map.get(edge[1]).add(edge[0]);
        }
        
        //BFS
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        //adding 0 indegress first in QUEUE
        
        for(int i=0; i<numCourses;i++){
            if(indegrees[i]==0){
                queue.add(i);
                count++;
            }
        }
        
        if(count == numCourses){
            return true;
        }
        
        while(!queue.isEmpty()){
            
            int curr = queue.poll();
            List<Integer> temp = map.get(curr);
            if(temp!=null){
            for(int child : temp){
                indegrees[child]--;
                if(indegrees[child]==0){
                    queue.add(child);
                    count++;
                    if(count == numCourses) return true;
                }
            }
        }
            
            
        }
        return false;
    }
}
