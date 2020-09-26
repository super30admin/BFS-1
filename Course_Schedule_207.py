
# Time- O(n)
# Space -O(n)
from collections import deque
class Solution:
    def canFinish(self, tasks: int, prerequisites: List[List[int]]) -> bool:
        ans = []
        
        graph = {n:[] for n in range(tasks)}
        
        visited = {n:0 for n in range(tasks)}
        
        for pre, cour in prerequisites:
            graph[pre] += [cour]
            
            visited[cour] +=1
            
        q = deque()
        
        for i in visited:
            if visited[i] == 0:
                q.append(i)
        
        while q:
            temp = q.popleft()
            ans.append(temp)
            
            for i in graph[temp]:
                visited[i] -=1
                if visited[i] == 0:
                    q.append(i)
        return len(ans) == tasks