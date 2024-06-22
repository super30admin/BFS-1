# Time O(E+V)
# Space O(E+V)
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        in_degree = [0]*numCourses
        adj_list = {i:[] for i in range(numCourses)}
        count = 0 
        queue = deque()

        # init graph 
        for to, fro in prerequisites:
            adj_list[to].append(fro)
            in_degree[fro] += 1
        # add nodes to queue 
        for i in range(numCourses):
            if in_degree[i] == 0:
                queue.append(i)
        # bfs
        while queue:
            node = queue.popleft()
            count += 1
            for edge in adj_list[node]:
                in_degree[edge] -= 1
                if in_degree[edge] == 0:
                    queue.append(edge)
            
        return count == numCourses


        