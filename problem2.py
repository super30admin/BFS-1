# Time Complexity : O(V+E);
# Space Complexity : O(V+E);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#

class Solution:
    def canFinish(self, numCourses: int, prerequisites) -> bool:
        queue = []
        dictu = {}
        indegree = [0] * numCourses
        count = 0
        if numCourses == 0 or len(prerequisites) == 0:
            return True
        for i, k in prerequisites:
            if k not in dictu:
                dictu[k] = [i]
            else:
                dictu[k].append(i)
            indegree[i] += 1
        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(i)
                count += 1
        while queue:
            pop = queue.pop(0)
            if pop in dictu:
                for i in dictu[pop]:
                    indegree[i] -= 1
                    if indegree[i] == 0:
                        queue.append(i)
                        count += 1
                    if count == numCourses:
                        return True
        return False


print(Solution().canFinish(2, [[0, 1]]))
