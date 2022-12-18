""" 
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Time Complexity: O(V + E) = O(n)
Space Complexity: O(V + E) = O(n)
"""

def canFinish(numCourses, prerequisites):
    
    graph = {i:[] for i in range(numCourses)}
    for i, j in prerequisites:
        graph[i].append(j)
    
    visited = [0] * numCourses
    
    
    def dfs(node):
        if visited[node] == -1:
            return False
        if visited[node] == 1:
            return True
        
        visited[node] = -1
        
        for neighbor in graph[node]:
            if not dfs(neighbor):
                return False
        
        visited[node] = 1
        
        return True
    
    for node in range(numCourses):
        if not dfs(node):
            return False
    
    return True


#using topological sort
def canFinish(numCourses, prerequisites):
        
        graph = {i:[] for i in range(numCourses)}
        indegree = [0] * numCourses
        
        for i, j in prerequisites:
            graph[j].append(i)
            indegree[i] += 1
        
        queue = []
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
        
        count = 0
        while queue:
            node = queue.pop(0)
            count += 1
            
            for neighbor in graph[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    queue.append(neighbor)
        
        return count == numCourses