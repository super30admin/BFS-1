//This Java solution determines if it's possible to finish all courses with prerequisites:

//Create a HashMap (map) to represent the graph of courses and their prerequisites, and an array (indegree) to track the indegree of each course.
//Initialize a queue (q) with courses having an indegree of 0, incrementing count for each added course. Process courses in the queue, reducing indegree of their children, and continue until the count equals the total number of courses.
//If the count reaches the total number of courses, return true; otherwise, return false, indicating it's not possible to finish all courses.
//Time Complexity: O(V + E), where V is the number of courses (vertices) and E is the number of prerequisites (edges).
//Space Complexity: O(V + E), for the HashMap and indegree array.






class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegree = new int[numCourses];
        for(int [] edge : prerequisites ){
            int in = edge[0];
            int out = edge[1];
            indegree[in]++;
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        
        }
        Queue<Integer> q = new LinkedList<>();
        int count =0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()){
            return false;
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children == null) continue;
            for(int child:children){
                indegree[child]--;
                if(indegree[child]==0){
                    q.add(child);
                    count++;
                    if(count == numCourses) return true;
                }
            }
        }
        if(count == numCourses) return true;
        return false;

        
    }
}