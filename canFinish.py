#207. Course Schedule
# Time Complexity : O(v*e)
# Space Complexity :O(v*e)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes
# I am getting wrong output ie false instead of true for 1 test case ie 2 [[0,1]] . I am unable to figure out the error here.
from collections import deque, defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not numCourses:
            return False 
        indegree = [0]*numCourses
        dic = defaultdict(lambda : [])
        for edges in prerequisites:
            indegree[edges[0]] += 1
            dic[edges[1]].append(edges[0])
        
        queue = []
        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(indegree[i])
        
        while queue:
            key = queue.pop(0)
            curr = dic[key]
            for i in range(len(curr)):
                indegree[curr[i]] -= 1
                if indegree[curr[i]] == 0:
                    queue.append(curr[i])
        for i in range(len(indegree)):
            if indegree[i] > 0:
                return False
        return True