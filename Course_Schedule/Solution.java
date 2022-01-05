// Time Complexity :O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We will use a haspmap to keep a track o feach edge and int[] to track if a course can be taken.
 * Initially we put all edges in hashmap and in int[] we keep count of prereq to be completed for each course.
 * Then we use BFS approach in which we put in queue courses which are not dependant on any other course.
 * For each course in queue, we will decrement count of prereqs in int[] of courses, which are dependant on course we are processing.
 * If any of the dependant courses's prereq count became 0 in int[], then we add them in our queue as they can be taken now
 * when our queue becomes empty, we check if all courses have 0 count in prereq array which tells us that all courses have been taken
 * If we found one or more course whose prereq count is not zero, we return false. Else we return true.
*/



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)return true;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] courses = new int[numCourses];
        
        for(int[] prereq: prerequisites){
            courses[prereq[0]]++;
            if(map.containsKey(prereq[1]) == false){
                map.put(prereq[1], new ArrayList<Integer>());
            }
           map.get(prereq[1]).add(prereq[0]);
        }
        
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < courses.length;i++){
            if(courses[i] == 0)q.add(i);
        }
        
        while(q.isEmpty() == false){
            int course = q.poll();
            if(map.containsKey(course) == false)continue;
            ArrayList<Integer> dependants = map.get(course);
            for(int i = 0; i < dependants.size();i++){
                courses[dependants.get(i)]--;
                if(courses[dependants.get(i)] == 0)q.add(dependants.get(i));
            }
        }
        
        for(int i = 0; i < courses.length;i++){
            if(courses[i] > 0)return false;
        }
        
        return true;
    }
}