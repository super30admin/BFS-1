class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        adj = [set() for i in range(numCourses)]
        
        indegree = {i:0 for i in range(numCourses)}
        for u,v in prerequisites:
            indegree[v] += 1
            adj[u].add(v)
        
        q = collections.deque()
        for i in range(len(indegree)):
            if indegree[i] == 0:
                q.append(i)
        
        while q:
            size = len(q)
            for i in range(size):
                node = q.popleft()
                
                for neighbor in adj[node]:
                    indegree[neighbor] -= 1
                    if indegree[neighbor] == 0:
                        q.append(neighbor)
        
        return max(indegree.values()) == 0
