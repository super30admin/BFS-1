# Time Complexity :O(V+E) Where V is vertices and E is Edges
# Space Complexity :O(n) where n is total number of elements
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode :207

# There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
# You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first
# if you want to take course ai.
#
# For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
# Return true if you can finish all courses. Otherwise, return false.

# Input: numCourses = 2, prerequisites = [[1,0]]
# Output: true
# Explanation: There are a total of 2 courses to take.
# To take course 1 you should have finished course 0. So it is possible.
#
# Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
# Output: false
# Explanation: There are a total of 2 courses to take.
# # To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


from collections import defaultdict, deque


class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        myMap = defaultdict(lambda: [])
        inEdges = [0] * numCourses
        totalIn = 0
        for each in prerequisites:
            fromVal = each[1]
            to = each[0]
            inEdges[to] += 1
            totalIn += 1
            myMap[fromVal].append(to)

        courses = deque()
        for index in range(numCourses):
            if inEdges[index] == 0:
                courses.append(index)

        while courses:
            course = courses.pop()
            for each in myMap[course]:
                inEdges[each] -= 1
                totalIn -= 1
                if inEdges[each] == 0:
                    courses.append(each)

        if totalIn == 0:
            return True
        return False
noOfCourses = 6
prerequisites = [[2,0],[4,0],[1,2],[1,4],[3,2],[5,3]]

print(Solution().canFinish(noOfCourses,prerequisites))