from collections import deque
from collections import defaultdict


# Time Complexity: O(E+ V)
# Space COmplexity: O(E+V)
class Solution(object):
    #     DFS approach
    def hasCycle(self, course, depmap, visited, path):
        result = False
        #         Base case with visted and path
        if visited[course]:
            return False

        if path[course]:
            return True

        #       logic
        #       adding current course to the apth
        path[course] = True

        #         Iterating over all the courses for current course as dependency
        #          and check cycle on that course if true break the loop
        for c in depmap[course]:
            if self.hasCycle(c, depmap, visited, path):
                result = True
                break
        #         If no cycle found then we will remove curren course from path
        path[course] = False
        #         and add it to the visited node and return the result
        visited[course] = True

        return result

    def DfsSchedule(self, courses, dependencies):
        #
        #         Initializing the dependency map with key as dependency and value as courses
        depmap = defaultdict(list)

        for dep in dependencies:
            dep, c = dep[1], dep[0]
            depmap[dep].append(c)

        #         initialize two arrays one as visited and one as path
        visited = [False] * courses
        path = [False] * courses
        #         We will call hasCycle function on every course and if cycyle found on any of the course we will return False
        for course in range(courses):
            if self.hasCycle(course, depmap, visited, path):
                return False

        return True

    def BfsSchedule(self, numCourses, prerequisites):
        #       initilazing the queue
        # and two hashmap for prerequisite and course and course and no of dependencies
        queue = deque()
        premap = defaultdict(list)
        countmap = {}
        count = 0

        #         Iterate over the prereuisite and fill both the maps
        for p in prerequisites:

            pre = p[1]
            c = p[0]

            premap[pre].append(c)
            # if pre in premap:
            #     premap[pre].append(c)
            # else:
            #     premap[pre] = [c]

            if c in countmap:
                countmap[c] += 1
            else:
                countmap[c] = 1

        #        As we know the number of courses , so we will iterate over and check if any course is not present in map then it has no prerequisite
        for i in range(numCourses):
            if i not in countmap:
                queue.append(i)

        # print(countmap)
        # print(premap)
        #         if
        if len(queue) == 0:
            return False

        while len(queue) != 0:
            node = queue.popleft()
            count += 1
            # print(node)

            if node in premap:
                course_list = premap[node]

                for c in course_list:
                    countmap[c] -= 1
                    if countmap[c] == 0:
                        queue.append(c)

        if count == numCourses:
            return True

        return False

    def canFinish(self, numCourses, prerequisites):

        return self.BfsSchedule(numCourses, prerequisites)
        return self.DfsSchedule(numCourses, prerequisites)

        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
