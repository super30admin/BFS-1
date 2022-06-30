'''
Time Complexity: O(V+E)
Space Complexity: O(V+E)
Run on Leetcode: YES
'''
from collections import deque


class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        if len(prerequisites) == 0:
            return True
        indegree = [0] * numCourses
        hmap = {}
        for curr in prerequisites:
            indegree[curr[0]] += 1
            if not curr[1] in hmap.keys():
                hmap[curr[1]] = []
            hmap[curr[1]].append(curr[0])
        queue = deque()
        count = 0
        for index in range(len(indegree)):
            if indegree[index] == 0:
                count += 1
                queue.append(index)
        while len(queue) != 0 and count != numCourses:
            curr = queue.popleft()
            if curr in hmap.keys():
                for val in hmap[curr]:
                    indegree[val] -= 1
                    if indegree[val] == 0:
                        count += 1
                        queue.append(val)
                        if count == numCourses:
                            return True
        return False