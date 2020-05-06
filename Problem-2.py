"""
# Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)

I M NOT SURE BOUT SPACE AND TIME HERE

TIME - O(V+E)
SPACE- O(V+E)

∣V∣ is the number of courses, and |E| is the number of dependencies.
"""
from collections import defaultdict, deque

from collections import defaultdict


class Solution:
    def canFinish(self, numCourses: int, prereq: List[List[int]]) -> bool:
        indegrees = [0] * numCourses
        d = defaultdict(list)
        q = deque()

        # create indegree array/list
        for i in range(len(prereq)):
            indegrees[prereq[i][0]] += 1

            if prereq[i][1] not in d:
                d[prereq[i][1]].append(prereq[i][0])

            else:
                d[prereq[i][1]].append(prereq[i][0])

        for i in range(len(indegrees)):  # add node which has zero indegree  to queue
            if indegrees[i] == 0:
                q.append(i)

        while q:         #start BFS
            course = q.popleft()
            children = d[course]
            if children != None:
                for child in children:
                    indegrees[child] -= 1
                    if indegrees[child] == 0:
                        q.append(child)

        # check indegree array if any element greater than 0 then there is not cycle or
        for i in range(len(indegrees)):
            if indegrees[i] > 0:
                return False
        return True




courschedul =  Solution()
print(courschedul.canFinish(2, [[1, 0]]))


