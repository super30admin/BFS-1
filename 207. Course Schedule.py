#TC O(v+e) and SC O(v+e)

from queue import Queue
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0:
            return True
        q = Queue()
        indegrees = [0 for i in range(numCourses)]
        Map = {}
        Count = 0
        for i in range(len(prerequisites)):
            From = prerequisites[i][1]
            To = prerequisites[i][0]
            indegrees[To] = indegrees[To] + 1
            if From not in Map:
                Map[From] = []
            Map[From].append(To)

        #if we have a cycle then
        if len(Map) == numCourses:
            return False
        
        for i in range(numCourses):
            if indegrees[i] == 0:
                Count +=1
                q.put(i)
        if Count == 0:
            return False
        while q.qsize() > 0:
            curr = q.get()
            if curr in Map:
                edges = Map[curr]
                for edge in edges:
                    indegrees[edge] = indegrees[edge] - 1
                    if indegrees[edge] == 0:
                        q.put(edge)
                        Count +=1
        return Count == numCourses





        





