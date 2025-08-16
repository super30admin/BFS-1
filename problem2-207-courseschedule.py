#Time Complexity : o(V+E)
#Space Complexity: o(V+E)
from queue import Queue

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        if numCourses == 0:
            return True

        q = Queue()
        indegress = [0 for i in range(numCourses)]
        dependent_independeant_map = {}
        count = 0
        for num in prerequisites:
            indegress[num[0]] = indegress[num[0]] + 1
            if num[1] in dependent_independeant_map:
                dependent_independeant_map[num[1]].append(num[0])
            else:
                dependent_independeant_map[num[1]] = [num[0]]

        for i in range(numCourses):
            if indegress[i] == 0:
                q.put(i)
                count += 1

        if count == 0:
            return False

        while q.qsize() > 0:
            curr = q.get()
            if curr in dependent_independeant_map:
                dependents = dependent_independeant_map[curr]
                for independent in dependents:
                    indegress[independent] = indegress[independent] - 1
                    if indegress[independent] == 0:
                        q.put(independent)
                        count += 1

        return count == numCourses