from collections import deque, defaultdict
from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0] * numCourses
        dependentdict = defaultdict(list)

        # Build the graph and indegree array
        for course, prerequisite in prerequisites:
            indegree[course] += 1 
            dependentdict[prerequisite].append(course)  

        queue = deque()
        count = 0

        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(i) 
                count += 1
        while queue:
            dependent = queue.popleft()
            if dependent in dependentdict: 
                for neighbor in dependentdict[dependent]:
                    indegree[neighbor] -= 1  
                    if indegree[neighbor] == 0:
                        queue.append(neighbor) 
                        count += 1
                        if count == numCourses:
                            return True

        return count == numCourses 
