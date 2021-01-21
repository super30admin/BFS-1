# TC: O(V+E) Vertex + Edges, depends on which ever is larger
# SC: O(V+E) V(queue) + V+E(adjacency list)
# 1. create indegrees array 
# 2. create adjacency hashmap of prereq with dependent courses
# 3. maintain queue of courses that are independent/ become independent. Keep incrementing counter of nodes considered in the queue
# 4. if counter is equal to num of courses - True else False 

from collections import deque, defaultdict
class Solution:
    def canFinish(self, numCourses, prerequisites) -> bool:
        indeg = [0] * numCourses
        map = defaultdict(int)
        for edge in prerequisites:
            if edge[1] not in map:
                map[edge[1]] = []
            map[edge[1]].append(edge[0])
            indeg[edge[0]] += 1
        q = deque()
        for i in range(len(indeg)):
            if indeg[i] == 0:
                q.append(i)
        count = 0
        if not q: return False
        while q:
            curr = q.popleft()
            count += 1
            edges = map[curr]
            if edges:
                for edge in edges:
                    indeg[edge] -= 1
                    if indeg[edge] == 0:
                        q.append(edge)
        if count == numCourses: return True
        return False
        
        