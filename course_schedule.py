# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List
from collections import deque, defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        maps =defaultdict(list)
        indegrees = [0]*numCourses

        for edge in prerequisites:
            out = edge[1]
            ind = edge[0]
            indegrees[ind]+=1
            if out not in maps:
                maps[out] = []
            maps[out].append(ind)
        
        q = deque()
        count = 0

        for i in range(numCourses):
            if(indegrees[i] == 0):
                q.append(i)
                count+=1
        
        if count == numCourses: return True
        while q:
            curr = q.popleft()
            children = maps[curr]

            if children:
                for child in children:
                    indegrees[child]-=1
                    if(indegrees[child] == 0):
                        q.append(child)
                        count+=1
                        if count == numCourses: return True
        
        return False