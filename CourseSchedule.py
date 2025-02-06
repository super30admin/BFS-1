from collections import defaultdict
from queue import Queue
#----------------------See Notes-------------------------------------------------------------
#--------------------Time = O(V+E), Space = O(V+E)-------------------------
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees = [0 for _ in range(numCourses)]
        dependency_map = defaultdict(list)
        for edge in prerequisites:
            dependent = edge[0]
            independent = edge[1]
            indegrees[dependent] += 1
            dependency_map[independent].append(dependent)
        q = Queue()
        count = 0
        for i in range(numCourses):
            if indegrees[i] == 0:
                q.put(i)
                count += 1
        if count == numCourses : #----Edge case for just empty prequisites = []
            return True
        if q.empty() : # Every course is dependent on other like cyclic graph so return false we can not complete the courses
            return False
        while(not q.empty()):
            curr = q.get()
            dependents = dependency_map[curr]
            for i in dependents:
                indegrees[i] -= 1
                if indegrees[i] == 0:
                    q.put(i)
                    count += 1
                    if count == numCourses:
                        return True
        return False