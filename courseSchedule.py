# Time Complexity : O(m+n), where m is the number of courses and n is the number of edges/dependencies
# Space Complexity : O(m+n)
from collections import defaultdict, deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        if numCourses == 0:
            return True

        in_degree = [0] * numCourses
        adjacency_list = defaultdict(list)
        queue = deque()

        # Build the in-degree array and adjacency list
        for course, prereq in prerequisites:
            in_degree[course] += 1
            adjacency_list[prereq].append(course)

        # Add all courses with no prerequisites to the queue
        for i in range(numCourses):
            if in_degree[i] == 0:
                queue.append(i)

        completed_courses = 0

        # Process the queue
        while queue:
            current_course = queue.popleft()
            completed_courses += 1

            for course in adjacency_list[current_course]:
                in_degree[course] -= 1
                if in_degree[course] == 0:
                    queue.append(course)

        return completed_courses == numCourses

solution = Solution()

# Example 1
numCourses1 = 2
prerequisites1 = [[1, 0]]
print(solution.canFinish(numCourses1, prerequisites1))  # Output: True

# Example 2
numCourses2 = 2
prerequisites2 = [[1, 0], [0, 1]]
print(solution.canFinish(numCourses2, prerequisites2))  # Output: False

# Example 3
numCourses3 = 4
prerequisites3 = [[1, 0], [2, 1], [3, 2]]
print(solution.canFinish(numCourses3, prerequisites3))  # Output: True