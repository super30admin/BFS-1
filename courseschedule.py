from collections import deque

class Solution:
    def canFinish(self, numCourses, prerequisites):
        graph = {i: [] for i in range(numCourses)}
        indegree = [0] * numCourses

        for course, prereq in prerequisites:
            graph[prereq].append(course)
            indegree[course] += 1

        q = deque()

        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)

        visited = 0

        while q:
            node = q.popleft()
            visited += 1

            for nei in graph[node]:
                indegree[nei] -= 1

                if indegree[nei] == 0:
                    q.append(nei)

        return visited == numCourses

    # TC - O(V+E)
    # Build graph O(V)
    # Build edges O(E)
    # Initialize queue O(V)
    # BFS O(V + E)
    # Total TC O(V + E)

    # SC - O(V+E)
    # Adjacency list: O(V + E)
    # Indegree array: O(V)
    # Queue: up to O(V)