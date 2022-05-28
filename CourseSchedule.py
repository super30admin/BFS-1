#Time complexity: O(numCourses+prerequisites)
#Space complexity: O(numCourses+prerequisites)
from collections import deque


class Solution:
    def canFinish(self, numCourses: int, prerequisites) -> bool:
        dict1={}
        q=deque()
        indegree=[0]*(numCourses)
        for p in prerequisites:
            if p[1] not in dict1:
                dict1[p[1]]=[]
            dict1[p[1]].append(p[0])
            indegree[p[0]]+=1
        for i in range(numCourses):
            if indegree[i]==0:
                q.append(i)
        while q:
            curr=q.popleft()
            if curr in dict1:
                for prereq in dict1[curr]:
                    indegree[prereq]-=1
                    if indegree[prereq]==0:
                        q.append(prereq)
        for i in range(numCourses):
            if indegree[i]>0:
                return False
        return True
        