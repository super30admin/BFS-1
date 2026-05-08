from collections import deque


class Solution:
    def canFinish(self, numCourses, prerequisites):
        adj = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses
        for a, b in prerequisites:
            adj[b].append(a)
            indegree[a] += 1

        q = deque()
        courseRemain = numCourses

        for idx, count in enumerate(indegree):
            if count == 0:
                q.append(idx)

        while q:
            front = q.popleft()
            courseRemain -= 1
            if courseRemain == 0:
                return True
            for node in adj[front]:
                indegree[node] -= 1
                if indegree[node] == 0:
                    q.append(node)
        return False
