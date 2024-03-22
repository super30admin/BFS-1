#TC: O(n)
#SC: O(n)

from collections import deque, defaultdict

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0:
            return True

        indegrees = [0] * numCourses
        graph = defaultdict(list)

        for req in prerequisites:
            in_course, out_course = req
            indegrees[in_course] += 1
            if out_course not in graph:
                graph[out_course] = []
            graph[out_course].append(in_course)

        queue = deque()
        for i in range(numCourses):
            if indegrees[i] == 0:
                queue.append(i)

        while queue:
            curr = queue.popleft()
            edges = graph[curr]
            if not edges:
                continue
            for edge in edges:
                indegrees[edge] -= 1
                if indegrees[edge] == 0:
                    queue.append(edge)

        for degree in indegrees:
            if degree != 0:
                return False

        return True
