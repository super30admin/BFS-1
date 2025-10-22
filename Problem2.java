/*
207. Course Schedule
Ran on leetcode: Yes
TC:O(V+E)
SC:O(V+E)
Create adj map of for faster search, create indegrees array indicating how many courses is it dependent on, add to the queue all the courses with indegrees 0 and then mark it as completed and update indegrees array if the value becomes 0 for the course enqueue it. If the number of courses that can be completed is num of courses return true
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegress = new int[numCourses];
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < prerequisites.length; i++){
            int dependent = prerequisites[i][0];
            int independent = prerequisites[i][1];
            // number of dependent on each course
            indegress[dependent]++;
            // Create map key = independent, value = list of dependents
            adjMap.putIfAbsent(independent, new ArrayList<>());
            adjMap.get(independent).add(dependent);
        }

        int count = 0;
        for(int i = 0; i < indegress.length; i++){ // enqueue all the elements which are fully independent
            if(indegress[i] == 0){
                count++;
                queue.offer(i);
            }
        }

        if(count == numCourses){ // All the elements are enqueued, then all the courses can be completed
            return true;
        }

        if(count == 0){ // If no elements are enqueued, then there are no course from where we can start
            return false;
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            List<Integer> dependents = adjMap.get(course);
            if(dependents != null){
                int size = dependents.size();
                for(int i = 0; i < size; i++){
                    int temp = dependents.get(i);
                    indegress[temp]--; // Dependent course completed so reduce indegree to it
                    if(indegress[temp] == 0){ // Course can be completed
                        queue.offer(temp);
                        count++;
                        if(count == numCourses){ // All courses can be completed
                            return true; 
                        }
                    }
                }
            }
        }

        return false;

    }
}