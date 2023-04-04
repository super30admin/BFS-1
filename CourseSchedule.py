# Time Complexity : O(C + P) where C : Number of course and P : Number of prerequisites
# Space Complexity : O(C + P) where C : Number of course and P : Number of prerequisites
from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # Step 1: Create an adjacency list to represent the graph
        graph = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses
        
        for u, v in prerequisites:
            graph[v].append(u)  # add edge from v to u
            indegree[u] += 1    # increase indegree of u
        
        # Step 2: Add nodes with zero incoming edges to the queue
        queue = []
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
        
        # Step 3: Remove nodes with zero incoming edges iteratively
        count = 0
        while queue:
            u = queue.pop(0)
            count += 1
            
            for v in graph[u]:
                indegree[v] -= 1
                
                if indegree[v] == 0:
                    queue.append(v)
        
        return count == numCourses