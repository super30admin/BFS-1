# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        prereq_map = {i: [] for i in range(numCourses)}

        for course, prereq in prerequisites:
            prereq_map[course].append(prereq)

        def dfs(course, visited):
            if course in visited:
                return False

            if prereq_map[course] == []:
                return True

            visited.add(course)
            for prereq in prereq_map[course]:
                if not dfs(prereq, visited):
                    return False

            visited.remove(course)  # Remove the course from the visited set after processing its prerequisites
            prereq_map[course] = []  # No need to keep the prerequisites after they are processed
            return True

        for course in range(numCourses):
            if not dfs(course, set()):
                return False

        return True
