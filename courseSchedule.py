"""
Build adjacency list from prerequisites
Use DFS to check for cycles (using visited and recursion)
If a cycle is found, return False; else, return True
"""
"""
Time Complexity: O(V + E) — V = numCourses, E = number of prerequisites
Space Complexity: O(V + E) — Adjacency list + recursion
"""

from typing import List

class courseSchedule:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for _ in range(numCourses)]
        for dest, src in prerequisites:
            adj[src].append(dest)

        visited = [0] * numCourses 

        def dfs(course):
            if visited[course] == 1: 
                return False
            if visited[course] == 2:
                return True

            visited[course] = 1
            for neighbor in adj[course]:
                if not dfs(neighbor):
                    return False
            visited[course] = 2
            return True

        for i in range(numCourses):
            if not dfs(i):
                return False
        return True
    
if __name__ == "__main__":
    obj = courseSchedule()

    print(obj.canFinish(4, [[1,0],[2,1],[3,2]]))  
    print(obj.canFinish(2, [[1,0],[0,1]]))
