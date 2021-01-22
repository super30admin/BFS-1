from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #Approach: BFS
        #Time Complexity: O(V + E)
        #Space Complexity: O(V + E) // edgeMap
        #where, V is the number of vertices and E is the number of edges
        
        if len(prerequisites) == 0:
            return True
        
        indegrees = [0 for i in range(numCourses)]
        edgeMap = {}
        for edge in prerequisites:
            indegrees[edge[0]] += 1
            
            if edge[1] not in edgeMap:
                edgeMap[edge[1]] = []
            edgeMap[edge[1]].append(edge[0])
        
        de = deque()
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                de.append(i)
        
        count = 0
        while de:
            popped = de.popleft()
            count += 1
            edges = edgeMap.get(popped,[])
            for edge in edges:
                indegrees[edge] -= 1
                if indegrees[edge] == 0:
                    de.append(edge)
        
        return count == numCourses
        