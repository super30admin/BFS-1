/*
Desc: We prepare a indegrees array to keep track of number of dependencies of a course, as well as a hashmap for keeping
track of the courses dependent on a course. We use BFS to iterate over the graph, by loading all independent courses in the queue,
we move to the new courses, thus at the end of iteration we check if all elements in indegree are zero. if any are not,
it has a cycle and we cannot have all courses done.
Time Complexity: O(n)
Space Complexity:O(n)
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==1) return true;
        Queue<Integer> q = new LinkedList<>();
        int indegrees[] = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int yo[] : prerequisites){
            int in = yo[0];
            int out = yo[1];
            if(!map.containsKey(out)){
                map.put(out,new ArrayList<>());
            }
            map.get(out).add(in);
            indegrees[in] += 1;
        }
        
        for(int i =0;i<numCourses;i++){
            if(indegrees[i] == 0 ){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            if(map.get(curr)==null) continue;
            for(int pre : map.get(curr)){
                indegrees[pre]--;
                if(indegrees[pre]==0) q.add(pre);
            }
        }
        
        if(q.isEmpty()) return true;
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]!=0) return false;
        }
        return true;
    }
}
