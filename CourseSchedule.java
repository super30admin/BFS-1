import java.util.*;

public class CourseSchedule {

    // Time complexity: O(N) when N is the number of subjects
    //Space Complexity: O(3N) as we are maintaining an auxiliary queue/ indegree array, adjacency map
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length == 0){
            return true;
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i =0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;

            if(!adj.containsKey(prerequisites[i][1])){
                adj.put(prerequisites[i][1], new ArrayList<>());
            }
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i< indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }

        }

        int completedSubject = 0;

        while(!queue.isEmpty()){
            int currentSubject = queue.poll();
            completedSubject++;
            List<Integer> dependentSubjects = adj.get(currentSubject);
            if(dependentSubjects == null){
                continue;
            }
            for(int i = 0; i < dependentSubjects.size(); i++){
                indegree[dependentSubjects.get(i)]--;

                if(indegree[dependentSubjects.get(i)] == 0){
                    queue.offer(dependentSubjects.get(i));
                }
            }
        }

        return completedSubject == numCourses;
    }
}
