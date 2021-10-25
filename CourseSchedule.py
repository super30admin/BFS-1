# Time complexity: O(n)
# Space complexity: O(n)

import collections


class Solution:
    UNVISITED, VISITING, VISITED = 0, 1, 2
    # if cycle - cannot finish all courses

    def canFinish(self, numCourses: int, prerequisites):
        # construct adjacency list for precourse-[courses]
        graph = collections.defaultdict(list)
        for course, precourse in prerequisites:
            graph[precourse].append(course)
        # mark each course unvisited at first
        courseState = [self.UNVISITED for i in range(numCourses)]
        # begin traversal to check for cycle
        for course in range(numCourses):
            if self.hasCycle(course, graph, courseState):
                return False

        return True

    def hasCycle(self, course, graph, courseState):
        if courseState[course] == self.VISITING:
            return True
        if courseState[course] == self.VISITED:
            return False
        courseState[course] = self.VISITING
        for neigh in graph[course]:
            if self.hasCycle(neigh, graph, courseState):
                return True
        courseState[course] = self.VISITED
        return False
