# Time Complexity : O(V + E), where V is the number of courses (vertices) and E is the number of prerequisite pairs (edges)
# Space Complexity : O(V + E), for adjacency list and indegree array
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from collections import defaultdict, deque
from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # Topological Sort Using Kahn's Algorithm
        adj = defaultdict(list)
        indegree = [0] * numCourses

        for dst, src in prerequisites:
            adj[src].append(dst)
            indegree[dst] += 1

        # Initialize queue with nodes having 0 indegree (no prerequisites)
        q = deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)

        visited_count = 0  # To count how many nodes we can complete

        # Process nodes in topological order
        while q:
            node = q.popleft()
            visited_count += 1
            for nei in adj[node]:
                indegree[nei] -= 1
                if indegree[nei] == 0:
                    q.append(nei)

        # If all courses can be completed, return True
        return visited_count == numCourses
    

#------------------------------------------------------------------------------------------------

        # DFS (Cycle detection)
        # graph = defaultdict(list)
        # for course, prereq in prerequisites:
        #     graph[prereq].append(course)  # Edge from prereq → course

        # # State definitions
        # UNVISITED = 0
        # VISITING = 1
        # VISITED = 2

        # # Track visit state of each node
        # state = [UNVISITED] * numCourses

        # def dfs(node):
        #     if state[node] == VISITING:
        #         # Found a cycle
        #         return False
        #     if state[node] == VISITED:
        #         # Already checked this node, no cycle here
        #         return True

        #     # Mark the node as visiting
        #     state[node] = VISITING

        #     # Visit all neighbors (i.e., all courses that depend on this one)
        #     for neighbor in graph[node]:
        #         if not dfs(neighbor):
        #             return False

        #     # After visiting all neighbors, mark it as visited
        #     state[node] = VISITED
        #     return True

        # # Run DFS for all nodes
        # for i in range(numCourses):
        #     if not dfs(i):
        #         return False

        # return True
