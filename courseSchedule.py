# Time Complexity : O(V+E) 
# Space Complexity :    O(V+E)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

#BFS
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites)==0:
            return True
        
        indegrees = [0]*numCourses
        hashmap = {}        
        for i in prerequisites:
            ind = i[0]
            out = i[1]
            
            indegrees[ind]+=1
            
            if out not in hashmap:
                hashmap[out] = [ind]
            else:
                hashmap[out].append(ind)

        queue = deque()
        for i in range(len(indegrees)):
            if indegrees[i]==0:
                queue.append(i)
            
        
        if len(queue)==0:
            return False
        
        count = 0
        
        while(len(queue)!=0 ):
            curr = queue.popleft()
            count+=1
            if curr in hashmap:
                edges = hashmap[curr]
                if edges:
                    for e in edges:
                        indegrees[e]-=1
                        if indegrees[e]==0:
                            queue.append(e)
            

        
        if count!=numCourses:
            return False
    
        return True
    