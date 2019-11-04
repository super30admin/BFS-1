'''

https://leetcode.com/problems/course-schedule/

Reference: https://www.youtube.com/watch?v=ddTC4Zovtbc&t=443s
Did it run on leetcode: Yes
Did you face any problems: How to represent state of current exploring vertices

Time Complexity: 0(N)
Space Complexity: 0(h)

Algorithm:
- Parse the input to an graph adjacency list
- Create a list of visited vertices with initial value of 0, which has three states
    - 0: Not visited neither it is being explored state
    - 1: all the children of this node have been explored
    - -1: This node is in current state or is being explored, if you encounter this state then there exists a 
          dependancy which you cannot resolve

'''


class Solution(object):
    
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        self.graph = [ [] for i in range(numCourses) ]
        visited = [0 for _ in range(numCourses)]
        
        for prerequisite in prerequisites:
            vertex,dependency = prerequisite[0],prerequisite[1:]
            self.graph[vertex].extend(dependency)
        
        for vertex in range(numCourses):
            if not self.dfs(visited,vertex):
                return False
        
        return True
            
        
    def dfs(self,visited,vertex):
        if visited[vertex]==-1:
            return False
        if visited[vertex]==1:
            return True
        
        visited[vertex]=-1
        for adjacent in self.graph[vertex]:
            if not self.dfs(visited,adjacent):
                return False
        
        visited[vertex] = 1
        return True