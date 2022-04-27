class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        self.graph = {}
        for i in range(numCourses):
            self.graph[i] = []
        
        for i in prerequisites:
            self.graph[i[0]].append(i[1])
                
        # print(self.graph)
        
        visited = [-1] * numCourses
        stack = [-1] * numCourses
        
        res = self.dfs(0, visited, stack, numCourses)
        # print(res)
        return res
        
    
    
    
    def dfs(self, node, visited, stack, numCourses):
            
        for i in range(numCourses):
            if visited[i] == -1:
                call = self.dfshelper(i, visited, stack)
                if call == False:
                    return False
                
        return True
                
                    
    
    
    def dfshelper(self, node, visited, stack):
        # print("i",node)
        visited[node] = 1
        stack[node] = 1
            
        for neig in self.graph[node]:
            if stack[neig] == 1:
                # print("stack")
                return False
                
            elif visited[neig] == -1:
                recursive = self.dfshelper(neig, visited, stack)
                if recursive == False:
                    return False
                
        stack[node] = -1
        return True
    
    