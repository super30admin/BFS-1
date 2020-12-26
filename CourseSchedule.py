class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        courses = [0 for i in range(numCourses)]
        prereqEdges = {}
        for edge in prerequisites:
            prevCourse = edge[1]
            currCourse = edge[0]
            courses[currCourse] += 1
            if prevCourse not in prereqEdges:
                prereqEdges[prevCourse] = []
            prereqEdges[prevCourse].append(currCourse)
        queue = []
        for i in range(len(courses)):
            if courses[i] == 0:
                queue.append(i)
        while queue:
            temp = queue.pop(0)
            tempChildren = prereqEdges.get(temp)
            if tempChildren:
                for child in tempChildren:
                    courses[child] -= 1
                    if courses[child] == 0:
                        queue.append(child)
        for val in courses:
            if val != 0:
                return False
        return True

        