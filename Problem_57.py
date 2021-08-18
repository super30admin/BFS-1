class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = [[] for _ in range(numCourses)]
        for first, second in prerequisites:
            graph[first].append(second)
        # 0 = unknown # 1 = visiting # 2 = visited
        visit = [0] * numCourses
        
        def dfs(curr, visit):
            if visit[curr] == 1: return True
            if visit[curr] == 2: return False           
            visit[curr] = 1          
            for j in graph[curr]:
                if dfs(j, visit): return True          
            visit[curr] = 2  
            return False
        
        for i in range(numCourses) :
            if dfs(i, visit): return False
        
        return True

%TC: O(m+n)
%SC: O(m+n)