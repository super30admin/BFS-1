# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites) == 0:
            return True
        
        inDeg = [0 for _ in range(numCourses)]
        hMap = {}
        cLeft = numCourses
        q = deque()
        
        for i in prerequisites:
            inDeg[i[0]] += 1
            if i[1] not in hMap.keys():
                hMap[i[1]] = [i[0]]
            else:
                hMap[i[1]].append(i[0])
        
        for i in inDeg:
            if i == 0:
                cLeft -= 1
        
        
        for i in range(numCourses):
            if inDeg[i] == 0:
                q.append(i)
                
        while len(q) != 0 and cLeft != 0:
            curr = q.popleft()
            if curr in hMap.keys():
                for i in hMap[curr]:
                    inDeg[i] -= 1
                    
                    if inDeg[i] == 0:
                        cLeft -= 1
                        q.append(i)
                        
        if cLeft == 0:
            return True
        else:
            return False