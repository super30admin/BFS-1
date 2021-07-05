//Time Complexity:O(N) or O(V+E) where V is the vertex and E is the edge.
//Space Complexity:O(N) or O(V+E)
//In this problem, first I'll be creating a list that holds the count of prereq subjects(correspong prereq course indices in the degree array will be incremented). Then I'll be checking for empty index in the degree array and I'll add those indices to my queue. These indices will indicate the dependant courses. Now I'll check if the dependent course is actualy the course that was dequeued from the queue. If so, I'll decrement the count of its corresponding prereq in the degree array. If all the elements in the degree array are 0, we can take numCourses  umber of courses. Else there was a cycle and so we cannot take. This problem uses BFS algorithm in an iterative manner.
//This code was executed and got accepted in leetcode.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue=new LinkedList<>();
        int[] degree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
        }
        for(int i=0;i<numCourses;i++){
            if(degree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int course=queue.poll();
            for(int i=0;i<prerequisites.length;i++){
                if(course==prerequisites[i][0]){
                    degree[prerequisites[i][1]]--;
                    if(degree[prerequisites[i][1]]==0){
                    queue.add(prerequisites[i][1]);
                }
                }
                
            }
        }
        for(int i=0;i<degree.length;i++){
            if(degree[i]!=0){
                return false;
            }
        }
        return true;
    }
}