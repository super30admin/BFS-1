# Time complexity: O(V + e) where V and e are the number of vertices and edges respectively
# Space complexity: O(V + e)

# The code successfully ran on Leetcode

from collections import defaultdict

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        map = defaultdict(list)
        indegrees = [0] * numCourses
        
        for p in prerequisites:
            indegrees[p[0]] += 1
            
            map[p[1]].append(p[0])
        
        q = []
        coursesCompleted = 0
        
        for i in range(numCourses):    
            if indegrees[i] == 0:
                coursesCompleted += 1
                q.append(i)
        
        while q:
            curr = q.pop(0)
            edges = map[curr]
            
            if edges:
                for e in edges:
                    indegrees[e] -= 1
                    
                    if indegrees[e] == 0:
                        coursesCompleted += 1
                        q.append(e)
                        
        return coursesCompleted == numCourses
