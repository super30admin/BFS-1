# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I create adjacancy list and indegrees. Add 0 indegrees vertices to queue. While q is not empty
# pop a vertex. Decrease the indegrees of the vertices that can be reached by popped vertex. If
# new indegrees is 0 add the vertex to queue. Finally if all indegrees are 0 return True else False

from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj_list = defaultdict(lambda: [])
        indegrees = [0 for x in range(numCourses)]
        for prerequisite in prerequisites:
            adj_list[prerequisite[1]].append(prerequisite[0])
            indegrees[prerequisite[0]]+=1
            
        q = deque()
        
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                q.append(i)
                
        while len(q) > 0:
            n_v = q.popleft()
            adj = adj_list[n_v]
            for d in adj:
                indegrees[d] -= 1
                if indegrees[d] == 0:
                    q.append(d)
                    
        for indegree in indegrees:
            if indegree > 0:
                return False
            
        return True
                
            
        
            
        