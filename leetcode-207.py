# 207. Course Schedule
# https://leetcode.com/problems/course-schedule/
# 
# T.C: O(n)
# S.C: O(n)


from collections import defaultdict, deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        indegree = [0 for i in range(numCourses)]
        adj = defaultdict(list)

        for el in prerequisites:
            adj[el[1]]. append(el[0])
            indegree[el[0]] += 1
        q = deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)

        if len(q) == numCourses:
            return True
               
        while q:
            curr = q.popleft()

            for child in adj[curr]:
                indegree[child] -= 1
                if indegree[child] == 0:
                    q.append(child)
        print(indegree, q)
        for i in range(numCourses):
            if indegree[i] != 0:
                return False
        
        return True