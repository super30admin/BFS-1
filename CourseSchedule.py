#TC: O(V + E)
#SC: O(V + E)

from collections import deque


class Solution(object):

    def canFinish(self, numCourses, prerequisites):
        
        if (prerequisites == None or len(prerequisites) == 0):
            return True

        requiredCourseCount = [0 for i in range(numCourses)]             

        prereqForCoursesList = { i : [] for i in range(numCourses) }         

        for prereq in prerequisites:
            requiredCourseCount[prereq[0]] += 1
            prereqForCoursesList[prereq[1]].append(prereq[0])

        queue = deque([])

        for course in range(numCourses):

            if (requiredCourseCount[course] == 0):
                queue.append(course)

        while (len(queue) > 0):

            completedCourse = queue.popleft()

            for course in prereqForCoursesList[completedCourse]:

                requiredCourseCount[course] -= 1

                if (requiredCourseCount[course] == 0):
                    queue.append(course)

        for course in range(numCourses):

            if (requiredCourseCount[course] != 0):
                return False

        return True