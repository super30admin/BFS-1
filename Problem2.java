// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
    // n is the number of nodes present in the linked list.

// Your code here along with comments explaining your approach
    //We use BFS using a queue of courseIDs. We maintain a map(key, value) pointing from prerequisite courseID to the list of courseIDs dependent on the prerequisite course. We also maintain an array to count the number of prerequisites remaining for a particular course.
    //First, we add all the independent courses to the queue. In each iteration, using the map, we get all the dependent courses list. We decrement the count of remaining prerequisite courses in the indegrees array for all the courses in the list. If any of those courses have no dependent courses, we add them to the queue.
    //We iterate over all the courses in the queue. When the queue is empty. We check if any of the courses have any remaining prerequisites in the indegrees, if there is any prerequisite, we have not visited all the courses, we return false. Otherwise, we return true.
    
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preReqCount = new int[numCourses];
        Map<Integer, List<Integer>> preRequisitesMap = new HashMap<>();
        Queue<Integer> courseOrder = new LinkedList<>();
        // Prepare our count array and map;
        for (int[] preReq : prerequisites)
        {
            int course = preReq[1];
            int requirement = preReq[0];
            preReqCount[course]++;
            if (preRequisitesMap.containsKey(requirement)==false)
            {
                preRequisitesMap.put(requirement, new ArrayList<>());
            }
            preRequisitesMap.get(requirement).add(course);
        }
        // Finding the courses which have no prerequisites
        for (int i=0; i<numCourses; i++)
        {
            if (preReqCount[i]==0)
            {
                courseOrder.offer(i);
            }
        }
        // Begin BFS Search
        while(courseOrder.isEmpty()==false)
        {
            int myCourse = courseOrder.poll();
            List<Integer> dependentCourses = preRequisitesMap.get(myCourse);
            if (dependentCourses==null)
            {
                continue;
            }
            for (int course : dependentCourses)
            {
                preReqCount[course]--;
                if (preReqCount[course]==0)
                {
                    courseOrder.offer(course);
                }
            }
        }
        // Check if any courses are left
        for (int preReq : preReqCount)
        {
            if (preReq>0)
            {
                return false;
            }
        }
        return true;
    }
}