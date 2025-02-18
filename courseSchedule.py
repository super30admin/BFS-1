#Course Schedule
#Time COmplexity: O(V+E)
#Space Complexity: O(V+E) 

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0] * numCourses
        adj = {i:[] for i in range(numCourses)}

        for crs,pre in prerequisites:
            adj[pre].append(crs)
            indegree[crs] += 1
        queue = collections.deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)

        visited = 0        
        while queue:
            node = queue.popleft()
            visited += 1

            for neighbor in adj[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    queue.append(neighbor)
        return visited == numCourses