# Time Complexity : O(V + E), where V is the number of courses (vertices) and E is the number of prerequisites (edges)
# Space Complexity : O(V + E), for the adjacency list and the visited state tracking
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used Depth-First Search (DFS) to detect cycles in the graph formed by course prerequisites.
# I represented the course dependencies as a directed graph using an adjacency list.
# While performing DFS, I used a state array to track nodes in the recursion stack (visited during current path).
# If I found a node that was already in the current path, it meant a cycle exists, so I returned False.
# If no cycles were detected, all courses can be completed.

from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        from collections import defaultdict

        # Build adjacency list
        graph = defaultdict(list)
        for course, prereq in prerequisites:
            graph[course].append(prereq)

        visited = [0] * numCourses  # 0 = unvisited, 1 = visiting, 2 = visited

        def dfs(course):
            if visited[course] == 1:
                return False  # cycle detected
            if visited[course] == 2:
                return True   # already processed

            visited[course] = 1  # mark as visiting
            for neighbor in graph[course]:
                if not dfs(neighbor):
                    return False

            visited[course] = 2  # mark as fully processed
            return True

        for course in range(numCourses):
            if not dfs(course):
                return False

        return True
