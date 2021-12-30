# BFS Approach
# Time Complexity : O(V + E) as we pick up every vertex and traverse through its children
# Space Complexity : O(V + E) for the hashmap
from collections import deque, defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites) -> bool:
        if numCourses == 0: return True
        d = defaultdict(list)
        indegrees = [0] * numCourses
        q = deque()
        total = 0

        for edge in prerequisites:
            indegrees[edge[0]] += 1
            if (edge[1] not in d):
                d[edge[1]] = []
            d[edge[1]].append(edge[0])

        for i in range(len(indegrees)):
            if (indegrees[i] == 0):
                q.append(i)
        while q:
            curr = q.popleft()
            total += 1
            depCourses = d[curr]
            if (depCourses != None):
                for edge in depCourses:
                    indegrees[edge] -= 1
                    if indegrees[edge] == 0:
                        q.append(edge)

        return total == numCourses


# DFS Approach
# Time Complexity - O(V + E)
# Space Complexity - O(V + E)
class Solution:
    def canFinish(self, numCourses: int, prerequisites) -> bool:
        # For every course, map it to an empty list
        preMap = {i: [] for i in range(numCourses)}
        for crs, pre in prerequisites:
            preMap[crs].append(pre)

        # Visit set = all courses along the curr DFS path
        visitSet = set()

        def dfs(crs):
            # Visiting the same course twice, which means loop
            if crs in visitSet:
                return False
            if preMap[crs] == []:
                return True

            visitSet.add(crs)
            for pre in preMap[crs]:
                if not dfs(pre):
                    return False

            visitSet.remove(crs)
            # As we know that this course can be visited, we can set it to empty list
            preMap[crs] = []
            return True

        # Loop through all the courses
        for crs in range(numCourses):
            if not dfs(crs):
                return False
        return True