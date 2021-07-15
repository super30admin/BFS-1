# Time Complexity: O(V + E), where V is numCourses and E is the num of dependencies
# Space Complexity: O(V + E)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites or len(prerequisites) == 0:
            return True

        indegree = [0 for x in range(numCourses)]
        adj_list_map = dict()
        q = deque()

        for pair in prerequisites:
            next_course, prev_course = pair[0], pair[1]
            # Update the num of dependencies in the indegree array
            indegree[next_course] += 1

            # Update the dependent courses (children) in the map
            if prev_course not in adj_list_map:
                adj_list_map[prev_course] = list()
            adj_list_map[prev_course].append(next_course)

        # Start with the course that has 0 indegree
        for course in range(len(indegree)):
            if indegree[course] == 0:
                q.append(course)

        while q:
            # Consider popped course from queue as the completed course
            course = q.popleft()

            if course in adj_list_map:
                children = adj_list_map[course]
                for child in children:
                    # Reduce the num of dependencies for its children
                    indegree[child] -= 1
                    # If there are no dependecies for a course, add to the queue
                    if indegree[child] == 0:
                        q.append(child)

        # If there are any incomplete courses, return False
        for num in indegree:
            if num != 0:
                return False

        return True







