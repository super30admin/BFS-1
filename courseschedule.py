##Time Complexity : O(V+E)
##Space Complexity : O(V+E)
##Did this code successfully run on Leetcode : Yes
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        courses = collections.defaultdict(set)
        pres = collections.defaultdict(set)
        for course, pre in prerequisites:
            courses[course].add(pre)
            pres[pre].add(course)
        no_pre_courses = [n for n in range(numCourses) if not courses[n]]
        count = 0
        while no_pre_courses:
            no_pre = no_pre_courses.pop()
            count+=1
            for course in pres[no_pre]:
                courses[course].remove(no_pre)
                if not courses[course]:
                    no_pre_courses.append(course)
        return count == numCourses
        