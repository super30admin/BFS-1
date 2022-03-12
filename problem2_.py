TC:O(v+e)
SC:O(v+e)

from queue import Queue

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites is None or len(prerequisites) == 0:
            return True
        hmap = {}
        indegrees = [0] * numCourses
        queue = Queue()

        for pre in prerequisites:
            indegrees[pre[0]] += 1
            if pre[1] not in hmap:
                hmap[pre[1]] = []
            hmap[pre[1]].append(pre[0])

        for i in range(0,len(indegrees)):
            if indegrees[i] == 0:
                queue.put(i)

        while not queue.empty():
            elem = queue.get()
            if elem in hmap:
                for val in hmap[elem]:
                    indegrees[val] -= 1
                    if indegrees[val] == 0:
                        queue.put(val)

        for i in indegrees:
            if i != 0:
                return False

        return True


# Approach 2
from queue import Queue

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites is None or len(prerequisites) == 0:
            return True
        self.hmap = {}
        self.visited = [False]*numCourses
        self.path = [False]*numCourses

        for pre in prerequisites:
            if pre[1] not in self.hmap:
                self.hmap[pre[1]] = []
            self.hmap[pre[1]].append(pre[0])

        for i in range(0,numCourses):
            if not self.visited[i] and self.hasCycle(i):
                return False

        return True

    def hasCycle(self,i):
        #end cases
        if self.path[i]:
            return True

        if self.visited[i]:
            return False

        # logic
        self.visited[i] = True
        self.path[i] = True

        if i in self.hmap:
            for ind in self.hmap[i]:
                if self.hasCycle(ind):
                    return True
        self.path[i] = False

        return False
