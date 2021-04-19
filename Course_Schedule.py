from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0]*numCourses
        adjList = [[] for _ in range(numCourses)]
        coursesTaken = 0
        
        ### Create InDegree and Adjacency List
        for a,b in prerequisites:
            indegree[a] += 1
            adjList[b].append(a)
        
        ### Get all independent courses
        queue = deque()   
        for node, deg in enumerate(indegree):
            if not deg:
                queue.append(node)

        ### Run BFS
        while queue:
            node = queue.popleft()
            coursesTaken += 1
            for child in adjList[node]:
                indegree[child] -= 1
                if not indegree[child]:
                    queue.append(child)
                    
        return coursesTaken == numCourses

### Complexity Analysis

# Time Complexity: O(V+E) --> For each vertex, we visit all the edges during BFS
# Space Complexity:  O(V+E) --> We store adj List which consists of all the edges for all vertices.