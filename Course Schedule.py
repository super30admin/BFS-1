""""// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0] * numCourses
        d = {}
        queue = []
        count = 0

        if not prerequisites:
            return True

        for i in prerequisites:
            indegree[i[0]] += 1
            if not i[1] in d:
                d[i[1]] = [i[0]]
            else:
                d[i[1]].append(i[0])

        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
                count += 1
        if not queue:
            return False

        while queue:
            x = queue.pop(0)
            if x not in d:
                continue
            indep = d[x]

            for i in indep:
                indegree[i] -= 1
                if indegree[i] == 0:
                    queue.append(i)
                    count += 1
                if count == numCourses:
                    return True
        if count < numCourses:
            return False
        # return True

