'''
TC= 0(V+E)
'''
from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courseDependency = [ 0 for i in range(numCourses)]
        dic = {}
        for i in range(len(prerequisites)):
            courseDependency[prerequisites[i][0]] +=1
            if prerequisites[i][1] in dic:
                dic[prerequisites[i][1]].append(prerequisites[i][0])
            else:
                dic[prerequisites[i][1]] = [prerequisites[i][0]]
       
                    
        q = deque()
        for i in range(numCourses):
            if courseDependency[i] == 0:
                q.append(i)
        
        while q:
            item = q.popleft()
            arr = []
            arr = dic.get(item)
            if arr:
                for i in arr:
                    courseDependency[i] = courseDependency[i] - 1
                    if courseDependency[i] == 0:
                        q.append(i)
        
        for i in courseDependency:
            if i != 0:
                return False
            
        return True