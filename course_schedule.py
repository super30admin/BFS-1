# Time Complexity : O(V+E);        V is vertices and E is edges
# Space Complexity : O(V+E);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def canFinish(self, numCourses: int, prerequisites) -> bool:
        q = []
        hmap = {}
        indegree = [0] * numCourses
        count = 0
        if numCourses == 0 or len(prerequisites) == 0:
            return True
        for i, k in prerequisites:
            if k not in hmap:
                hmap[k] = [i]
            else:
                hmap[k].append(i)
            indegree[i] += 1
        for i in range(len(indegree)):
            if indegree[i] == 0:
                q.append(i)
                count += 1
        while q:
            pop = q.pop(0)
            if pop in hmap:
                for i in hmap[pop]:
                    indegree[i] -= 1
                    if indegree[i] == 0:
                        q.append(i)
                        count += 1
                    if count == numCourses:
                        return True
        return False
