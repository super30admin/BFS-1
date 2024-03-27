// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Run on Leetcode: Yes

// # Approach : This is a graph problem, we first visualize the graph. Then we create a adjacency list
// # and indegree's for all the courses. we then add all the courses with indegree == 0 into the queue
// # we start counting the number of courses while we remove once course at a time from queue, and reducing
// # the indegree of it's dependent courses. If any courses indegree equals 0, we add it to the queue.
// # We do this until the queue is empty. At the end we check if number of courses is equal to completed
// # courses and return the result.

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for(int[] edges : prerequisites){
            int in = edges[0]; //Arrow in Graph going in
            int out = edges[1]; //Arrow in Graph going out

            indegrees[in]++; //integer array initially defines as 0

            if(!map.containsKey(out)){
                map.put(out, new ArrayList<Integer>());
            }
            // else{
                map.get(out).add(in);
            // }
        }
        
        Queue<Integer> q = new LinkedList<>();
        int count=0; //how many courses have been taken.

        for(int i=0; i<indegrees.length; i++){ // we can take numCourses for length here too
            if(indegrees[i] == 0)
                q.add(i); //because courses are from 0 to n-1 : given in problme statement
        }

        if(q.isEmpty()){
            return false;
        }

        // int size = q.size();
        while(!q.isEmpty()){ //Start processing that whether I am able to take all course or not
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children == null) continue;
            for(int child : children){
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

        if(count == numCourses){
            return true;
        } //Just 1 course -> indegrees[0], queue holds only 1. It never goes in while if condition in tht case.
       return false;

        //Tweak problem: In each semester how many subject can be taken?
        //How many semester required to complete the course?
    }
}