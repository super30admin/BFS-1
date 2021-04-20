/*
Thought Process: 
We need two storages, an indegree array and a key,val hasmap for storing pre-req course and their follow-up courses list.

Using BFS, fill the queue first with all the courses with indegree 0. Apply BFS on these courses, find their edges, loop through them and reduce their respective indegree by 1. If indegree of an edge becomes 0, enqueue the element

If all the elements enter in the queue, then there is no cycle present and return true, else false.

TC -> O(M*N) where M*N is size of pre-req
SC -> O(N) where N is number of courses. Size for HashMap, indegree Array or queue
*/

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inDegreeArr = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] edge : prerequisites){
            inDegreeArr[edge[0]]++;
            if(!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        //Mistakes Committed -> Initially looping like for(int num: indegree) if 0 then q.add(num)
        for(int i=0; i<inDegreeArr.length; i++){
            if(inDegreeArr[i] == 0)
                q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int polled = q.poll();
            count++;
            List<Integer> edges = map.get(polled);
            if(edges != null){
                for(int edge: edges){
                    inDegreeArr[edge]--;
                    if(inDegreeArr[edge]==0)
                        q.add(edge);
                }
            }
        }
        return count == numCourses;
    }
}