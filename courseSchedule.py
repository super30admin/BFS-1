"""
Time complexity: O(N)
Space complexity: O(N)
Compiled on leetcode: Yes
"""
from collections import defaultdict, deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree = [0 for i in range(numCourses)]
        coursePrereqMapping = defaultdict(list)
        queue = deque()
        for prerequisite in prerequisites:
            inDegree[prerequisite[0]] += 1
            coursePrereqMapping[prerequisite[1]].append(prerequisite[0])
        
        for i in range(len(inDegree)):
            if inDegree[i] == 0:
                queue.append(i)
        
        while queue:
            currentCourse  = queue.popleft()
            if(len(coursePrereqMapping[currentCourse]) > 0):
                prereqsOfCourse = coursePrereqMapping[currentCourse]
                for prereq in prereqsOfCourse:
                    inDegree[prereq] -= 1
                    if inDegree[prereq] == 0:
                        queue.append(prereq)
        for i in range(numCourses):
            if inDegree[i] != 0:
                return False
        return True    
        
            
        
        