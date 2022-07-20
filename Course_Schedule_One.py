class Solution:
    def canFinish(self, n: int, prerequisites: List[List[int]]) -> bool:
        visited=set()
        graph=collections.defaultdict(list)
        for u,v in prerequisites:
            graph[u].append(v)
            
        checked=set()
            
        def dfs(u):
            if u in visited:
                return True
            
            if u in checked:
                return False
            
            visited.add(u)
            
            l=False
            
            for v in graph[u]:
                l=dfs(v)
                if l:
                    break
                    
            visited.remove(u)
            
            checked.add(u)
            return l
            
        for i in range(n):
            if dfs(i):
                return False
        return True
            
        
        