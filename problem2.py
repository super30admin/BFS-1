# Time Complexity : O(n)
# Space Complexity : O(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

#DFS Iterative

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj=defaultdict(lambda: [])
        for item in prerequisites:
            adj[item[1]].append(item[0])
        color=[0]*numCourses
        def dfs(v,p):
            color[v]=1
            res=True
            for child in adj[v]:
                if color[child]==1:
                    return False
                if color[child]==0:
                    res&=dfs(child,v)
            color[v]=2
            return res
        ans=True
        for node in range(numCourses):
            if color[node]==0:
                ans&=dfs(node,-1)
                
        return ans

# Time Complexity : O(n)
# Space Complexity : O(1)

#DFS Recursion
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #build graph
        graph = [[] for _ in range(numCourses)]
        
        for x, y in prerequisites:
            graph[x].append(y)
        
        visited = [-1 for _ in range(numCourses)]
        
        for node in range(numCourses):
            if self.checkCycle(node, graph, visited):
                return False
        return True
    
    def checkCycle(self, v, graph, visited):
        
        if visited[v] == 1: return True
        if visited[v] == 0: return False
        
        visited[v] = 1
        
        for neighbor in graph[v]:
            if self.checkCycle(neighbor, graph, visited):
                return True
        visited[v] = 0
        return False