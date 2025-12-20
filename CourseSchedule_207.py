# Time Complexity : It is O(n) since we are iterating with the numCourses.
# Space Complexity : It is O(n) since are creating the hash map.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially I have created the map with key as prerequisites[0], I was creating with indegree.

from typing import List
from collections import defaultdict
from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        coursesMap = defaultdict(list)
        courseCount = [0] * numCourses
        
        for course in prerequisites:   
            courseCount[course[0]] =courseCount[course[0]]+1  
            coursesMap[course[1]].append(course[0])
        
        queue = deque()
        for minCourse in range(numCourses):
            if courseCount[minCourse]==0:
                queue.append(minCourse)
        numberOfCourseCompleted = 0
        while queue:
            numberOfCourseCompleted +=1
            leaveCourse = queue.popleft()
       
            for leftCourse in coursesMap[leaveCourse]:
                    courseCount[leftCourse] = courseCount[leftCourse] - 1
                    if courseCount[leftCourse] == 0:                       
                        queue.append(leftCourse)
                        

        if(numberOfCourseCompleted!=numCourses):
            return False
        else:
            return True
        
obj = Solution()
print(obj.canFinish(5,[[1,4],[2,4],[3,1],[3,2]]))
print(obj.canFinish(2,[[1,0],[0,1]]))
print(obj.canFinish(6,[[5,4],[5,3],[4,2],[4,3],[3,1],[4,1]]))
print(obj.canFinish(2,[[1,0]]))

