# Time Complexity : O(V+E), where V is the number of courses/Vertices and E is the number of dependencies/Edges
# Space Complexity : O(V+E), where V is the number of courses/Vertices and E is the number of dependencies/Edges
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

from collections import deque
from typing import List

class Solution:

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        q = deque() # Initializing queue
        indegrees = [0] * numCourses # Intiailizing  indegrees array to store count of dependent on particular index/course
        adjajency = {} # Adjajency hashmap to store Indexpendent course as key and list of dependent course as value to access faster
        count = 0 # initializing count which would be incremented when a course has been satisfied

        for pair in prerequisites: # Iterating the list of tuples
            dep = pair[0] # first course is dependent
            indep = pair[1] # second course is independent

            indegrees[dep] += 1 # increasing the count of dependencies on each course

            if indep not in adjajency: 
                adjajency[indep] = []

            adjajency[indep].append(dep) # Adding the dependent course to its independent course
        
        for idx, num in enumerate(indegrees): # storing courses with 0 dependencies in q and increasing count
            if num == 0:
                q.append(idx)
                count += 1

        while len(q): # If any course with 0 dependencies present, otherwise skip
            curr = q.pop() 
            if curr not in adjajency: # Handling Null if no dependency on any course
                continue
            dep_list = adjajency[curr]
            for num in dep_list:
                indegrees[num] -= 1 # Reducing the dependency of that course OR completing pre req
                if indegrees[num] == 0:
                    q.append(num)
                    count += 1

        if count == numCourses: # At the end if count is equal to nuCourses, it means we can complete all the courses 
            return True
        
        return False
