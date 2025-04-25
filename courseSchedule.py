from collections import deque
from typing import List


# Approach: BFS (Topological Sort using Kahn’s Algorithm)
# Time Complexity: O(V + E), where V = numCourses and E = len(prerequisites)
# Space Complexity: O(V + E) for adjacency list and in-degree array
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # Build adjacency list and in-degree array
        adj = {i: [] for i in range(numCourses)}
        in_deg = [0] * numCourses

        for crs, pre in prerequisites:
            adj[pre].append(crs)  # edge from pre → crs
            in_deg[crs] += 1  # crs has one more prereq

        # Start with courses having no prereqs (in-degree 0)
        queue = deque([i for i in range(numCourses) if in_deg[i] == 0])
        completed = 0

        # Process courses in topological order
        while queue:
            course = queue.popleft()
            completed += 1  # count completed course
            for nei in adj[course]:
                in_deg[nei] -= 1  # remove dependency
                if in_deg[nei] == 0:
                    queue.append(nei)

        # If all courses are completed → return True
        print("Can finish (BFS):", completed == numCourses)
        return completed == numCourses


# Approach: DFS (Cycle Detection)
# Time Complexity: O(V + E)
# Space Complexity: O(V + E) for the recursion stack, adjacency list, and visit set


class SolutionDFS:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # Build adjacency list
        adj = {i: [] for i in range(numCourses)}
        for crs, pre in prerequisites:
            adj[crs].append(pre)

        visit = set()  # tracks current path

        def dfs(crs):
            if crs in visit:  # cycle detected
                return False
            if not adj[crs]:  # no prereqs
                return True

            visit.add(crs)  # mark as visiting
            for pre in adj[crs]:
                if not dfs(pre):  # recurse on prereqs
                    return False
            visit.remove(crs)  # done visiting
            adj[crs] = []  # mark course as completed
            return True

        # Run DFS on each course
        for i in range(numCourses):
            if not dfs(i):
                print("Can finish (DFS): False")
                return False

        print("Can finish (DFS): True")
        return True


# Example usage
numCourses = 4
prereq = [[1, 0], [2, 1], [3, 2]]  # valid order

Solution().canFinish(numCourses, prereq)
SolutionDFS().canFinish(numCourses, prereq)
