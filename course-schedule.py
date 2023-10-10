# TC: O(E+V) where E is Edges, V is vertices
# SC: O(E+V)


class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if len(prerequisites) == 0:
            return True
        course_map = {i: [] for i in range(numCourses)}
        course_arr = [0 for i in range(numCourses)]
        queue = collections.deque()
        count = 0

        for course,prereq in prerequisites:
            course_map[prereq].append(course)
            course_arr[course] += 1

        for i in range(len(course_arr)):
            if course_arr[i] == 0:
                queue.append(i)
                count +=1

        while queue:
            curr = queue.popleft()
            if course_map.get(curr):
                courses = course_map[curr]
                for course in courses:
                    course_arr[course] -= 1
                    if course_arr[course] == 0:
                        queue.append(course)
                        count +=1
                        if count == numCourses:
                            return True
        return False