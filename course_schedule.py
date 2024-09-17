# O(C + P) TIME AND SPACE WHERE C IS NO.OF COURSES AND P IS NO.OF PREREQS

from collections import defaultdict
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        courseGraph = defaultdict(list)
        for relation in prerequisites:
            nextCourse, prevCourse = relation[0], relation[1]
            courseGraph[prevCourse].append(nextCourse)
        checked = [False] * numCourses
        path = [False] * numCourses

        for currCourse in range(numCourses):
            if self.isCyclic(currCourse, courseGraph, checked, path):
                return False
        return True


    def isCyclic(self, currCourse, courseGraph, checked, path):
        if checked[currCourse]:
            return False
        if path[currCourse]:
            return True
        path[currCourse] = True
        ret = False
        for child in courseGraph[currCourse]:
            ret = self.isCyclic(child, courseGraph, checked, path)
            if ret: break
        path[currCourse] = False
        checked[currCourse] = True
        return ret