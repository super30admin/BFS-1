'''TC:O(N)
sc:O(1)
'''


import collections
class Solution:
    def canFinish(self, n: int, a) -> bool:
        novisit = 0
        visit = 1
        visited = 2
        
        def dfs(course):
            if state[course] == visit:
                return True
            if state[course] == visited:
                return False
            state[course] = visit
            
            for j in g[course]:
                if dfs(j):
                    return True
            state[course] = visited
            return False
        g = collections.defaultdict(list)
        
        for k, v in a:
            g[k].append(v)
            
        state = [novisit for i in range(n)]
        
        return all(dfs(i)==False for i in range(n))