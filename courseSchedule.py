#Time Complexity: O(V+E)
#Space Complexity: O(V*E)

from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        cnt = 0
        if prerequisites is None or len(prerequisites) == 0:
            return True
        inDegree = [0 for i in range(numCourses)]
        q = deque()
        cMap = dict()
        
        for edge in prerequisites:
            inDegree[edge[0]] += 1
            
            if edge[1] not in cMap:
                cMap[edge[1]] = []
                
            cMap[edge[1]].append(edge[0])
        
        for i in range(len(inDegree)):
            if inDegree[i] == 0:
                q.appendleft(i)
                cnt += 1
        
        while q:
            curr = q.pop()
            li = cMap.get(curr)
            if li:
                for i in range(len(li)):
                    inDegree[li[i]] -= 1
                    if inDegree[li[i]] == 0:
                        q.appendleft(li[i])
                        cnt += 1
                        if cnt == numCourses:
                            return True
        
        return False
            
                
        
        
        
