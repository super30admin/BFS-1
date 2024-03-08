#Time Complexity : O(V + E)
#Space Complexity : O(V + E)
#Any problem you faced while coding this : - Initially I had a lot of confusion in understanding the flow due to the intertwined dependencies.

#The approach is to use a topological sorting-based algorithm to check if there is a valid ordering of courses such that all prerequisites are met. It constructs a dependency graph represented by a dictionary (dependency_dict) and an indegree array (indegrees). The algorithm then iteratively dequeues courses with no prerequisites, updates the indegrees of their dependent courses, and enqueues courses with newly satisfied prerequisites until either all courses are considered or a cycle is detected, indicating an impossible scheduling scenario.

from collections import defaultdict, deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not len(prerequisites):
            return True

        dependency_dict = defaultdict(list)
        indegrees = [0] * numCourses

        # Build the dependency dictionary and indegrees array
        for prerequisite in prerequisites:
            indegrees[prerequisite[0]] += 1
            dependency_dict[prerequisite[1]].append(prerequisite[0])

        # Initialize the queue with courses that have no prerequisites
        q = deque()
        for course in range(numCourses):
            if indegrees[course] == 0:
                q.append(course)

        count = 0  # Count of courses with no prerequisites

        while q:
            current_course = q.popleft()
            count += 1

            # Reduce the indegree of child courses and enqueue them if indegree becomes zero
            for child_course in dependency_dict[current_course]:
                indegrees[child_course] -= 1
                if indegrees[child_course] == 0:
                    q.append(child_course)

        return count == numCourses
