#Time complexity: O(|E| + |V|)
#Space Complexity: O(|E| + |V|)
from typing import List
from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites) == 0:
            return True
        hashmap = {}
        indegrees = [0] * numCourses
        
        for i in range(len(prerequisites)):
            indegrees[prerequisites[i][0]] += 1
            if prerequisites[i][1] not in hashmap: #We are checking if we have corresponding entry of that course in hashmap
                hashmap[prerequisites[i][1]] = [] #If not then add the empty list
            hashmap[prerequisites[i][1]].append(prerequisites[i][0]) #add the dependents to the corresponding independent course
        
        q = deque()
        count = 0
        
        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)
                count += 1
        
        while q:
            curr = q.popleft()
            if curr in hashmap:
                for child in hashmap[curr]:
                    indegrees[child] -= 1
                    if indegrees[child] == 0:
                        q.append(child)
                        count += 1
                        if count == numCourses:
                            return True
        
        return False




