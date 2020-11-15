"""
Time Complexity : O(v+e)- where v is vertices and e are edges
Space Complexity : O(n)- where n is number of courses. Please correct me if I am wrong
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


For this solution, we need to maintain an indegree array where we can store information regarding how
many courses is one course dependednt on. We are maintaining this info so as to know which courses
are independednt and so that we can start from these nodes. Also, we need to maintain a dictionary which is basically
and adjascency matrix., so that we can keep a track of what courses rae dependednt on one course. This
is being done so that we can Find it with O(1) time. Afterwards we just maintain a queue with independent
nodes inside it and traverse through the dictionary. As soon as a node becomes independednt, we add
it to the queue. At last, if all the indegrees becomes 0, that means we can complete the courses.
"""
from collections import deque


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0]*numCourses
        d = {}
        for i in prerequisites:
            a = i[0]
            b = i[1]
            indegree[a] += 1
            if b in d:
                d[b].append(a)
            else:
                d[b] = [a]
        q = deque()
        for i in range(len(indegree)):
            if indegree[i] == 0:
                q.append(i)
        while q:
            a = q.popleft()
            children = []
            children = d.get(a)
            if children:
                for i in children:
                    indegree[i] -= 1
                    if indegree[i] == 0:
                        q.append(i)
        for i in indegree:
            if i != 0:
                return False
        return True
