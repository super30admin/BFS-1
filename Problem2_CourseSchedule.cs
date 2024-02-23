// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
public class Solution {
    public bool CanFinish(int numCourses, int[][] prerequisites) {
        Dictionary<int,List<int>> courseMap = new Dictionary<int, List<int>>(); //Adjacency List -> Course : Dependent Courses List
        int[] outDegrees = new int[numCourses]; // Dependency count for each course
        Queue<int> course = new Queue<int>(); // Queue to process courses

        for(int i = 0; i < prerequisites.Length; i++) {
            int[] pair = prerequisites[i];
            outDegrees[pair[0]]++; //increment count for the dependent course
            //Add course and list of its dependents to hashmap 
            if(courseMap.TryGetValue(pair[1], out var val)) {
                courseMap[pair[1]].Add(pair[0]);
            }
            else {
                courseMap.Add(pair[1], new List<int>{pair[0]});
            }
        }
        //Find independent course (outDegree count = 0) to the queue for processing
        for(int i = 0; i < numCourses; i++) {
            if(outDegrees[i] == 0) {
                course.Enqueue(i);
            }
        }
        while(course.Count > 0) { //Queue is not empty
            int curr = course.Dequeue(); //Process the course in queue
            if(courseMap.TryGetValue(curr, out var dep)) {
                foreach(int i in dep) {
                    outDegrees[i]--; // Then, decrement the count of outDegrees for the dependent courses
                    if(outDegrees[i] == 0) {
                        course.Enqueue(i);
                    }
                }
                courseMap.Remove(curr); //Remove the processed course from courseMap
            }
        }
        //If there are entry of courses still in hashmap, then we could not finish all the courses
        if(courseMap.Count > 0) return false;

        return true;
    }
}