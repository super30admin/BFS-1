# // Time Complexity : O(V + E)
# // Space Complexity : O(V + E)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
from collections import deque


class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        #   adjacency list
        #   indegree
        adj = {}
        degree = {}

        for course in range(numCourses):
            degree[course] = 0

        for course, prereq in prerequisites:
            degree[course] += 1
            if prereq not in adj:
                adj[prereq] = []
            adj[prereq].append(course)

        queue = deque([])

        for course, deg in degree.items():
            if deg == 0:
                queue.append(course)

        if not queue:
            return False

        while queue:
            prereq = queue.popleft()
            if prereq in adj:
                for subject in adj[prereq]:
                    degree[subject] -= 1
                    if degree[subject] == 0:
                        queue.append(subject)

        for key, val in degree.items():
            if val != 0:
                return False
        return True