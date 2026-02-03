// TimeComplexity: O(V+E) where V is numCourses and E is prerequisites
// SpaceComplexity: O(V+E)
// Explanation: I model the courses as a directed graph where an edge from B → A means course B must be taken before A. I build an adjacency list and an indegree
// array for each course. Then I push all courses with indegree 0 into a queue. Using BFS (Kahn’s algorithm), I repeatedly remove a course from the queue,
// reduce the indegree of its neighbors, and enqueue any neighbor whose indegree becomes 0. If I am able to process all courses, there is no cycle
// and it is possible to finish them; otherwise, a cycle exists.


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] arr = new int[numCourses];
        int count = 0;
        for(int i=0; i<prerequisites.length; i++){
            if(map.get(prerequisites[i][1])==null) {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            } else{
                List<Integer> exist = map.get(prerequisites[i][1]);
                exist.add(prerequisites[i][0]);
            }
            arr[prerequisites[i][0]]+=1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(arr[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int curr = q.poll();
            count++;
            List<Integer> currList = map.get(curr);
            if(currList!=null){
                for(int i =0; i<currList.size(); i++) {
                    int remove = currList.get(i);
                    arr[remove]-=1;
                    if(arr[remove] ==0) {
                        q.add(remove);
                    }
                }   
                map.remove(curr);
            }
            
        }
        if(count == numCourses) {
            return true;
        } else{
            return false;
        }
    }
}
