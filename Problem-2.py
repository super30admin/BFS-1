#Approach
# We will use topplogical sort to find the cycle or course schedule. First we take non dependent courses and finish.
#reduce the dependent n degree by 1 if that ndegree is zro add to the queue process untill queue is full.
# if any ndegrre is left then it not possible to complete

#Complexities
#Time: O(V+E)
#Space: O(V)

from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        ndegrees = [0] * numCourses
        hashMap = {}

        coursesTaken = 0

        queue = []
        for [dep, c] in prerequisites:
            ndegrees[dep] += 1
            if c not in hashMap:
                hashMap[c] = []
            hashMap[c].append(dep)

        for i in range(len(ndegrees)):
            if ndegrees[i] == 0:
                queue.append(i)
                coursesTaken += 1

        if coursesTaken == numCourses:
            return True

        while queue:
            course = queue.pop(0)
            if course in hashMap:
                for dep in hashMap[course]:
                    ndegrees[dep] -= 1
                    if ndegrees[dep] == 0:
                        coursesTaken += 1
                        queue.append(dep)
        return coursesTaken == numCourses






