/*
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0:
            return True
        
        indegree = [0] * numCourses
        mapping = {}
        
        for courses in prerequisites:
            if courses[1] not in mapping:
                mapping[courses[1]] = []
            
            mapping[courses[1]].append(courses[0])
            indegree[courses[0]] += 1
        
        queue = collections.deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
        
        while len(queue) > 0:
            frontele = queue.popleft()
            
            if frontele in mapping:
                for course in mapping[frontele]:
                    indegree[course] -= 1
                    if indegree[course] == 0:
                        queue.append(course)

        for i in range(numCourses):
            if indegree[i] > 0:
                return False
        return True
*/

// Time Complexity : O(V^2) where V is no of courses. It can also be O(E+V) which is same as V^2
// Space Complexity : O(V). worst case queue will have all the courses at once
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I constructed a hashmap of key having course and its value would be all the
// courses which are dependent. Then started with course who is independent and continued travelling further with its dependents using queue


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return true;
        
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<prerequisites.length; i++){
            if (!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]] ++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<numCourses; i++){
            if (indegree[i] == 0){
                q.add(i);
            }
        }
        
        while (!q.isEmpty()){
            int frontelement = q.poll();
            List<Integer> courses = map.get(frontelement);
            if (courses != null){
                for (int course: courses){
                    indegree[course] --;
                    if (indegree[course] == 0){
                        q.add(course);
                    }
                }
            }
                
        }
        
        for (int i=0; i<numCourses; i++){
            if (indegree[i] > 0){
                return false;
            }
        }
        return true;
    }
}
