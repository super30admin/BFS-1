# Time Complexity: O(N)
# Space Complexity: O(N)
# Did not pass leetcode : Not completely sure when it fails
#  
from collections import deque
class Solution:
    
    def create_edge_list(self, numCourses, prerequisites):
        edge_list = [[] for i in range(numCourses)]
        
        for i in range(len(prerequisites)):
            
            i, j = prerequisites[i]
            
            edge_list[i].append(j)
        return edge_list
    
    def bfs(self, vertice):
        queue = deque()
        
        queue.append(vertice)
            
        while len(queue) > 0:

            vertice = queue.popleft()
            
            if len(self.edge_list[vertice]) > 0:
                self.visited.add(vertice)
            else:
                continue
            
            for edge in self.edge_list[vertice]:
                
                if edge in self.visited:
                    return False
                
                queue.append(edge)
        return True
        
    
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        
        self.edge_list = self.create_edge_list(numCourses, prerequisites)
        print(self.edge_list)
        self.visited = set()
        for i in range(len(self.edge_list)):
            
            edges = self.edge_list[i]
            
            if len(edges) == 0 or i in self.visited:
                continue
                
            valid = self.bfs(i)
    
            if not valid:
                return False
            
        return True
            
        