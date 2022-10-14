# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes
from typing import List
from collections import defaultdict, deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0:
            return True
        indegrees = [0] * numCourses
        adj_list = defaultdict(list)
        
        for edge in prerequisites:
            incoming = edge[0]
            outgoing = edge[1]
            
            indegrees[incoming] += 1
            
            adj_list[outgoing].append(incoming)
        
        q = deque()
        courses_completed = 0
        
        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)
                courses_completed += 1
        
        
        #start BFS
        while(q):
            curr = q.popleft()
            edges = adj_list.get(curr)
            
            if(edges):
                for edge in edges:
                    indegrees[edge] -= 1
                    if indegrees[edge] == 0:
                        q.append(edge)
                        courses_completed += 1
        
        return (courses_completed == numCourses)
    