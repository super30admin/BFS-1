# TC = O(e+v)
# SC = O(e+v)
# run on LC

from collections import defaultdict


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indeg = collections.defaultdict(set)
        outdeg = collections.defaultdict(set)

        for x, y in prerequisites:
            outdeg[y].add(x)
            indeg[x].add(y)

        conn = 0

        in_zero = []

        for i in range(numCourses):
            if not indeg[i]:
                in_zero.append(i)
                conn += 1

        while in_zero:
            node = in_zero.pop()
            for x in outdeg[node]:
                indeg[x].remove(node)
                if not indeg[x]:
                    in_zero.append(x)
                    conn += 1

        return conn == numCourses
