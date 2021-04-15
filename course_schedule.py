# Time Complexity: O(V+E)
# Space Complexity: O(v)
# Ran on Leetcode: Yes

from queue import Queue

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not numCourses:
            return True
        indegree = [0] * numCourses
        graph = {}
        count = 0
        for comb in prerequisites:
            indegree[comb[0]] += 1
            if comb[1] not in graph:
                graph[comb[1]] = []
            graph[comb[1]].append(comb[0])
        q = Queue()
        for i in range(numCourses):
            if indegree[i] == 0:
                q.put(i)
        while not q.empty():
            elem = q.get()
            count += 1
            if graph.get(elem) != None:
                for item in graph[elem]:
                    indegree[item] -= 1
                    if indegree[item] == 0:
                        q.put(item)
        return count == numCourses
                
        
        