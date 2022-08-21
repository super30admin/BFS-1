# 207. Course Schedule

'''
Leetcode all test cases passed: Yes
class Solution:
    def canFinish(self, numCourses, prerequisites):
        V is no of courses 
        E is the no of edges or prerequisites
        Space Complexity:  O(V + E)
        Time Complexity: O(V + E)
'''
from collections import deque
class Solution:
    def canFinish(self, numCourses, prerequisites):
        adj_list = {}
        indegree = [0] * numCourses
        for i in range(numCourses):
            adj_list[i] = []
        for course,dependency in prerequisites:
                
            adj_list[dependency].append(course)
            indegree[course] += 1
        
        queue = deque([]) 
        for idx,degree in enumerate(indegree):
            if degree == 0:
                queue.append(idx)
        count = 0
        while queue:
            curr = queue.popleft()
            count += 1
            
            for children in adj_list[curr]:
                if indegree[children] != 0:
                    indegree[children] -= 1
                    if indegree[children] == 0:
                        queue.append(children)
        
        return count == numCourses
