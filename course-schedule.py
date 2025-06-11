
"""
Time - O(V+E)
Space - O(V+E)
Runs on leetcode - YES
"""

class Solution:
    def canFinish(self, numCourses: int, pre: List[List[int]]) -> bool:
        hashmap = {}
        indegrees = [0] * numCourses

        for dep, ind in pre:
            indegrees[dep] += 1
            if ind not in hashmap:
                hashmap[ind] = []
            hashmap[ind].append(dep)

        q = deque()
        count = 0

        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)

        while q:
            curr = q.popleft()
            count += 1
            for child in hashmap.get(curr, []):
                indegrees[child] -= 1
                if indegrees[child] == 0:
                    q.append(child)

        return count == numCourses