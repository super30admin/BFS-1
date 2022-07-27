//  Time complexity: O(n)
//  Space complexity: O(n)
//  Approach: use breadth first search
//  initialise a queue and add the root
//  in a loop, check for queue size and create a loop inside this loop of queue's size
//  pop element from queue and add this element to a list and check for its left and right children
//  if left, right, chiled exists, add them
//  append this list to main list of result

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> courseMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int completedCourses = 0;
        for(int[] req: prerequisites) {
            //course
            int in = req[0];
            //prereq course
            int out = req[1];

            //maintain indegree map which contains the count of prerequisite courses for that course
            indegree[in]++;

            //maintain a hashmap of prerequisite course as key and courses dependent on it as values
            if(courseMap.get(out) == null) {
                courseMap.put(out, new ArrayList<Integer>());
            }
            courseMap.get(out).add(in);
        }

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0){
                //add the course which has 0 prereqs to the queue
                q.add(i);
                completedCourses++;
            }
        }

        //till the queue is empty, pop "0 prereq" courses and reduce the count for the dependent courses in indree map by 1
        while(!q.isEmpty()) {
            int out = q.poll();
            List<Integer> reqList = courseMap.get(out);
            if(reqList == null) continue;
            for(int req: reqList){
                indegree[req]--;
                //add the course which has 0 prereqs to the queue
                if(indegree[req] == 0){
                    q.add(req);
                    completedCourses++;
                }
            }
        }
        //if the completed courses equals the number of courses, then the course schedule can be completed
        return completedCourses == numCourses;
    }
}